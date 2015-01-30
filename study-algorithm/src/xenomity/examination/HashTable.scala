package xenomity.examination

import scala.collection.mutable.MutableList

/*
 * Hash Table
 * 
 * Collision 회피 방법: LinkedList.
 * Hash 방법: x mod m (x: key's hash code, m: table size)
 */
class HashTable {

  private var capacity: Int = 128;
  private var pool:Array[MutableList[HashEntry]] = new Array[MutableList[HashEntry]](capacity);
  
  private def hash(key: String): Int = {
    return key.hashCode() % capacity;
  }
  
  /*
   * Put
   */
  def put(key: String, value: String) {
    var hash: Int = this.hash(key);
    var elements = pool(hash);
    
    if (elements == null) {
      // 해당 해시 주소가 비어있다면 단순 삽입.
      pool(hash) = MutableList(new HashEntry(key, value));
    } else {
      // 해당 해시 주소에 동일한 키값의 데이터가 존재한다면 overwrite.
      // 아니면 추가.
      var duplicatedIndex = -1;
      
      for (i <- 0 to elements.size - 1) {
        if (elements(i).getKey() == key) {
          duplicatedIndex = i;
        }
      }
      
      if (duplicatedIndex > -1) {
        pool(hash)(duplicatedIndex) = new HashEntry(key, value);
      } else {
    	  pool(hash) += new HashEntry(key, value);
      }
    }
  }
  
  /*
   * Get
   */
  def get(key: String): String = {
    var hash: Int = this.hash(key);
    
    if (pool(hash) == null) {
      return null;
    }
    
    var element = pool(hash);
    
    for (i <- 0 to element.size - 1) {
      if (element(i).getKey() == key) {
        return element(i).getValue();
      }
    }
    
    return null;
  }
  
  /*
   * Remove
   */
  def remove(key: String) {
    var hash: Int = this.hash(key);
    var element = pool(hash);
    var tempList = MutableList[HashEntry]();
    
    if (element != null) {
      for (i <- 0 to element.size - 1) {
        if (element(i).getKey() != key) {
          tempList += new HashEntry(element(i).getKey(), element(i).getValue());
        }
      }
      
      pool(hash) = tempList;
    }
  }
  
  override def toString(): String = {
    pool.mkString("\n");
  }
  
  private class HashEntry(key: String, value: String) {
    def getKey(): String = { key };
    def getValue(): String = { value };
    override def toString(): String = { "Key: " + key + ", Value: " + value; }
  }
  
}

object HashTableTest {
  def main(args: Array[String]) {
    var hashTable = new HashTable();
    
    hashTable.put("a", "111");
    hashTable.put("b", "222");
    hashTable.put("c", "333");
    
    println(hashTable.get("a"));
    println(hashTable.get("b"));
    println(hashTable.get("c"));
    
    hashTable.remove("c");
    hashTable.remove("z");
    
    println();
    println(hashTable.get("c"));
  }
}