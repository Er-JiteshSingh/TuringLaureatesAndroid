package com.turinglaureate.utility;


import com.turinglaureate.modals.LaureateData;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataProvider {

    public static List<LaureateData> laureateDataItemList;
    public static Map<String, LaureateData> laureateDataMap;

    static {
        laureateDataItemList = new ArrayList<>();
        laureateDataMap = new HashMap<>();

        addItem(new LaureateData("Linus Torvalds", "2020", "USA", "Hola World", "VEC Lakhanpur", "img"));
        addItem(new LaureateData("Jeffrey D Ullman", "2008", "Russia", "Namste Duniya", "VEC Ambikapur", "imffg"));
        addItem(new LaureateData("Geoffrey Hinton", "2002", "Ukraine", "Bhailang", "VEC Surguja", "imgxgggg"));
        addItem(new LaureateData("James Gosling", "2022", "Poland", "GoGo", "VEC Raipur", "imggxgg"));

    }

    private static void addItem(LaureateData laureateData) {
        laureateDataItemList.add(laureateData);
        laureateDataMap.put(laureateData.getId(), laureateData);
    }

}