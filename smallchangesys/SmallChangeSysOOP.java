package com.homework.smallchangesys;

import java.util.Scanner;

/**
 * 这是一个零钱通的系统
 * 一个主页+四个功能：零钱通主页面，零钱通明细、入账、消费、退出
 * 零钱通主页面：提示四个功能的入口，使用do_while循环控制，当使用【退出功能】时退出循环
 * 1.零钱通明细：
 * 2.入账：判断入账金额不能为负数
 * 3.消费：判断消费金额为合理的数值
 * 4.退出：退出验证，需要输出 y/n 只有输入 y时才退出
 */
public class SmallChangeSysOOP {
    Scanner input=new Scanner(System.in);
    boolean loop = true;    // do_while循环的控制条件，用来控制整个系统的退出
    double allMoney = 0;    // 零钱 总金额
    String detail = "";     // 账单 总明细

    double money = 0;       // 该账单 开销
    String note = "";       // 该账单 用途

    // 零钱通主页面
    public void mainOOP(){

        // 进入do_while循环，系统开始运行
        do {
            this.index();   // 主页功能模块

            // 使用switch分支，根据输入进入不同的功能模块
            System.out.println("请选择(1-4)：");
            switch (input.nextInt()) {
                case 1:
                    this.detail();      // 零钱通明细
                    break;
                case 2:
                    this.income();      // 入账
                    break;
                case 3:
                    this.outcome();     // 消费
                    break;
                case 4:
                    this.exit();        // 退出
                    break;
                default:
                    System.out.println("请输入各个功能对应的数字(1-4)");
            }
        } while (loop);

        // 当do_while循环结束，说明系统已经退出
        System.out.println("已退出零钱通系统");
    }

    // 主页
    public void index() {
        System.out.println("\n========零钱通主页========");
        System.out.println("1.零钱通明细");
        System.out.println("2.入账");
        System.out.println("3.消费");
        System.out.println("4.退出");
    }

    // 零钱通明细
    public void detail() {
        System.out.println("\n====零钱通明细====");
        System.out.println(detail);
    }

    // 账单明细
    public void setDetail(String note, double money, double allMoney) {
        detail += note + "\t：" + money + "\t总零钱为：" + allMoney + "\n";
    }

    // 入账
    public void income() {
        System.out.println("\n====入账====");
        System.out.println("入账金额：");
        money = input.nextDouble();
        // 入账金额不能为负数
        if(money <= 0){
            System.out.println("入账金额错误，入账金额需要 > 0");
            return;
        }
        note = "入账";
        allMoney += money;      // 修改总余额
        setDetail(note, money, allMoney);
    }

    // 消费
    public void outcome() {
        System.out.println("\n====消费====");
        System.out.println("消费金额：");
        money = input.nextDouble();
        // 消费金额需要在合理范围内
        if (money < 0 || money > allMoney) {
            System.out.println("消费额度出错，允许消费额度为:0 - " +  allMoney);
            return;
        }
        note = "消费";
        allMoney -= money;      // 修改总余额
        setDetail(note, money, allMoney);
    }

    // 退出
    public void exit() {
        String exit;
        while (true) {
            System.out.println("当前正在退出，确定退出？ y/n");
            exit = input.next();
            if (exit.equals("y") || exit.equals("n")) {
                break;
            }
        }

        /*

//        do {
//            System.out.println("当前正在退出，确定退出？ y/n");
//            exit = input.next();
//        } while (!exit.equals("y") && !exit.equals("n"));

         */

        if (exit.equals("y")) {
            loop=false;
            System.out.println("\n====正在退出零钱通系统~~====");
        }
    }
}
