package com.example.ndc3.cit382_project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Created by ndc3 on 5/7/2017.
 */

public class GridViewMain extends Activity {

    GridView gridView;

    String nameList[] = {"Clock1", "Clock2", "Clock3", "Clock4", "Clock5", "Clock6", "Clock7", "Clock8"};

    int nameIcon[] = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5,
            R.drawable.image6, R.drawable.image7, R.drawable.image8,};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view);

        Button activity2 = (Button) findViewById(R.id.Button01);
        activity2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });

        gridView = (GridView) findViewById(R.id.gridview);

        GridAdaptor adaptor = new GridAdaptor(GridViewMain.this, nameIcon, nameList);

        gridView.setAdapter(adaptor);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewMain.this, "Clicked Name : " + nameList[position], Toast.LENGTH_SHORT ).show();
            }
        });
    }
}

