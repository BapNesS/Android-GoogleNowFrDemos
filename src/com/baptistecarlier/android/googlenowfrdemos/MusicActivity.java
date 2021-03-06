package com.baptistecarlier.android.googlenowfrdemos;

import java.util.Formatter;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MusicActivity extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_music);

        String query = "";
        if (isMusicIntent(getIntent())) {
            // Correspondant au contenu musical � jouer.
        	query = getIntent().getStringExtra(SearchManager.QUERY);

            // On formate simplement le r�sultat de la requ�te pour l'affichage.
            TextView tv = (TextView) findViewById(R.id.musicactivity_tv_query);
            String formattable = getResources().getString(R.string.music_query);
    		Formatter formatter = new Formatter().format(formattable, query);
            tv.setText( formatter.toString() );  
        }      
	}
	
	/*
	 * V�rification de l'Intent.
	 */
	private boolean isMusicIntent(final Intent intent) {
        if (intent == null) {
            return false;
        }
        return ("android.media.action.MEDIA_PLAY_FROM_SEARCH".equals(intent.getAction()));
    }

}
