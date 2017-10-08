package com.first.ellipsis.freehitprototype;

import android.content.res.Configuration;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.widget.LinearLayout;
import io.codetail.animation.SupportAnimator;
import io.codetail.animation.ViewAnimationUtils;
import java.util.ArrayList;
import java.util.List;
import yalantis.com.sidemenu.interfaces.Resourceble;
import yalantis.com.sidemenu.interfaces.ScreenShotable;
import yalantis.com.sidemenu.model.SlideMenuItem;
import yalantis.com.sidemenu.util.ViewAnimator;
import yalantis.com.sidemenu.util.ViewAnimator.ViewAnimatorListener;

public class MainActivity extends ActionBarActivity implements ViewAnimatorListener {
    private ContentFragment contentFragment;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private LinearLayout linearLayout;
    private List<SlideMenuItem> list;
    private int res = R.drawable.content_music;
    private ViewAnimator viewAnimator;

    public MainActivity() {
        ActionBarActivity actionBarActivity = this;
        ArrayList arrayList = r4;
        ArrayList arrayList2 = new ArrayList();
        this.list = arrayList;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        this.contentFragment = ContentFragment.newInstance(R.drawable.content_music);
        int commit = getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, this.contentFragment).commit();
        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.drawerLayout.setScrimColor(0);
        this.linearLayout = (LinearLayout) findViewById(R.id.left_drawer);
        LinearLayout linearLayout = this.linearLayout;
        AnonymousClass1 anonymousClass1 = r10;
        AnonymousClass1 anonymousClass12 = new OnClickListener() {
            {
                AnonymousClass1 anonymousClass1 = this;
            }

            public void onClick(View view) {
                View v = view;
                MainActivity.this.drawerLayout.closeDrawers();
            }
        };
        linearLayout.setOnClickListener(anonymousClass1);
        setActionBar();
        createMenuList();
        ViewAnimator viewAnimator = r10;
        ViewAnimator viewAnimator2 = new ViewAnimator(this, this.list, this.contentFragment, this.drawerLayout, this);
        this.viewAnimator = viewAnimator;
    }

    private void createMenuList() {
        SlideMenuItem slideMenuItem = r13;
        SlideMenuItem slideMenuItem2 = new SlideMenuItem(ContentFragment.CLOSE, R.drawable.icn_close);
        boolean add = this.list.add(slideMenuItem);
        slideMenuItem = r13;
        slideMenuItem2 = new SlideMenuItem(ContentFragment.BUILDING, R.drawable.icn_1);
        add = this.list.add(slideMenuItem);
        slideMenuItem = r13;
        slideMenuItem2 = new SlideMenuItem(ContentFragment.BOOK, R.drawable.icn_2);
        add = this.list.add(slideMenuItem);
        slideMenuItem = r13;
        slideMenuItem2 = new SlideMenuItem(ContentFragment.PAINT, R.drawable.icn_3);
        add = this.list.add(slideMenuItem);
        slideMenuItem = r13;
        slideMenuItem2 = new SlideMenuItem(ContentFragment.CASE, R.drawable.icn_4);
        add = this.list.add(slideMenuItem);
        slideMenuItem = r13;
        slideMenuItem2 = new SlideMenuItem(ContentFragment.SHOP, R.drawable.icn_5);
        add = this.list.add(slideMenuItem);
        slideMenuItem = r13;
        slideMenuItem2 = new SlideMenuItem(ContentFragment.PARTY, R.drawable.icn_6);
        add = this.list.add(slideMenuItem);
        slideMenuItem = r13;
        slideMenuItem2 = new SlideMenuItem(ContentFragment.MOVIE, R.drawable.icn_7);
        add = this.list.add(slideMenuItem);
    }

    private void setActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBarDrawerToggle actionBarDrawerToggle = r11;
        AnonymousClass2 anonymousClass2 = new ActionBarDrawerToggle(this, this, this.drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            final /* synthetic */ MainActivity this$0;

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                this.this$0.linearLayout.removeAllViews();
                this.this$0.linearLayout.invalidate();
            }

            public void onDrawerSlide(View view, float f) {
                float slideOffset = f;
                super.onDrawerSlide(view, slideOffset);
                if (((double) slideOffset) > 0.6d && this.this$0.linearLayout.getChildCount() == 0) {
                    this.this$0.viewAnimator.showMenuContent();
                }
            }

            public void onDrawerOpened(View view) {
                super.onDrawerOpened(view);
            }
        };
        this.drawerToggle = actionBarDrawerToggle;
        this.drawerLayout.setDrawerListener(this.drawerToggle);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        this.drawerToggle.syncState();
    }

    public void onConfigurationChanged(Configuration configuration) {
        Configuration newConfig = configuration;
        super.onConfigurationChanged(newConfig);
        this.drawerToggle.onConfigurationChanged(newConfig);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return 1;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        MenuItem item = menuItem;
        if (this.drawerToggle.onOptionsItemSelected(item)) {
            return 1;
        }
        switch (item.getItemId()) {
            case R.id.action_settings /*2131230794*/:
                return 1;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private ScreenShotable replaceFragment(ScreenShotable screenShotable, int i) {
        ScreenShotable screenShotable2 = screenShotable;
        int topPosition = i;
        this.res = this.res == R.drawable.content_music ? R.drawable.content_films : R.drawable.content_music;
        View view = findViewById(R.id.content_frame);
        SupportAnimator animator = ViewAnimationUtils.createCircularReveal(view, 0, topPosition, 0.0f, (float) Math.max(view.getWidth(), view.getHeight()));
        SupportAnimator supportAnimator = animator;
        AccelerateInterpolator accelerateInterpolator = r12;
        AccelerateInterpolator accelerateInterpolator2 = new AccelerateInterpolator();
        supportAnimator.setInterpolator(accelerateInterpolator);
        animator.setDuration(ViewAnimator.CIRCULAR_REVEAL_ANIMATION_DURATION);
        View findViewById = findViewById(R.id.content_overlay);
        Drawable drawable = r12;
        Drawable bitmapDrawable = new BitmapDrawable(getResources(), screenShotable2.getBitmap());
        findViewById.setBackgroundDrawable(drawable);
        animator.start();
        ContentFragment contentFragment = ContentFragment.newInstance(this.res);
        int commit = getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, contentFragment).commit();
        return contentFragment;
    }

    public ScreenShotable onSwitch(Resourceble resourceble, ScreenShotable screenShotable, int i) {
        MainActivity this = this;
        ScreenShotable screenShotable2 = screenShotable;
        int position = i;
        String name = resourceble.getName();
        Object obj = -1;
        switch (name.hashCode()) {
            case 65203672:
                if (name.equals(ContentFragment.CLOSE)) {
                    obj = null;
                    break;
                }
                break;
        }
        switch (obj) {
            case R.styleable.View_android_focusable /*0*/:
                return screenShotable2;
            default:
                return replaceFragment(screenShotable2, position);
        }
    }

    public void disableHomeButton() {
        getSupportActionBar().setHomeButtonEnabled(false);
    }

    public void enableHomeButton() {
        getSupportActionBar().setHomeButtonEnabled(true);
        this.drawerLayout.closeDrawers();
    }

    public void addViewToContainer(View view) {
        this.linearLayout.addView(view);
    }
}
