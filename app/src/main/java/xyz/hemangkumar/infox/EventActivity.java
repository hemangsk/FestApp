package xyz.hemangkumar.infox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.github.florent37.materialviewpager.MaterialViewPager;

import java.util.ArrayList;

import xyz.hemangkumar.infox.fragments.AboutEvent;
import xyz.hemangkumar.infox.fragments.AboutFragment;
import xyz.hemangkumar.infox.fragments.EventRegistration;
import xyz.hemangkumar.infox.fragments.EventRules;
import xyz.hemangkumar.infox.models.Event;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_activity);
        Intent intent = getIntent();
        final int pos = intent.getIntExtra("POS", 0);

        final ArrayList<Event> data = Event.getData();



        MaterialViewPager materialViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);
        Toolbar toolbar = materialViewPager.getToolbar();

        if(toolbar != null){
            setSupportActionBar(toolbar);
            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayUseLogoEnabled(false);
            actionBar.setHomeButtonEnabled(true);


        }



        materialViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public Fragment getItem(int position) {
                Log.e("POSITION = ", "POSITION" + String.valueOf(position));
                ArrayList<Event> eventArrayList = new ArrayList<Event>();
                if(data != null){
                    eventArrayList = data;
                }
                switch(position % 3){

                    case 0:return AboutEvent.newInstance(eventArrayList, pos);
                    case 1: return EventRules.newInstance(eventArrayList, pos);
                    case 2: return EventRegistration.newInstance(eventArrayList, pos);
                    default:
                        return AboutFragment.newInstance();
                }
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch(position % 4){
                    case 0: return "ABOUT";
                    case 1: return "RULES";
                    case 2: return "REGISTRATION";

                }
                return "";
            }
        });



        materialViewPager.getViewPager().setOffscreenPageLimit(materialViewPager.getViewPager().getAdapter().getCount());
        materialViewPager.getPagerTitleStrip().setViewPager(materialViewPager.getViewPager());



    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
