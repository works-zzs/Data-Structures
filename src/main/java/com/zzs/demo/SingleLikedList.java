package com.zzs.demo;

public class SingleLikedList {
    public static void main(String[] args) {
        SingleLikedList likedList = new SingleLikedList();
        Node node = new Node(1, "宋江", "及时雨");
        likedList.add(node);
        likedList.add(new Node(2, "2", "2"));

        likedList.add(new Node(4, "4", "4"));
        likedList.add(new Node(3, "3", "3"));

//        likedList.update(new Node(3, "abc", "3"));
//        likedList.del(1);

//        Node lastNode = findLastNode(likedList.getHeadNode(), 1);
//        System.out.println("倒数：" + lastNode);
//        System.out.println(length(likedList.getHeadNode()) + "个节点元素");

        fallNode(likedList.headNode);
        showList(likedList.getHeadNode());
    }

    private Node headNode = new Node(0, "", "");

    public Node getHeadNode() {
        return headNode;
    }

    /**
     * 修改节点
     *
     * @param node
     */
    void update(Node node) {
        Node temp = headNode;

        while (true) {
            if (temp.no == node.no) {
                temp.name = node.name;
                temp.no = node.no;
                temp.waiName = node.waiName;
                break;
            }
            temp = temp.next;
        }

    }

    void del(int no) {
        boolean flag = false;
        Node temp = headNode;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (no == temp.next.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
//           temp = temp.next;
        }
    }

    public void add(Node node) {
        Node temp = headNode;
        boolean flag = false; // 是否冲突
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > node.no) {
                break;
            } else if (temp.next.no == node.no) {
                flag = true;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("不能重复添加");
        } else {
            node.next = temp.next;
            temp.next = node;
        }
    }

    /**
     * 单链表的反转 (腾讯面试题)
     */
    public static void fallNode(Node headNode) {
        if (headNode == null || headNode.next.next == null) {
            // headNode为空或者第一位为空没必要反转
            return;
        }
        Node cur = headNode.next;
        Node next = null;
        // 辅助指针
        Node node = new Node(0, "", "");

        while (cur != null) {
            // 保存下一个节点
            next = cur.next;
            // 保存链表的反转，cur本身会因为遍历发生改变，next=node 保存反转的结果
            cur.next = node.next;
            node.next = cur;
            cur = next;
        }
        headNode.next = node.next;
    }

    /**
     * 获取倒数节点 (新浪面试题)
     * @return
     */
    public static Node findLastNode(Node node, int index) {
        if (node.next == null) {
            System.out.println("链表为空");
            return null;
        }

        int size = length(node);
        Node temp = node.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public static int length(Node headNode) {
        if (headNode.next == null) {
            return 0;
        }
        int length = 0;
        Node temp = headNode.next;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public static void showList(Node headNode) {
        if (headNode.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node temp = headNode.next;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将 temp 后移
            temp = temp.next;
        }
    }

    /**
     * @author ：zzs
     * @version : 1.0
     * @date ：Created in 2021/8/14 15:46
     * @description： 单链表
     */
    static class Node {
        int no;
        String name;
        String waiName;
        Node next;

        public Node(int no, String name, String waiName) {
            this.no = no;
            this.name = name;
            this.waiName = waiName;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "no='" + no + '\'' +
                    ", name='" + name + '\'' + ", waiName='" + waiName + '\'' +
                    '}';
        }
    }
}
