package com.jscboy.wallhaven;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


public class MainActivity extends ActionBarActivity {

    Button continueButton;
    Button rateButton;
    Button appsButton;
    Button exitButton;

    protected void onCreate(Bundle savedInstanceState) {
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        continueButton = (Button) findViewById(R.id.wallpaperButton);
        continueButton.setTextColor(Color.BLACK);

        rateButton = (Button) findViewById(R.id.rateButton);
        rateButton.setTextColor(Color.BLACK);

        appsButton = (Button) findViewById(R.id.appsButton);
        appsButton.setTextColor(Color.BLACK);

        exitButton = (Button) findViewById(R.id.exitButton);
        exitButton.setTextColor(Color.BLACK);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void wallpaperButtonClicked (View view) {
        Intent i = new Intent(this, GalleryActivity.class);
        startActivity(i);
    }

    public void rateButtonClicked (View view) {
        Uri uri = Uri.parse
                ("https://play.google.com/store/apps/details?id=com.jscboy.wallhaven&hl=en");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void otherAppsClicked (View view) {
        Uri uri = Uri.parse
                ("https://play.google.com/store/apps/details?id=com.jscboy.alienblaster&hl=en");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void exitButtonClicked (View view) {
        finish();
    }

}
