package com.example.parksinyoung.moblieprogramming_syjy.adaper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.parksinyoung.moblieprogramming_syjy.BoardAnonymousFragment;
import com.example.parksinyoung.moblieprogramming_syjy.BoardClassEstimFragment;
import com.example.parksinyoung.moblieprogramming_syjy.BoardLossFragment;
import com.example.parksinyoung.moblieprogramming_syjy.BoardTradeFragment;


public class BoardTabPageAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    public BoardTabPageAdapter( FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem( int position) {

        switch (position) {
            case 0:
                return new BoardClassEstimFragment();

            case 1:
                return new BoardTradeFragment();

            case 2:
                return new BoardAnonymousFragment();

            case 3:
                return new BoardLossFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
