package xenomity.study.hashtable;

/**
 * Hash Table
 * 
 * <pre>
 * Hash 방식: x mod m (x: value, m: table size)
 * Collision 회피 방법: Open Addressing (선형 방식)으로 구현한 샘플
 * </pre>
 * 
 * @author Xenomity a.k.a P-slinc' (이승한)
 * @since 2014. 12. 14.
 *
 */
public class HashTable {
	private final static int TABLE_SIZE = 128;
	private final HashEntry[] table;

	/**
	 * The Constructor
	 */
	public HashTable() {
		table = new HashEntry[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++) {
			table[i] = null;
		}
	}

	/**
	 * Get Value
	 * 
	 * @param key key
	 * @return value
	 */
	public int get(int key) {
		int hash = (key % TABLE_SIZE);
		
		while (table[hash] != null && table[hash].getKey() != key) {
			hash = (hash + 1) % TABLE_SIZE;
		}

		if (table[hash] == null) {
			return -1;
		} else {
			return table[hash].getValue();
		}
	}

	/**
	 * Put Value
	 * 
	 * @param key key
	 * @param value value
	 */
	public void put(int key, int value) {
		int hash = (key % TABLE_SIZE);
		
		while (table[hash] != null && table[hash].getKey() != key) {
			hash = (hash + 1) % TABLE_SIZE;
		}

		table[hash] = new HashEntry(key, value);
	}

	// Hash Entry
	private class HashEntry {
		private int key;
		private int value;

		HashEntry(int key, int value) {
			this.key = key;
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public int getValue() {
			return value;
		}
	}
}