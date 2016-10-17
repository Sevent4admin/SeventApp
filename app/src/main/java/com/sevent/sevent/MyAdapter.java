package com.sevent.sevent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Gizmo on 15/09/2016.
 */
public class MyAdapter extends FragmentPagerAdapter {
    public static int int_items = 3;
    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * Return fragment with respect to Position .
     */

    @Override
    public Fragment getItem(int position)
    {
        switch (position){
            case 0 : return new EventFragment();
            case 1 : return new SocialFragment();
            case 2 : return new ProfileFragment();
        }
        return null;
    }

    @Override
    public int getCount() {

        return int_items;

    }

    /**
     * This method returns the title of the tab according to the position.
     */

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0 :
                return "Event";
            case 1 :
                return "Social";
            case 2 :
                return "Profile";
        }
        return null;
    }
}

