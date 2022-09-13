package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Table {

    int[][] values;
    int rowIndex = 0;

    int manateesPerRow;

    public Table() {
        this.manateesPerRow = askForCount();
        values = new int[4][manateesPerRow];
        addRow(new int[]{3, 2, 1, 2});
        addRow(new int[]{2, 3, 4, 3});
        addRow(new int[]{2, 1, 2, 1});
        addRow(new int[]{2, 2, 1, 3});
    }

    private int askForCount() {
        return 4;
    }


    private void addRow(int[] newValues) {
        for (int i = 0; i < newValues.length; i++) {
            values[rowIndex][i] = newValues[i];
        }
        rowIndex += 1;
    }


    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        for (int[] row: values) {
            builder.append(Arrays.toString(row));
            builder.append("\n");

        }
        return  builder.toString();
    }

    public ArrayList<Manatee> females() {
        return parseGroup(values[0], values[1]);
    }

    public ArrayList<Manatee> males() {

        return parseGroup(values[2], values[3]);
    }

    public ArrayList<Manatee> parseGroup(int[] ages, int[] sizes) {
        ArrayList<Manatee> res = new ArrayList<>();
        int manateeCount = manateesPerRow;
        for (int i = 0; i < manateeCount; i++) {
            Manatee manatee = new Manatee();
            manatee.tattoo = i + 1;
            manatee.age = ages[i];
            manatee.size = sizes[i];

            res.add(manatee);
        }

        return res;
    }


}
