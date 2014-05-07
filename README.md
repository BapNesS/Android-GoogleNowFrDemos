Android-GoogleNowFrDemos
========================

Les samples de code de [GoogleNow.fr](http://www.googlenow.fr) pour Android.


Commande vocale « Ecouter XXX »
-------------------------------

Pour que votre application Android puisse être appelée avec la commande vocale « écouter XXX », il vous suffit simplement d'ajouter le code suivant.

### AndroidManifest.xml 
```xml
<activity android:name="MusicActivity" android:label="@string/app_name">
  <intent-filter>
    <action android:name="android.media.action.MEDIA_PLAY_FROM_SEARCH" />
    <category android:name="android.intent.category.DEFAULT" />
  </intent-filter>
</activity>
```

### MusicActivity.java
```java
public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  String query = getIntent().getStringExtra(SearchManager.QUERY);
  // query = "XXX";
}
```
