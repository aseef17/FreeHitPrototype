package com.first.ellipsis.freehitprototype;


import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import yalantis.com.sidemenu.interfaces.ScreenShotable;
import yalantis.com.sidemenu.sample.R;

public class ContentFragment extends Fragment implements ScreenShotable {
    public static final String BOOK = "Book";
    public static final String BUILDING = "Building";
    public static final String CASE = "Case";
    public static final String CLOSE = "Close";
    public static final String MOVIE = "Movie";
    public static final String PAINT = "Paint";
    public static final String PARTY = "Party";
    public static final String SHOP = "Shop";
    private Bitmap bitmap;
    private View containerView;
    protected ImageView mImageView;
    protected int res;

    public ContentFragment() {
        Fragment fragment = this;
    }

    static /* synthetic */ Bitmap access$102(ContentFragment contentFragment, Bitmap bitmap) {
        Bitmap bitmap2 = bitmap;
        Bitmap bitmap3 = bitmap2;
        Bitmap bitmap4 = bitmap2;
        contentFragment.bitmap = bitmap4;
        return bitmap3;
    }

    public static ContentFragment newInstance(int i) {
        int resId = i;
        ContentFragment contentFragment = r6;
        ContentFragment contentFragment2 = new ContentFragment();
        ContentFragment contentFragment3 = contentFragment;
        Bundle bundle = r6;
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = bundle;
        bundle3.putInt(Integer.class.getName(), resId);
        contentFragment3.setArguments(bundle3);
        return contentFragment3;
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        View view2 = view;
        super.onViewCreated(view2, bundle);
        this.containerView = view2.findViewById(R.id.container);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.res = getArguments().getInt(Integer.class.getName());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle savedInstanceState = bundle;
        View rootView = layoutInflater.inflate(R.layout.fragment_main, viewGroup, false);
        this.mImageView = (ImageView) rootView.findViewById(R.id.image_content);
        this.mImageView.setClickable(true);
        this.mImageView.setFocusable(true);
        this.mImageView.setImageResource(this.res);
        return rootView;
    }

    public void takeScreenShot() {
        Thread thread = r5;
        Thread anonymousClass1 = new Thread() {
            {
                Thread thread = this;
            }

            public void run() {
                Bitmap bitmap = Bitmap.createBitmap(ContentFragment.this.containerView.getWidth(), ContentFragment.this.containerView.getHeight(), Config.ARGB_8888);
                Canvas canvas = r6;
                Canvas canvas2 = new Canvas(bitmap);
                ContentFragment.this.containerView.draw(canvas);
                Bitmap access$102 = ContentFragment.access$102(ContentFragment.this, bitmap);
            }
        };
        thread.start();
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }
}

