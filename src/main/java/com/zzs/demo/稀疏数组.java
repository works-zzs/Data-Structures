package com.zzs.demo;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author ：zzs
 * @version : 1.0
 * @date ：Created in 2021/8/10 20:14
 * @description：稀疏数组
 */
public class 稀疏数组 {

    public static void main(String[] args) {
        // 行
        int row = 5;
        // 列
        int line = 5;

        // 1黑子 2白字 0无子
        int chaArray[][] = new int[row][line];
        chaArray[0][2] = 1;
        chaArray[1][2] = 2;
        chaArray[2][3] = 2;
        chaArray[1][3] = 1;
        chaArray[4][4] = 2;
        chaArray[4][3] = 1;
        // 稀疏数组
        int count = 0;
        for (int i = 0; i < chaArray.length; i++) {
            for (int j = 0; j < chaArray[i].length; j++) {
                if (chaArray[i][j] > 0) {
                    // 计数
                    count++;
                }
            }
        }
        int sparseArray[][] = new int[count + 1][3];
        int newRow = 0;
        for (int i = 0; i < chaArray.length; i++) {
            for (int j = 0; j < chaArray[i].length; j++) {
                if (chaArray[i][j] > 0) {
                    newRow ++;
                    // 行
                    sparseArray[newRow][0] = i;
                    // 列
                    sparseArray[newRow][1] = j;
                    // 值
                    sparseArray[newRow][2] = chaArray[i][j];
                }
            }
        }

        // 第一行计算对方的总行
        sparseArray[0][0] = row;
        // 第二行计算对方的总列
        sparseArray[0][1] = line;
        // 第三行计算特殊的值个数
        sparseArray[0][2] = count;
        System.out.println("原数组：" + Arrays.deepToString(chaArray));
        System.out.println("压缩后：" + Arrays.deepToString(sparseArray));

        // 恢复原来的数组
        int a = sparseArray[0][0];
        int b = sparseArray[0][1];
        int origArray[][] = new int[a][b];
        for (int i = 1; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray[1].length; j++) {
                int i1 = sparseArray[i][0];
                int i2 = sparseArray[i][1];
                int i3 = sparseArray[i][2];
                origArray[i1][i2] = i3;
            }
        }
        System.out.println("转换回原数组：" + Arrays.deepToString(origArray));
    }
}
