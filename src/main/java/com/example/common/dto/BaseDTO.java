package com.example.common.dto;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class BaseDTO {
    @Override
    public String toString() {
        Map<String, String> s = new HashMap<String, String>();
        Field[] fields = getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            Object value = null;
            try {
                value = field.get(this);
            } catch (Exception e) {

            }

            if (value != null) {
                s.put(field.getName().toString(), value.toString());
            }
        }

        return JSON.toJSONString(s);
    }
}
