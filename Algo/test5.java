/**
 * 利用条件运算符的嵌套来完成此题：学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
 */

import java.util.Scanner;

public class test5{
    public static void main(String[] args){
       System.out.print("请输入你的成绩：\t");
       Scanner sc = new Scanner(System.in);
       float grade = sc.nextFloat();
       System.out.println((grade >= 90)?"A":((grade < 60)?"C":"B"));
       sc.close();
    }
}

//条件式？value1：value2