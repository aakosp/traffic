package com.aako.traffic.ui.activity;

import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.aako.traffic.R;
import com.aako.traffic.log.FLog;
import com.aako.traffic.ui.util.DrawerLayoutInstaller;
import com.aako.traffic.ui.view.GlobalMenuView;
import com.aako.traffic.utils.Utils;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.Optional;

/**
 * Created by aako on 2015/6/16.
 */
public class DrawerActivity extends BaseActionBarActivity implements GlobalMenuView.OnHeaderClickListener {

    public static final String TAG = "DrawerActivity";
    @Optional
    @InjectView(R.id.toolbar) Toolbar toolbar;
    @Optional
    @InjectView(R.id.ivLogo) ImageView ivLogo;
    private MenuItem inboxMenuItem;
    private DrawerLayout drawerLayout;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        FLog.d(TAG, "setContentView1111111111");
        ButterKnife.inject(this);
        setupToolbar();
        if (shouldInstallDrawer()) {
            setupDrawer();
        }
    }

    protected void setupToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.ic_menu_white);
        }
    }

    protected boolean shouldInstallDrawer() {
        return true;
    }

    private void setupDrawer() {
        GlobalMenuView menuView = new GlobalMenuView(this);
        menuView.setOnHeaderClickListener(this);

        drawerLayout = DrawerLayoutInstaller.from(this)
                .drawerRoot(R.layout.drawer_root)
                .drawerLeftView(menuView)
                .drawerLeftWidth(Utils.dpToPx(300))
                .withNavigationIconToggler(getToolbar())
                .build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        inboxMenuItem = menu.findItem(R.id.action_inbox);
        inboxMenuItem.setActionView(R.layout.menu_item_view);
        return true;
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public MenuItem getInboxMenuItem() {
        return inboxMenuItem;
    }

    public ImageView getIvLogo() {
        FLog.d(TAG, "logo : "+ ivLogo);
        return ivLogo;
    }

    @Override
    public void onGlobalMenuHeaderClick(final View v) {
        drawerLayout.closeDrawer(Gravity.START);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                int[] startingLocation = new int[2];
                v.getLocationOnScreen(startingLocation);
                startingLocation[0] += v.getWidth() / 2;
//                UserProfileActivity.startUserProfileFromLocation(startingLocation, BaseActivity.this);
                overridePendingTransition(0, 0);
            }
        }, 200);
    }

}
