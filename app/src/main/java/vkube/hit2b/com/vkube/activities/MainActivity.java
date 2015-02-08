package vkube.hit2b.com.vkube.activities;

import android.os.Bundle;
import android.os.Handler;

import com.actionbarsherlock.view.MenuItem;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import vkube.hit2b.com.vkube.fragments.AboutFragment;
import vkube.hit2b.com.vkube.fragments.AnnouncementsFragment;
import vkube.hit2b.com.vkube.fragments.OrderFragment;
import vkube.hit2b.com.vkube.fragments.ReportsFragment;
import vkube.hit2b.com.vkube.fragments.VideosFragment;
import vkube.hit2b.com.vkube.R;

/**
 * Created by SVYAT on 10.10.2014.
 */
public class MainActivity extends BaseActivity{

    Handler handler = new Handler();

    public MainActivity() {
        super(R.string.announcements);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements);

        getSlidingMenu().setOnOpenedListener(new SlidingMenu.OnOpenedListener() {
            public void onOpened() {
                getSlidingMenu().invalidate();
            }
        });

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, new AnnouncementsFragment())
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                toggle();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void switchContent(final int position) {
        getSlidingMenu().showContent();

        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                switch (position) {
                    case 1:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.content_frame, new AnnouncementsFragment())
                                .commit();
                        setTitle(R.string.announcements);
                        break;
                    case 2:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.content_frame, new ReportsFragment())
                                .commit();
                        setTitle(R.string.reports);
                        break;
                    case 3:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.content_frame, new VideosFragment())
                                .commit();
                        setTitle(R.string.videos);
                        break;
                    case 4:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.content_frame, new OrderFragment())
                                .commit();
                        setTitle(R.string.order);
                        break;
                    case 5:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.content_frame, new AboutFragment())
                                .commit();
                        setTitle(R.string.about);
                        break;
                }
            }
        }, 500);
    }

}
