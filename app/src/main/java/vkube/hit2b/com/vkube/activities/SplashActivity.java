package vkube.hit2b.com.vkube.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import vkube.hit2b.com.vkube.R;


public class SplashActivity extends Activity {

    ProgressBar progressBar;
    int progress = 0;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        progressBar = (ProgressBar) findViewById(R.id.progressBarHorizontal);

        new Thread(myThread).start();
    }

    private Runnable myThread = new Runnable() {
        @Override
        public void run() {
            while (progress < 100) {
                try {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progress++;
                            progressBar.setProgress(progress);
                        }
                    });
                    Thread.sleep(50);
                }
                catch (Throwable t) {
                }
            }
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    goToContent();
                }
            }, 500);
        }
    };

    protected void goToContent(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }

}