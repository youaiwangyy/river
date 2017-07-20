package com.youai.river.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 性别
 * Created by qingjiang on 2017/6/14.
 */
public enum SexEnum {

    NONE(-1, "未知"),
    MALE(1, "男"),
    FEMALE(2, "女");


    private int id;

    private String name;

    private static Map<Integer, SexEnum> VALUES = new HashMap<>();

    static {
        for (SexEnum enm : SexEnum.values()) {
            VALUES.put(enm.getId(), enm);
        }
    }

    public static final SexEnum parse(int id) {
        return VALUES.get(id);
    }

    SexEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
