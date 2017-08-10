package com.youai.river.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 周枚举
 * Created by qingjiang on 2017/8/8.
 */
public enum WeekEnum {

    Mon(1, "Monday", "星期一"),
    Tue(2, "Tuesday", "星期二"),
    Wed(3, "Wednesday", "星期三"),
    Thu(4, "Thursday", "星期四"),
    Fri(5, "Friday", "星期五"),
    Sat(6, "Saturday", "星期六"),
    Sun(7, "Sunday", "星期日")
    ;


    private int id;

    private String nameEn;

    private String nameCh;

    private static Map<Integer, WeekEnum> VALUES = new HashMap<>();

    static {
        for (WeekEnum enm : WeekEnum.values()) {
            VALUES.put(enm.getId(), enm);
        }
    }

    public static final WeekEnum parse(int id) {
        return VALUES.get(id);
    }

    WeekEnum(int id, String nameEn, String nameCh) {
        this.id = id;
        this.nameEn = nameEn;
        this.nameCh = nameCh;
    }

    public int getId() {
        return id;
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getNameCh() {
        return nameCh;
    }


}
