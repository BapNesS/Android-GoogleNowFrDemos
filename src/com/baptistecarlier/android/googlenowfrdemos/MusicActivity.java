package com.baptistecarlier.android.googlenowfrdemos;

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
        TextView tv = (TextView) findViewById(R.id.musicactivity_tv);
        tv.setText("Requête : ["+query+"]");
    }

}
