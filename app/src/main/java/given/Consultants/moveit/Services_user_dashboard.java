package given.Consultants.moveit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import given.Consultants.moveit.fragments.pageFragment1;
import given.Consultants.moveit.fragments.pageFragment3;
import given.Consultants.moveit.fragments.pagefragment2;

public class Services_user_dashboard extends AppCompatActivity {

    private ViewPager pager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_user_dashboard);

        List<Fragment> list = new ArrayList<>();
        list.add(new pageFragment1());
        list.add(new pagefragment2());
        list.add(new pageFragment3());

        pager = findViewById(R.id.pager);
        pagerAdapter = new SlidePageAdapter(getSupportFragmentManager(), list);

        pager.setAdapter(pagerAdapter);
    }
}