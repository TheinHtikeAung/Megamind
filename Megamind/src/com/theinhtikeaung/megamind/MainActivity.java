package com.theinhtikeaung.megamind;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

		@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Needs to be called before setting the content view
		supportRequestWindowFeature(Window.FEATURE_PROGRESS);
		
//	    supportRequestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);

	    // Now set the content view
	    setContentView(R.layout.activity_main);
	    
	    // When ready, show the indeterminate progress bar
//	    setSupportProgressBarIndeterminateVisibility(true);

	    setSupportProgressBarIndeterminate(true); 
//	    setProgressBarIndeterminate(true);
	    setSupportProgressBarVisibility(true);
	}

	private ShareActionProvider mShareActionProvider;


	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		// Set up ShareActionProvider's default share intent
	    MenuItem shareItem = menu.findItem(R.id.actoin_search);
	    mShareActionProvider = (ShareActionProvider)MenuItemCompat.getActionProvider(shareItem);
	    mShareActionProvider.setShareIntent(getDefaultIntent());
	    
	    
		
		return super.onCreateOptionsMenu(menu);
	}
	
	/** Defines a default (dummy) share intent to initialize the action provider.
	  * However, as soon as the actual content to be used in the intent
	  * is known or changes, you must update the share intent by again calling
	  * mShareActionProvider.setShareIntent()
	  */
	private Intent getDefaultIntent() {
	    Intent intent = new Intent(Intent.ACTION_SEND);
	      
	    intent.putExtra(Intent.EXTRA_SUBJECT, "Voice Title"); 
	    
//	    intent.setType("image/*");
	    intent.setType("text/plain");  
        intent.putExtra(Intent.EXTRA_TEXT,  "http://theinhtikeaung.com");  
	    return intent;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case R.id.actoin_search:
	        	//Toast.makeText(this, "Search Menu is selected", Toast.LENGTH_LONG).show();
	        	
	            return true;
	        case R.id.action_phone:
	            //composeMessage();
	        	//Toast.makeText(this, "Phone Menu is selected", Toast.LENGTH_LONG).show();
	        	startActivity(new Intent(this, SecondActivity.class));
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}
