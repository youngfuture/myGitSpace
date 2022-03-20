package algorithm.stackAndQueue;

import java.util.ArrayList;
import java.util.List;

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
public class MyCircularQueue {

    List<Integer> queueList;

    int front = -1;

    int rear = -1;

    int size = 0;


    public MyCircularQueue(int k) {
        size = k;
        queueList = new ArrayList<>(k);
    }

    public synchronized boolean  enQueue(int value) {
        if (rear == -1) {
            rear++;
            front++;
            queueList.add(rear, value);
            return true;
        }

        if (rear + 1 > front) {
            //没有逆转的时候
            if (rear + 1 <= size - 1) {
                rear++;
                queueList.add(rear, value);
                return true;
            }

            //刚好满的时候
            if (rear + front == size - 1) {
                return false;
            } else {
                rear = 0;
                queueList.add(rear, value);
                return true;
            }
        } else if (rear + 1 == front) {
            return false;
        } else {
            rear++;
            queueList.add(rear, value);
            return true;
        }
    }

    public synchronized boolean deQueue() {
        if (front == -1) {
            return false;
        }

        if (front == rear) {
            queueList.get(front);
            queueList.add(front, null);
            front = -1;
            rear = -1;
            return true;
        }

        if (front < rear) {
            queueList.get(front);
            queueList.add(front, null);
            front++;
            return true;
        }

        if (front > rear) {
            if (front < size - 1) {
                queueList.get(front);
                queueList.add(front, null);
                front++;
                return true;
            }

            if (front == size - 1) {
                queueList.get(front);
                queueList.add(front, null);
                front = 0;
                return true;
            }
        }
        return false;
    }

    public synchronized int Front() {
        if (front == -1) {
            return -1;
        }

        if (front == rear) {
            int temp = queueList.get(front);
            queueList.add(front, null);
            front = -1;
            rear = -1;
            return temp;
        }

        if (front < rear) {
            int temp = queueList.get(front);
            queueList.add(front, null);
            front++;
            return temp;
        }

        if (front > rear) {
            if (front < size - 1) {
                int temp = queueList.get(front);
                queueList.add(front, null);
                front++;
                return temp;
            }

            if (front == size - 1) {
                int temp = queueList.get(front);
                queueList.add(front, null);
                front = 0;
                return temp;
            }
        }
        return -1;
    }

    public synchronized int Rear() {
        if (rear == -1) {
            return -1;
        }

        if (front == rear) {
            int temp = queueList.get(front);
            queueList.add(front, null);
            front = -1;
            rear = -1;
            return temp;

        }

        if (rear > front) {
            int temp = queueList.get(rear);
            queueList.add(rear, null);
            rear--;
            return temp;
        }

        if (rear < front) {
            int temp = queueList.get(rear);
            queueList.add(rear, null);
            if (rear > 0) {
                rear--;
            } else if (rear == 0) {
                rear = size - 1;
            }
            return temp;
        }
        return -1;
    }

    public synchronized boolean isEmpty() {
        if (rear == -1 || front == -1) {
            return true;
        } else {
            return false;
        }
    }

    public synchronized boolean isFull() {
        if (rear > front && rear + front == size - 1) {
            return true;
        }

        if (rear < front && rear + 1 == front) {
            return true;
        }
        return false;
    }
}
