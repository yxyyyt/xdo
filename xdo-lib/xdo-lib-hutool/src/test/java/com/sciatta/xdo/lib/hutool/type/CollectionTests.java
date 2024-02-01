package com.sciatta.xdo.lib.hutool.type;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Rain on 2024/1/30<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * CollectionTests
 */
public class CollectionTests {
    @Test
    public void testSortPageAll() {
        // 从多个数据源拿到数据后，内存聚合、排序、分页
        ArrayList<Integer> t1 = CollUtil.newArrayList(3, 2, 1);
        ArrayList<Integer> t2 = CollUtil.newArrayList(4, 5, 6);
        ArrayList<Integer> t3 = CollUtil.newArrayList(9, 8, 7);

        // pageNo起始是0
        List<Integer> ans = CollUtil.sortPageAll(0,
                3,
                Comparator.comparingInt(i -> i),
                t1,
                t2,
                t3);

        assertArrayEquals(new Integer[]{1, 2, 3}, ans.toArray(new Integer[]{}));
    }

    @Test
    public void testPartition() {
        // 分区；size为每一个分区的最大容量
        List<List<Integer>> partition = ListUtil.partition(ListUtil.of(1, 2, 3), 2);
        assertEquals(2, partition.size());
        assertArrayEquals(new Integer[]{1, 2}, partition.get(0).toArray());
        assertArrayEquals(new Integer[]{3}, partition.get(1).toArray());
    }
}
