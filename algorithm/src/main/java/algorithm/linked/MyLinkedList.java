package algorithm.linked;

public class MyLinkedList {

    public static void main(String[] args) {
//        MyLinkedList obj = new MyLinkedList();
//        obj.addAtHead(7);
//        obj.addAtHead(2);
//        obj.addAtHead(1);
//        obj.addAtIndex(3, 0);
//        obj.deleteAtIndex(2);
//        obj.addAtHead(6);
//        obj.addAtTail(4);
//        obj.get(4);
//        obj.addAtHead(4);
//        obj.addAtIndex(5, 0);
//        obj.addAtHead(6);
//        System.out.println(obj);


        MyLinkedList obj2 = new MyLinkedList();
        obj2.addAtIndex(1, 0);
        obj2.get(0);
        System.out.println(obj2);
    }


    private MyLinkedList.LinkedNode<Integer> head;

    private int length = 0;

    public MyLinkedList() {
    }


    //获取链表中第 index 个节点的值。如果索引无效，则返回-1
    public int get(int index) {
        if (length == 0 || head == null) {
            return -1;
        }

        if (index > length - 1 || index < 0) {
            return -1;
        }

        int count = -1;
        MyLinkedList.LinkedNode<Integer> p = head;
        while (p != null) {
            count++;
            if (count == index) {
                return p.value;
            }
            p = p.next;
        }
        return -1;
    }

    //在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
    public void addAtHead(int val) {
        MyLinkedList.LinkedNode<Integer> currentNode = new MyLinkedList.LinkedNode<>(val);
        currentNode.next = head;
        head = currentNode;
        length++;
    }

    //将值为 val 的节点追加到链表的最后一个元素。
    public void addAtTail(int val) {
        MyLinkedList.LinkedNode<Integer> currentNode = new MyLinkedList.LinkedNode<>(val);
        if (head == null || length <= 0) {
            head = currentNode;
            length++;
            return;
        }

        MyLinkedList.LinkedNode<Integer> tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = currentNode;
        length++;
    }

    //在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到
    // 链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点
    public void addAtIndex(int index, int val) {
        if (head == null) {
            //头部
            addAtHead(val);
            return;
        }

        if (index <= 0) {
            //头部
            addAtHead(val);
            return;
        }

        if (index == length) {
            // 尾部
            addAtTail(val);
            return;
        } else if (index > length) {
            return;
        }


        int count = -1;
        MyLinkedList.LinkedNode<Integer> p = head;
        MyLinkedList.LinkedNode<Integer> currentNode = new MyLinkedList.LinkedNode<>(val);
        while (p != null) {
            count++;
            if (count + 1 == index) {
                //找到指定位置的前一个节点
                currentNode.next = p.next;
                p.next = currentNode;
                length++;
                return;
            }
            p = p.next;
        }

    }

    //如果索引 index 有效，则删除链表中的第 index 个节点。
    public void deleteAtIndex(int index) {
        if (head == null) {
            return;
        }

        if (index < 0 || index >= length) {
            return;
        }

        if (index == 0) {
            head = head.next;
            length--;
            return;
        }


        int count = -1;
        MyLinkedList.LinkedNode<Integer> p = head;
        while (p != null) {
            count++;
            if (count + 1 == index) {
                //找到指定位置的前一个节点
                MyLinkedList.LinkedNode currentDeleteNode = p.next;
                p.next = currentDeleteNode.next;
                length--;
                return;
            }
            p = p.next;
        }
    }


    public static class LinkedNode<T> {
        T value;

        LinkedNode next;

        LinkedNode(T value) {
            this.value = value;
        }
    }
}
