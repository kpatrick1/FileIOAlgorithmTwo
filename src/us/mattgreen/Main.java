package us.mattgreen;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    private final static FileInput cardAccts = new FileInput("movie_cards.csv");
    private final static FileInput cardPurchases = new FileInput("movie_purchases.csv");
    private final static FileInput movieRatings = new FileInput("movie_rating.csv");
    private final static FileInput sortMovies = new FileInput("movie_rating.csv");
    private final static FileOutput movieOut = new FileOutput("movieAvgRating.csv");

    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        String line;
        String[] fields;
        int[] nums = new int[2];

        System.out.format("%8s  %-18s %6s %6s %6s\n","Account","Name", "Movies", "Points", "Avg Rating");
        while ((line = cardAccts.fileReadLine()) != null) {
            fields = line.split(",");
            findPurchases(fields[0], nums);
            Double rating = findRatings(fields[0]);
            String out = fields[0] + "," + fields[1] + "," + nums[0] + "," + nums[1] + "," + rating;
            movieOut.fileWrite(out);

            System.out.format("%6s  %-18s  %6d   %6d   %6.1f\n",fields[0],fields[1], nums[0], nums[1], rating);
        }


        sortRatings();
        movieOut.fileClose();
    }

    public static void findPurchases(String acct, int[] nums) {
        nums[0] = 0;
        nums[1] = 0;
        String line;
        String[] fields;
        boolean done = false;
        while (((line = cardPurchases.fileReadLine()) != null) && !(done)) {
            fields = line.split(",");
            if (fields[0].compareTo(acct) > 0) {
                done = true;
            }
            else if (fields[0].equals(acct)) {
                nums[0]++;
                nums[1] += Integer.parseInt(fields[2]);
            }

        }
    }

    public static void sortRatings() {
        ArrayList<Integer> rating = new ArrayList<Integer>();
        String line;
        String[] fields;



        while (((line = sortMovies.fileReadLine()) != null)) {
            fields = line.split(",");
            int rate = Integer.parseInt(fields[1]);
            rating.add(rate);
        }

        Collections.sort(rating);
        int curRating = 99;
        int count = 0;
        int total = 0;
        for (Integer i: rating) {
            if (curRating != i ) {
                if (curRating != 99){
                    System.out.println(curRating + " " + count);
                    count = 0;
                }

                curRating = i;
                count = 0;
            }
            count++;
        }
        System.out.println(curRating + " " + count);

    }

    public static double findRatings(String acct) {
        int countRatings = 0;
        int sumRatings = 0;
        String line;
        String[] fields;
        boolean done = false;
        while (((line = movieRatings.fileReadLine()) != null) && !(done)) {
            fields = line.split(",");
            if (fields[0].compareTo(acct) > 0) {
                done = true;
            } else if (fields[0].equals(acct)) {
                countRatings++;
                sumRatings += Integer.parseInt(fields[1]);
            }
        }
        if (countRatings == 0) {
            return 0.0;
        } else {
            return (double)((double)sumRatings / (double)countRatings);

        }

    }


}