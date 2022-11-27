/*
package com.secure6.hhm.config;

import java.util.StringTokenizer;

public class Secure {

    StringTokenizer st;

    String pass(String pwd) {

        int a=2;
        int b=2;
        char ch[];
        int t;
        t = Integer.parseInt(pwd);
        while (t-- > 0) {
            st = new StringTokenizer(pwd);
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            ch = pwd.toCharArray();
            len = ch.length;

            for (int i = 0; i < len; i++) {
                x = ch[i] - 'A';
                ch[i] = (char) (((a * x + b) % 26) + 'A');
            }
            String s = new String(ch);
            System.out.println(s);
        }

    }

}
*/
