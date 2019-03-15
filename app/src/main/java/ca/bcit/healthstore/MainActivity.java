package ca.bcit.healthstore;

import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Attach the SectionsPageAdapter to the ViewPager
        SectionsPageAdapter pagerAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);

        // Attach the ViewPager to the TabLayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);

    }

    public class SectionsPageAdapter extends FragmentPagerAdapter {
        public SectionsPageAdapter(android.support.v4.app.FragmentManager fm) { super(fm); }

        @Override
        public int getCount() { return 4; }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new TopFragment();
                case 1:
                    return new BakeryFragment();
                case 2:
                    return new ProduceFragment();
                case 3:
                    return new SeafoodFragment();
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getText(R.string.home_tab);
                case 1:
                    return getResources().getText(R.string.bakery_tab);
                case 2:
                    return getResources().getText(R.string.produce_tab);
                case 3:
                    return getResources().getText(R.string.seafood_tab);
            }
            return null;
        }

    }

    public void onClickDone(View v) {
        CharSequence text = "Your request for more information has been received.";
        Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinator), text, Snackbar.LENGTH_LONG);
        snackbar.setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast t = Toast.makeText(MainActivity.this, "Undone!", Toast.LENGTH_LONG);
                t.show();
            }
        });
        snackbar.show();
    }

}
