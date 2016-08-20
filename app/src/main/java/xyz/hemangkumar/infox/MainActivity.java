package xyz.hemangkumar.infox;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.github.florent37.materialviewpager.MaterialViewPager;

import xyz.hemangkumar.infox.fragments.AboutFragment;
import xyz.hemangkumar.infox.fragments.MainAboutFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


        try {
         //   AsynchronousGet.task();

            Log.e("H", "");

        } catch (Exception e) {
            e.printStackTrace();
        }

        materialViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public Fragment getItem(int position) {
                Log.e("POSITION = ", "POSITION" + String.valueOf(position));
                switch(position % 4){

                    case 0: return MainAboutFragment.newInstance();
                    case 1: return AboutFragment.newInstance();

                }
                return MainAboutFragment.newInstance();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch(position % 4){
                    case 0: return "ABOUT";
                    case 1: return "DETAILS";
                    case 2: return "SPONSORS";
                    case 3: return "TEAM";
                }
                return "";
            }
        });



        materialViewPager.getViewPager().setOffscreenPageLimit(materialViewPager.getViewPager().getAdapter().getCount());
        materialViewPager.getPagerTitleStrip().setViewPager(materialViewPager.getViewPager());



    }

}
