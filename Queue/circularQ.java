package Queue;

public class circularQ {
    class MyCircularQueue {

        int[] data;
        int front;
        int rear;
        int size;
        int capacity;

        public MyCircularQueue(int k) {
            this.capacity = k;
            this.data = new int[k];
            this.front = rear = -1;
            this.size = 0;
        }

        public boolean enQueue(int value) {
            if (size == 0) {
                front++;
                rear = front;
                data[front % capacity] = value;
                size++;
                return true;
            } else {
                if (size < capacity) {
                    rear++;
                    data[rear % capacity] = value;
                    size++;
                    return true;
                } else {
                    return false;
                }
            }
        }

        public boolean deQueue() {
            if (size == 0)
                return false;
            int val = data[front++ % capacity];
            size--;
            return true;
        }

        public int Front() {
            if (size == 0)
                return -1;
            return data[front % capacity];
        }

        public int Rear() {
            if (size == 0)
                return -1;
            return data[rear % capacity];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
}
