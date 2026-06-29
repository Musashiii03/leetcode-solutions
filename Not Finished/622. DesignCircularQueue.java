import java.util.LinkedList;

class MyCircularQueue {

    int[] arr;
    int front, rear;
    int size, capacity;

    public MyCircularQueue(int k) {
        arr = new int[k];
        capacity = k;
        size = 0;
        front = 0;
        rear = 0;
    }

    public boolean enQueue(int value) {
        if(size < capacity){
            arr[rear] = value;
            rear = (rear + 1) % capacity;
            size++;
            return true;
        } else
            return false;
    }

    public boolean deQueue() {
        if(size == 0)
            return false;
        else{
            front = (front + 1) % capacity;
            size--;
            return true;
        }
    }

    public int Front() {
        if(size == 0)
            return -1;
        else
            return arr[front];
    }

    public int Rear() {
        if(size == 0)
            return -1;
        else
            return arr[(rear - 1 + capacity) % capacity];
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
