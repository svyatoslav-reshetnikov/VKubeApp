package vkube.hit2b.com.vkube.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ProgressBar;

import vkube.hit2b.com.vkube.R;


public class SplashActivity extends Activity {

    ProgressBar progressBar;
    int progress = 0;

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        final ImageView logo = (ImageView) findViewById(R.id.logo);

        final Animation animation1 = new AlphaAnimation(0.1f, 1.0f);
        animation1.setDuration(1000);
        //animation1.setStartOffset(5000);

        final Animation animation2 = new AlphaAnimation(1.0f, 0.1f);
        animation2.setDuration(1000);
        //animation2.setStartOffset(5000);

        //animation1 AnimationListener
        animation1.setAnimationListener(new Animation.AnimationListener(){

            @Override
            public void onAnimationEnd(Animation arg0) {
                if (progress < 3)
                    logo.startAnimation(animation2);
                else {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    SplashActivity.this.finish();
                }
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {

            }

            @Override
            public void onAnimationStart(Animation arg0) {

            }

        });

        //animation2 AnimationListener
        animation2.setAnimationListener(new Animation.AnimationListener(){

            @Override
            public void onAnimationEnd(Animation arg0) {
                progress++;
                logo.startAnimation(animation1);
            }

            @Override
            public void onAnimationRepeat(Animation arg0) {

            }

            @Override
            public void onAnimationStart(Animation arg0) {

            }

        });

        logo.startAnimation(animation1);

        //progressBar = (ProgressBar) findViewById(R.id.progressBarHorizontal);

        //new Thread(myThread).start();
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