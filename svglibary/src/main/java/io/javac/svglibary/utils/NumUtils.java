package io.javac.svglibary.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Pencilso on 2017/11/10.
 */

public class NumUtils {
    private static List<Integer> createIntArray(int count){
        List<Integer> list = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            list.add(i);
        }
        return list;
    }

    /**
     * 创建随机数组
     * @param count
     * @return
     */
    public static int[] createRandomArray(int count){
        List<Integer> intArray = createIntArray(count);
        Random random = new Random();
        int array[] = new int[count];
        for (int i = 0; i < count; i++) {
            int bound = intArray.size();
            int nextInt = random.nextInt(bound);
            array[i] = intArray.get(nextInt);
            intArray.remove(nextInt);
        }
        return array;
    }
}
