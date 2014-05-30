package com.baptistecarlier.android.googlenowfrdemos;

import java.util.Formatter;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NoteActivity extends Activity {

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_note);

        String query = "";
        if (isNoteIntent(getIntent()) ) {
            // Correspondant au contenu de la note.
            if (getIntent().getExtras().containsKey(Intent.EXTRA_TEXT)) {
            	query = getIntent().getExtras().getString(Intent.EXTRA_TEXT);
            }
        	
            // On formate simplement le résultat de la requête pour l'affichage.
            TextView tv = (TextView) findViewById(R.id.noteactivity_tv_query);
            String formattable = getResources().getString(R.string.note_query);
    		Formatter formatter = new Formatter().format(formattable, query);
            tv.setText( formatter.toString() );  
        }      
	}
	
	/*
	 * Vérification de l'Intent.
	 */
    private boolean isNoteIntent(final Intent intent) {
        if (intent == null) {
            return false;
        }
        return ("com.google.android.gm.action.AUTO_SEND".equals(intent.getAction()));
    }

}
