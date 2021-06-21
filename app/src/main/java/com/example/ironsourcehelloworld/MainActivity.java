package com.example.ironsourcehelloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.integration.IntegrationHelper;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.InterstitialListener;

public class MainActivity extends AppCompatActivity implements InterstitialListener{
    private final String APP_KEY = "85460dcd";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Dor","onCreate");
        initIronSource(APP_KEY);
    }
    private void initIronSource(String APPKEY) {
        IronSource.setInterstitialListener(this);
        IronSource.init(this, APPKEY);
        IronSource.loadInterstitial();
    }
    protected void onResume() {
        super.onResume();
        IronSource.onResume(this);
        Log.d("Dor","onResume");
    }
    protected void onPause() {
        super.onPause();
        IronSource.onPause(this);
        Log.d("Dor","onPause");
    }

    @Override
    public void onInterstitialAdReady() {
        Log.d("Dor","onInterstitialAdReady ");
        IronSource.showInterstitial("Test?");
    }

    @Override
    public void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
        Log.d("Dor","onInterstitialAdLoadFailed "+ironSourceError);
    }

    @Override
    public void onInterstitialAdOpened() {
        Log.d("Dor","onInterstitialAdOpened ");
    }

    @Override
    public void onInterstitialAdClosed() {
        Log.d("Dor","onInterstitialAdClosed");
    }

    @Override
    public void onInterstitialAdShowSucceeded() {
        Log.d("Dor","onInterstitialAdShowSucceeded");
    }

    @Override
    public void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
        Log.d("Dor","onInterstitialAdShowFailed "+ironSourceError);
    }

    @Override
    public void onInterstitialAdClicked() {
        Log.d("Dor","onInterstitialAdClicked");
    }
}
