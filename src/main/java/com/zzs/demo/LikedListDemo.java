package com.zzs.demo;

/**
 * @author ：zzs
 * @version : 1.0
 * @date ：Created in 2021/8/14 15:46
 * @description： 单链表
 */
public class LikedListDemo {
    public static void main(String[] args) {
        LikedList likedList = new LikedList();
        likedList.add(new Node(1, "宋江", "及时雨"));
        likedList.add(new Node(2, "2", "2"));

        likedList.add(new Node(4, "4", "4"));
        likedList.add(new Node(3, "3", "3"));

//        likedList.update(new Node(3, "abc", "3"));
        likedList.del(1);
        likedList.showList();
    }
}

class Node {
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
                ", name='" + name + '\'' +
                ", waiName='" + waiName + '\'' +
                '}';
    }
}

class LikedList {

    private Node headNode = new Node(0, "", "");

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
     * 修改节点
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


    public void showList() {
        if (headNode.next == null) {
            System.out.println("链表为空");
            return;
        }
        Node temp = headNode.next;
        while (true) {
            //判断是否到链表最后
            if(temp == null) { break; }
            //输出节点的信息
            System.out.println(temp);
            //将 temp 后移
            temp = temp.next;
        }
    }
}