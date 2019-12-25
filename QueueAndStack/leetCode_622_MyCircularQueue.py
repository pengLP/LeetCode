class MyCircularQueue:
    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the queue to be k.
        """
        self.rear = 0
        self.front = 0
        self.data = [0 for i in range(k+1)]
        self.maxSize = k+1
    def enQueue(self, value: int) -> bool:
        """
        Insert an element into the circular queue. Return true if the operation is successful.
        """
        if((self.rear + 1) % self.maxSize != self.front):
            self.data[self.rear] = value
            self.rear = (self.rear +1) % self.maxSize
            return True
        else:
            return False

    def deQueue(self) -> bool:
        """
        Delete an element from the circular queue. Return true if the operation is successful.
        """
        if (self.front != self.rear):
            self.front = (self.front +1) % self.maxSize
            return True
        else:
            return False

    def Front(self) -> int:
        if(self.front == self.rear):
            return -1
        return self.data[self.front]

    def Rear(self) -> int:
        """
        Get the last item from the queue.
        """
        if(self.front == self.rear):
            return -1
        return self.data[self.rear-1]

    def isEmpty(self) -> bool:
        """
        Checks whether the circular queue is empty or not.
        """
        if(self.front == self.rear):
            return True
        else:
            return False

    def isFull(self) -> bool:
        """
        Checks whether the circular queue is full or not.
        """
        if((self.rear + 1)%self.maxSize == self.front):
            return True
        else:
            return False

# Your MyCircularQueue object will be instantiated and called as such:
# obj = MyCircularQueue(k)
# param_1 = obj.enQueue(value)
# param_2 = obj.deQueue()
# param_3 = obj.Front()
# param_4 = obj.Rear()
# param_5 = obj.isEmpty()
# param_6 = obj.isFull()

if __name__ == '__main__':
    obj = MyCircularQueue(3)
    print(obj.enQueue(7))
    print(obj.deQueue())
    print(obj.Front())
    print(obj.deQueue())
    print(obj.Front())
    print(obj.Rear())

    print(obj.enQueue(0))
    print(obj.isFull())
    print(obj.deQueue())
    print(obj.Rear())
    print(obj.enQueue(3))
