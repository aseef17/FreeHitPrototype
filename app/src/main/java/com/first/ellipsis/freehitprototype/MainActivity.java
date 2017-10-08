package com.first.ellipsis.freehitprototype;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import java.util.ArrayList;
import java.util.List;

import yalantis.com.sidemenu.model.SlideMenuItem;

public class MainActivity extends ActionBarActivity {
    List<SlideMenuItem> listItems = new ArrayList<>(); // the list of menu items


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SlideMenuItem item1 = new SlideMenuItem(ContentFragment.CLOSE, R.drawable.icn_close);
        listItems.add(item1);
        SlideMenuItem menuItem = new SlideMenuItem(ContentFragment.BUILDING, R.drawable.icn_1); //first parameter is the id of menu item,the second is the icon resouce
        listItems.add(menuItem);
        SlideMenuItem menuItem2 = new SlideMenuItem(ContentFragment.BOOK, R.drawable.icn_2);
        listItems.add(menuItem2);


    }
}
