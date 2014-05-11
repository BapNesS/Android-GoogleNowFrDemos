package com.baptistecarlier.android.googlenowfrdemos;

import java.util.Formatter;

import android.app.Activity;
import android.app.SearchManager;
import android.os.Bundle;
import android.widget.TextView;

public class MusicActivity extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_music);
        String query = getIntent().getStringExtra(SearchManager.QUERY);
        // query = "XXX";
        
        // On formate simplement le résultat de la requête pour l'affichage.
        TextView tv = (TextView) findViewById(R.id.musicactivity_tv_query);
        String formattable = getResources().getString(R.string.music_query);
		Formatter formatter = new Formatter().format(formattable, query);
        tv.setText( formatter.toString() );
	}

}
