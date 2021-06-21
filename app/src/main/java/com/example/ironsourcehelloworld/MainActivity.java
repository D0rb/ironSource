package com.example.ironsourcehelloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.integration.IntegrationHelper;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.InterstitialListener;

public class MainActivity extends AppCompatActivity {
    private final String APP_KEY = "85460dcd";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Dor","onCreate");
        IronSource.setInterstitialListener(new InterstitialListener() {
            /**
             Invoked when Interstitial Ad is ready to be shown after load function was called.
             */
            @Override
            public void onInterstitialAdReady() {
                Log.d("Dor","onInterstitialAdReady ");
                IronSource.showInterstitial("Test?");
            }
            /**
             invoked when there is no Interstitial Ad available after calling load function.
             */
            @Override
            public void onInterstitialAdLoadFailed(IronSourceError error) {
                Log.d("Dor","onInterstitialAdLoadFailed "+error);
            }
            /**
             Invoked when the Interstitial Ad Unit is opened
             */
            @Override
            public void onInterstitialAdOpened() {
                Log.d("Dor","onInterstitialAdOpened ");
            }
            /*
             * Invoked when the ad is closed and the user is about to return to the application.
             */
            @Override
            public void onInterstitialAdClosed() {
                Log.d("Dor","onInterstitialAdClosed ");
            }
            /**
             * Invoked when Interstitial ad failed to show.
             // @param error - An object which represents the reason of showInterstitial failure.
             */
            @Override
            public void onInterstitialAdShowFailed(IronSourceError error) {
                Log.d("Dor","onInterstitialAdShowFailed "+error);
            }


            /*
             * Invoked when the end user clicked on the interstitial ad.
             */
            @Override
            public void onInterstitialAdClicked() {
                Log.d("Dor","onInterstitialAdClicked ");
            }
            /** Invoked right before the Interstitial screen is about to open.
             NOTE - This event is available only for some of the networks. You should NOT treat this event as an interstitial impression,
             but rather use InterstitialAdOpenedEvent */
            @Override
            public void onInterstitialAdShowSucceeded() {
                Log.d("Dor","onInterstitialAdShowSucceeded");
            }
        });

        IronSource.init(this, APP_KEY);
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
}
