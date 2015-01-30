# The authors of this work have released all rights to it and placed it
# in the public domain under the Creative Commons CC0 1.0 waiver
# (http://creativecommons.org/publicdomain/zero/1.0/).
# 
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
# EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
# MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
# IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
# CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
# TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
# SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
# 
# Retrieved from: http://en.literateprograms.org/Singly_linked_list_(Python)?oldid=18648

from __future__ import print_function

class ListNode:
    def __init__(self, data, next):
        self.data = data
        self.next = next


class List:
    def __init__(self):
        self.head = None
        self.tail = None
    def insert(self, node, data):
        new_node = ListNode(data, node.next)
        node.next = new_node
        if self.tail == node:
            self.tail = new_node
    def insert_end(self, data):
        if self.tail is None:
            new_node = ListNode(data, None)
            self.head = self.tail = new_node
        else:
            self.insert(self.tail, data)
    def insert_beginning(self, data):
        new_node = ListNode(data, self.head)
        self.head = new_node
    def remove_after(self, node):
        node.next = node.next.next
        if node.next is None:
            self.tail = node
    def remove_beginning(self):
        self.head = self.head.next
        if self.head is None:
            self.tail = None

    def iterate(self, func):
        node = list.head
        while node is not None:
            func(node.data)
            node = node.next

    def find_first(self, data):
        node = list.head
        while node is not None:
            if node.data == data:
                return node
            node = node.next
    def find_first_func(self, func):
        node = list.head
        while node is not None:
            if func(node.data):
                return node
            node = node.next
