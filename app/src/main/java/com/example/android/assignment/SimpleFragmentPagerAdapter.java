package com.example.android.assignment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.assignment.Fragments.ChristmasFragment;
import com.example.android.assignment.Fragments.ForHerFragment;
import com.example.android.assignment.Fragments.ForHimFragment;
import com.example.android.assignment.Fragments.ForMeFragment;
import com.example.android.assignment.Fragments.InspirationalFragment;

/**
 * Created by Mayank on 04-01-2018.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    Context context;

    public SimpleFragmentPagerAdapter(FragmentManager fm,Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0){
            return "CHRISTMAS";
        }else if(position==1){
            return "FOR HIM";
        }else if(position ==2){
            return "FOR HER";
        }else if(position==3){
            return "INSPIRATIONAL";
        }else if(position == 4){
            return "FOR ME";
        }else{
            return "NO NAME";
        }
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new ChristmasFragment();
        }else if(position==1){
            return new ForHimFragment();
        }else if(position ==2){
            return new ForHerFragment();
        }else if(position==3){
            return new InspirationalFragment();
        }else if(position == 4){
            return new ForMeFragment();
        }else{
            return new ForMeFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
