package com.example.hemanth.s4assign3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView androidGridView;

    Integer[] imageIDs = {
            R.mipmap.gingerbread,R.mipmap.honeycomb,R.mipmap.icecreamsandwich,R.mipmap.jellybean,R.mipmap.kitkat,R.mipmap.lollypop1
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidGridView = (GridView) findViewById(R.id.gridview);
        androidGridView.setAdapter(new ImageAdapterGridView(this));

        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {
                Toast.makeText(getBaseContext(), "Grid Item " + (position + 1) + " Selected", Toast.LENGTH_SHORT).show();
            }
        });





//        GridView gridView = (GridView)findViewById(R.id.gridview);
//        ArrayList data = new ArrayList();

//        data.add(R.drawable.gingerbread);
//        data.add(R.drawable.honeycomb);
//        data.add(R.drawable.icecreamsandwich);
//        data.add(R.drawable.jellybean);
//        data.add(R.drawable.kitkat);
//        data.add(R.drawable.lollypop1);

//        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,data);
//
//        gridView.setAdapter(adapter);

    }

    public class ImageAdapterGridView extends BaseAdapter {
        private Context mContext;

        public ImageAdapterGridView(Context c) {
            mContext = c;
    }
        public int getCount() {
            return imageIDs.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView mImageView;

            if (convertView == null) {
                mImageView = new ImageView(mContext);
                mImageView.setLayoutParams(new GridView.LayoutParams(500, 500));
                mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                mImageView.setPadding(16, 16, 16, 16);
            }
            else {
                mImageView = (ImageView) convertView;
            }
            mImageView.setImageResource(imageIDs[position]);
            return mImageView;
        }
    }
}
