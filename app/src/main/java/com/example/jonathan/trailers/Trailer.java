package com.example.jonathan.trailers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

/**
 * Created by Jonathan on 04-Mar-18.
 */

class Trailer {

    public static Trailer[] trailers /*= {new Trailer(R.drawable.tr1, R.drawable.down), new Trailer(R.drawable.tr2, R.drawable.down), new Trailer(R.drawable.tr3, R.drawable.down)}*/;
    private final int thumbImage;
    private final int trailerImage;

    public Trailer(int thumbImage, int trailerImage) {
        this.thumbImage = thumbImage;
        this.trailerImage = trailerImage;

    }

    public int getThumbImage() {
        return thumbImage;
    }

    public int getTrailerImage() {
        return trailerImage;
    }


//    vullen met drawables...
    private static ArrayList<Integer> collectTrailerImages() {
        //R.drawable.*YOUR FOLDER*.class doesn't work
        Field[] fields = R.drawable.class.getDeclaredFields();
        ArrayList<Integer> trailerList = new ArrayList<>();


        for (Field field : fields) {
            try {
                if (field.getName().matches("tr\\d")) //veranderen naar tr
                    trailerList.add(field.getInt(null));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return trailerList;
    }


    public static Trailer[] getTrailers() {
//        ArrayList<Integer> thumbList = collectThumbImages();
        ArrayList<Integer> trailerList = collectTrailerImages();
        trailers = new Trailer[trailerList.size()];
        Random r = new Random();
        int thumb;

        for (int i = 0; i < trailerList.size(); i++) {
            trailers[i] = new Trailer(r.nextInt(2) == 1 ? R.drawable.down : R.drawable.up/*thumbList.get(r.nextInt(1))*/, trailerList.get(i));
        }

        return trailers;
    }

//    private static ArrayList<Integer> collectThumbImages() {
//        ArrayList<Integer> thumbList = new ArrayList<>();
//        thumbList.add(R.drawable.down);
//        thumbList.add(R.drawable.up);
//        return thumbList;
//    }

}
