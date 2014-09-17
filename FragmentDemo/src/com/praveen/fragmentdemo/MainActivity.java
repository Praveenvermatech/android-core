package com.praveen.fragmentdemo;

import android.os.Bundle;
import android.os.Parcelable;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.ViewGroup;

public class MainActivity extends FragmentActivity {

	ViewPager viewPager=null;
	
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        viewPager=(ViewPager) findViewById(R.id.pager);
        FragmentManager fragmentManager=getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentManager));
    }
    
}

class MyAdapter extends FragmentPagerAdapter {

	public MyAdapter(FragmentManager fm) {
		
		super(fm);
		System.out.println("My Adapter Counstructor");
	}

	@Override
	public Fragment getItem(int i) {
		// TODO Auto-generated method stub
		Fragment fragment=null;
		
		System.out.println("Fragment "+i);
		if (i==0) {
			
			fragment=new Fragment_A();
		}
		if(i==1) {
			fragment=new Fragment_B();
		}
		if(i==2) {
			fragment=new Fragment_C();
			
		}
		
		return fragment;
	}

	@Override
	public int getCount() {
System.out.println("get count is called.");
		return 3;
	}
	
	@Override
	public Parcelable saveState() {
	
		System.out.println("onSave STATE");
		// TODO Auto-generated method stub
		return super.saveState();
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// TODO Auto-generated method stub
		super.destroyItem(container, position, object);
	System.out.println("DESTROY ITEM");
	}
	
	@Override
	public void restoreState(Parcelable state, ClassLoader loader) {
		// TODO Auto-generated method stub
		super.restoreState(state, loader);
	System.out.println("RESTORE STATE");
	}
	
	@Override
	public void startUpdate(ViewGroup container) {
		// TODO Auto-generated method stub
		super.startUpdate(container);
	System.out.println("START UPDATE");
	}
}