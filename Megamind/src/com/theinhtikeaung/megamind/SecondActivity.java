package com.theinhtikeaung.megamind;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class SecondActivity extends ActionBarActivity{
	
	private ProgressBar mProgressBar;

    @Override
    public void setContentView(View view) {
        init().addView(view);
    }

    @Override
    public void setContentView(int layoutResID) {
        getLayoutInflater().inflate(layoutResID,init(),true);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        init().addView(view,params);
    }

    private ViewGroup init(){
        super.setContentView(R.layout.progress);
        mProgressBar = (ProgressBar) findViewById(R.id.activity_bar);
        return (ViewGroup) findViewById(R.id.activity_frame);
    }

    protected ProgressBar getProgressBar(){
        return mProgressBar;
    }
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.progress);
		
		ActionBar actionBar = getSupportActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    
	    getProgressBar().setProgress(80);
	}
	
	MenuItem refresh;
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    getMenuInflater().inflate(R.menu.second_main, menu);

	    // refresh menu item
	    refresh = menu.findItem(R.id.actoin_refresh);
	    
//	    refresh.setActionView(R.layout.actionbar_indeterminate_progress);
//	    refresh.setActionView(null);

	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected (MenuItem item){
		switch (item.getItemId()){
			case android.R.id.home:
				finish();
				return true;
		
	          case R.id.actoin_refresh:
	        	  refresh.setActionView(R.layout.actionbar_indeterminate_progress);
	        	  
	        	  new Handler().postDelayed(new Runnable(){
	        		    public void run() {
	        		    	refresh.setActionView(null);
	        		    }
	        		}, 5000);
	        	  
	          break;
	    }
	    return true;
	}
}
