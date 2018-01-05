package com.example.android.assignment;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import static android.R.attr.handle;
import static android.R.layout.simple_spinner_item;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getSupportFragmentManager(),this);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_catalog,menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){

            case R.id.search:
                Toast.makeText(this,"Search Button Clicked",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.options:
                showAlertDialogBox();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void showAlertDialogBox(){
        LayoutInflater inflater = LayoutInflater.from(this);
        final View textEntryView = inflater.inflate(R.layout.dialog_box,null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("       ");

        String items[] = {getString(R.string.ALL_PHOTOS),getString(R.string.ONE_PHOTO),getString(R.string.TWO_PHOTO),getString(R.string.FIVE_PHOTO)};
        String price[] = {getString(R.string.ALL_PRICES),getString(R.string.LESS_THAN_500),getString(R.string.MORE_THAN_500)};

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,simple_spinner_item,items);
        ArrayAdapter<String> priceAdapter = new ArrayAdapter<String>(this,simple_spinner_item,price);

        spinnerAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        priceAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        Spinner photoSpinner = (Spinner) textEntryView.findViewById(R.id.photos_spinner);
        Spinner priceSpinner = (Spinner) textEntryView.findViewById(R.id.price_spinner);

        photoSpinner.setAdapter(spinnerAdapter);
        priceSpinner.setAdapter(priceAdapter);

        builder.setView(textEntryView);

        builder.setPositiveButton(getString(R.string.Positive_Button), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton(getString(R.string.Negative_Button), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();
    }
}
