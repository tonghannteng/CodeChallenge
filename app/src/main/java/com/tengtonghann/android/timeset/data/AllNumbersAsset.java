package com.tengtonghann.android.timeset.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tonghannteng on 5/11/17.
 */

public class AllNumbersAsset {

    // Lists for allNumbers
    private static final List<Integer> allNumbers = new ArrayList<Integer>() {{
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        add(6);
        add(7);
        add(8);
        add(9);
        add(11);
        add(12);
        add(13);
        add(14);
        add(15);
        add(17);
        add(18);
        add(19);
        add(20);
        add(21);
        add(22);
        add(23);

    }};

    // Returns a list of all the numbers
    public static List<Integer> getAllNumbers() {
        return allNumbers;
    }
}
