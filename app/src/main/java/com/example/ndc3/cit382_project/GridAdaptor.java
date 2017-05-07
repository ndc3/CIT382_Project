package com.example.ndc3.cit382_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ndc3 on 5/7/2017.
 */

public class GridAdaptor extends BaseAdapter {

    private int icons[];

    private String name[];

    private Context context;

    private LayoutInflater inflater;

    public GridAdaptor(Context context, int icons[], String name[]){

        this.context = context;
        this.icons = icons;
        this.name = name;

    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Override
    public Object getItem(int position) {
        return name[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View gridView = convertView;

        if(convertView == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.linearlayout, null);
        }

        ImageView icon = (ImageView) gridView.findViewById(R.id.icons);
        TextView names = (TextView) gridView.findViewById(R.id.name);

        icon.setImageResource(icons[position]);
        names.setText(name[position]);

        return gridView;
    }
}
