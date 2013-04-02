package com.dubu;

/**
 * User: Administrator
 * Date: 13. 4. 1
 * Time: 오후 8:11
 */
public class Job02 {

    public static void main(String[] args) {

        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello Job02 ");
    }
}
