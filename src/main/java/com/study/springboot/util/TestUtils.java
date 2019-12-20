package com.study.springboot.util;

import org.springframework.stereotype.Component;

@Component
public class TestUtils {

    public int getInt(String string) {
        return Integer.parseInt(string);
    }
}
