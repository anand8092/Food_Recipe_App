package com.example.foodrecipeapp.Activity;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodrecipeapp.R;

public class CustomAdapter extends BaseAdapter {

    Context context;
    int[] pic;
    String[] foodNames;


    private LayoutInflater inflater;

    CustomAdapter(Context context,String[]foodNames,int[]pic){
        this.context=context;
        this.foodNames=foodNames;
        this.pic=pic;

    }

    @Override
    public int getCount() {
        return foodNames.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null){
            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view=inflater.inflate(R.layout.sample_view,viewGroup, false);



        }
        ImageView imageView= (ImageView) view.findViewById(R.id.imageViewId);
        TextView textView= (TextView)view.findViewById(R.id.textViewId);
        imageView.setImageResource(pic[i]);
        textView.setText(foodNames[i]);


        return view;
    }
}
