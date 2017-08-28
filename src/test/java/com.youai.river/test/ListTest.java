package com.youai.river.test;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.primitives.Longs;
import com.youai.river.util.ApiLogger;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Qingjiang Li on 2017/8/2.
 */
public class ListTest {



    @Test
    public void testListInsert() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

       List<String> llit = list.stream().map(id->String.valueOf(id)).collect(Collectors.toList());

        System.out.println(llit);
    }


    @Test
    public void testArray() {
        long[] followTabIds = new long[]{};
        String tabs = "1001,1002,1003,1004";

        Iterable<String> split = Splitter.on(",").omitEmptyStrings().split(tabs);

        Iterable<Long> iterable = Longs.stringConverter().convertAll(split);
        ArrayList<Long> list = Lists.newArrayList(iterable);
        followTabIds = Longs.toArray(list);
        ApiLogger.info(JSONObject.toJSONString(followTabIds));
    }


    @Test
    public void testRemove() {
        List<Long> list = Lists.newArrayList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L, 12L);
        List<Long> removeUids = new ArrayList<>();
        for (Long id : list) {
            if (id % 2 == 0) {
                removeUids.add(id);
            }
        }
        list.removeAll(removeUids);
        System.out.println(list);
    }

    @Test
    public void testShuffle() {
        List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        System.out.println(list.subList(0, 10));
        System.out.println("打乱前:");
        System.out.println(list);

        for (int i = 1; i < 6; i++) {
            System.out.println("第" + i + "次打乱：");
            Collections.shuffle(list);
            System.out.println(list);
        }
    }


    @Test
    public void testList() {
        List<Integer> listA = new ArrayList<>();
        listA.add(1); listA.add(2); listA.add(2); listA.add(3); listA.add(4);
        List<Integer> listB = new ArrayList<>();
        listB.add(1); listB.add(2); listB.add(3); listB.add(3); listB.add(3);
        //找出重复元素
        List<Integer> tempList = new ArrayList<>();//复制A
        tempList.addAll(listA);
        List<Integer> listA2 = new ArrayList<>();//复制B
        listA2.addAll(listA);

        listA2.removeAll(listB);
        tempList.removeAll(listA2);
        //放入map
        Map<Integer, Integer> mapCount = new HashMap<>();
        for (Integer elm : tempList) {
            mapCount.put(elm, 0);
        }
        //统计重复次数
        for (Integer elmA : listA) {
            Integer val = mapCount.get(elmA);
            if (val != null) {
                mapCount.put(elmA, ++val);
            }
        }
        for (Integer elmB : listB) {
            Integer val = mapCount.get(elmB);
            if (val != null) {
                mapCount.put(elmB, ++val);
            }
        }
        System.out.println(mapCount);
    }



    @Test
    public void testListSort() {
        List<String> nameList = Lists.newArrayList("Qingjiang Li", "Keqiang Du", "Yujie Li", "Jie Fang", "Guang Wang", "Yingying Wang");
        System.out.println(nameList);
        nameList.sort((n1, n2) ->{
            if (n1.length() != n2.length()) {
                return n1.length() - n2.length();
            }
            return n1.compareToIgnoreCase(n2);
        });
        System.out.println(nameList);
    }

}
