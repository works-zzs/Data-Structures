package com.zzs.demo;


import java.util.Scanner;

/**
 * @author ：zzs
 * @version : 1.0
 * @date ：Created in 2021/8/12 21:06
 * @description： 环形队列
 */
public class CircleQueue {
    // 队列最大容量
    private int maxSize;

    // 队列头指正
    private int front;

    // 队列尾指针
    private int rear;

    // 数组
    private int[] arr;

    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(3);

        //测试一把 //创建一个队列
        char key = ' ';
        //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true; //输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    circleQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    try {
                        circleQueue.addElement(value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    //取出数据
                    try {
                        int res = circleQueue.getElement();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    //查看队列头的数据
                    try {
                        int res = circleQueue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    System.out.println("程序退出");
                    break;
            }
        }
    }

    private int headQueue() {
        return arr[front + 1];
    }

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        // 头
        this.front = 0;
        // 尾
        this.rear = 0;
    }

    // 添加元素
    private void addElement(int element) throws Exception {
        // 判断队列是否满
        if (isFlan()) {
            throw new Exception("队列已满");
        }
        arr[rear] = element;
        rear = (rear + 1) % maxSize;
    }

    // 取得数据
    private int getElement() throws Exception {
        if (isNull()) {
            throw new Exception("队列没有元素了");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    // 判断队列容量
    private boolean isFlan() {
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否为空
    private boolean isNull() {
        return rear == front;
    }

    // 显示队列的所有数据
     public void showQueue() {
     // 遍历
          if (isNull()) {
              System.out.println("队列空的，没有数据~~");
              return;
          }
         for (int i = front; i < front + size() ; i++) {
             System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
         }
    }

    private int size() {
        // 5 10 3
        return (rear + maxSize - front) % maxSize;
    }

}
