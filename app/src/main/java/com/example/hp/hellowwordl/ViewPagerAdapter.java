package com.example.hp.hellowwordl;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

class ViewPagerAdapter extends PagerAdapter{
    public Object instantiateItem(ViewGroup collection, int position) {

        int resId = 0;
        switch (position) {
            case 0:
                resId = R.id.primaryContentCardView;
                break;
            case 1:
                resId = R.id.secondaryContentFrameLayout;
                break;
        }
        return collection.findViewById(resId);
    }
    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(@NonNull View arg0, @NonNull Object arg1) {
        return arg0 == ((View) arg1);
    }
}
