package com.jscboy.wallhaven;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;


public class GalleryActivity extends Activity {

    private Button setButton;
    private int index;
    private Bitmap wallpaper;

    public Integer [] pics = {R.drawable.batman, R.drawable. darthvader, R.drawable.horns,
            R.drawable.hulk, R.drawable.ironman, R.drawable.meathead, R.drawable.newspaperbatman,
            R.drawable.pulpfiction, R.drawable.random, R.drawable.spiderman, R.drawable.wolverine,
            R.drawable.background};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_gallery);

        Gallery gallery = (Gallery) findViewById(R.id.gallery);
        //create adapter Gallery
        gallery.setAdapter(new ImageAdapter(this));

        setButton = (Button) findViewById(R.id.setWallpaperButton);
        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index = position;
                Toast.makeText
                        (getApplicationContext(), "Picture selected", Toast.LENGTH_SHORT).show();
                ImageView imageView = (ImageView) findViewById(R.id.imageView);
                imageView.setImageResource(pics[position]);
                wallpaper = BitmapFactory.decodeResource(getResources(), pics[index]);
            }
        });

    }

    public void setWallpaperMethod (View view) {
        try {
            getApplicationContext().setWallpaper(wallpaper);
            Toast.makeText(getApplicationContext(), "Wallpaper Set", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;
        private int itemBackground;

        public ImageAdapter(Context context) {
            this.context = context;
            TypedArray a = obtainStyledAttributes(R.styleable.MyGallery);
            itemBackground = a.getResourceId(R.styleable.MyGallery_android_galleryItemBackground, 0);
            a.recycle();
        }

        @Override
        public int getCount() {
            return pics.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView (context);
            imageView.setImageResource(pics[position]);
            imageView.setLayoutParams(new Gallery.LayoutParams(500, 500));
            imageView.setBackgroundResource(itemBackground);
            return imageView;
        }
    }
}
