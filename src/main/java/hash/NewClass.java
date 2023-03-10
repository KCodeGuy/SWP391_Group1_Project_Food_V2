/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hash;

import java.util.Scanner;

/**
 *
 * @author NghiaHHCE160343@fpt.edu.vn
 */
public class NewClass {
    public static void main(String[] args) {
        SCryptUtil s = new SCryptUtil();
        Scanner sc = new Scanner(System.in);
        String ss;
        for (int i = 0; i < 10; i++) {
            ss = sc.nextLine();
            System.out.println(s.scrypt(ss, 16, 16, 16));
            System.out.println(s.check(ss, s.scrypt(ss, 16, 16, 16)));
        }
    }
}
