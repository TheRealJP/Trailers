package com.example.jonathan.trailers;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Jonathan on 04-Mar-18.
 */

public class TrailerAdapter extends ArrayAdapter<Trailer> {
    public TrailerAdapter(@NonNull Context context, Trailer[] trailers) {
        super(context, -1, trailers);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Trailer trailer = getItem(i); //index
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.trailer_item, viewGroup, false);
        }

        //set image from TrailerInstance to list item
        ImageView ivThumb = view.findViewById(R.id.thumb);
        Drawable image = getContext().getDrawable(trailer.getThumbImage());
        ivThumb.setImageDrawable(image);

        ImageView ivTrailer = view.findViewById(R.id.trailer);
        Drawable imageTrailer = getContext().getDrawable(trailer.getTrailerImage()); //trailerObject volg index
        ivTrailer.setImageDrawable(imageTrailer);

        return view;
    }


}
