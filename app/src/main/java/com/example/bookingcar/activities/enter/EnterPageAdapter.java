package com.example.bookingcar.activities.enter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class EnterPageAdapter extends FragmentPagerAdapter {
    private Context context = null;
    public EnterPageAdapter(Context context, FragmentManager mgr) {
        super(mgr, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.context = context;
    }
    @Override
    public int getCount() {
        return(2);
    }
    @Override
    public Fragment getItem(int position) {
        return(EnterPageFragment.newInstance(position));
    }

    @Override
    public String getPageTitle(int position) {
        return (EnterPageFragment.getTitle(context, position));
    }
}
