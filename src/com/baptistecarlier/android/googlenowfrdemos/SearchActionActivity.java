package com.baptistecarlier.android.googlenowfrdemos;

import java.util.Formatter;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActionActivity extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_searchaction);

        String query = "";
        if (isSearchIntent(getIntent()) ) {
        	query = getIntent().getStringExtra(SearchManager.QUERY);

           // On formate simplement le rŽsultat de la requte pour l'affichage.
           TextView tv = (TextView) findViewById(R.id.searchactionactivity_tv_query);
           String formattable = getResources().getString(R.string.searchaction_query);
           Formatter formatter = new Formatter().format(formattable, query);
           tv.setText( formatter.toString() );
        }      
	}
	
	/*
	 * V�rification de l'Intent.
	 */
    private boolean isSearchIntent(final Intent intent) {
        if (intent == null) {
            return false;
        }
        return ("com.google.android.gms.actions.SEARCH_ACTION".equals(intent.getAction()));
    }

}
