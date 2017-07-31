package com.youai.river.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 性别
 * Created by qingjiang on 2017/6/14.
 */
public enum UserStatusEnum {

    NORMAL(1, "正常"),
    CLOSE(2, "关闭");


    private int id;

    private String name;

    private static Map<Integer, UserStatusEnum> VALUES = new HashMap<>();

    static {
        for (UserStatusEnum enm : UserStatusEnum.values()) {
            VALUES.put(enm.getId(), enm);
        }
    }

    public static final UserStatusEnum parse(int id) {
        return VALUES.get(id);
    }

    UserStatusEnum(int id, String name) {
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
