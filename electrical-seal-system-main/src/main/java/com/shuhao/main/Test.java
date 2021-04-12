package com.shuhao.main;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Description: 加密测试
 * @author: XiaoShu
 * @date: 2020年11月22日 17:16
 */
public class Test {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("789"));
    }

}
