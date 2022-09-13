package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Table table = new Table();
        manateeEvacuation(table);

    }

    public static String manateesToString(ArrayList<Manatee> manatees) {
        StringBuilder builder = new StringBuilder();
        for (Manatee manatee: manatees) {
            builder.append(manatee.tattoo + " ");
        }
        return  builder.toString();
    }

    public static void manateeEvacuation(Table table) {

        ArrayList<Manatee> males = sortByAge(table.males());
        ArrayList<Manatee> females = sortByAge(table.females());


        if (compareManatees(males, females)) {
            System.out.println("Impossible");
        } else {
            System.out.println(manateesToString(females));
            System.out.println(manateesToString(males));

        }

    }

    public static boolean compareManatees(ArrayList<Manatee> males, ArrayList<Manatee> females) {
        for (int i = 0; i < females.size(); i++) {
            if (females.get(i).size > males.get(i).size) {
                return false;
            }
        }
        return true;
    }


    public static ArrayList<Manatee> sortByAge(ArrayList<Manatee> manatees) {
        manatees.sort(new Comparator<Manatee>() {
            @Override
            public int compare(Manatee o1, Manatee o2) {

                return Integer.compare(o1.age, o2.age);
            }
        });
        return manatees;
    }



}
