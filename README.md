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
  // query = "Titre de la chanson";
}
```


Commande vocale « Note à moi-même XXX »
-------------------------------

### AndroidManifest.xml 
```xml
<activity android:name="NoteActivity" android:label="@string/app_name">
  <intent-filter>
    <action android:name="com.google.android.gm.action.AUTO_SEND" />
      <category android:name="android.intent.category.DEFAULT" />
      <data android:mimeType="text/*" />
  </intent-filter>
</activity>
```

### NoteActivity.java
```java
public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  if (getIntent().getExtras().containsKey(Intent.EXTRA_TEXT)) {
    query = getIntent().getExtras().getString(Intent.EXTRA_TEXT);
	// query = "Contenu de la note";
  }
}
```


Commande vocale « Search for XXX on YYY »
-------------------------------

* XXX désigne ce qu'il faut rechercher.
* YYY est le nom de l'application.

Cette fonctionnalité n'est disponible sous certaines contraintes :
* Être sous Android 4.1 <em>Jelly Bean</em> (ou supérieur)
* Avoir l'application Google v3.5 (ou supérieur)
* Avoir la reconnaissance vocales en anglais US
* Que l'application soit sur le Play Store.

Pour tester ce code, il vous faudra utiliser la commmande adb suivante :
<pre>adb shell am start -a com.google.android.gms.actions.SEARCH_ACTION -e query FOOBAR com.baptistecarlier.android.googlenowfrdemos</pre>

### AndroidManifest.xml 
```xml
<activity android:name="SearchActionActivity" android:label="@string/app_name">
  <intent-filter>
    <action android:name="com.google.android.gms.actions.SEARCH_ACTION" />
    <category android:name="android.intent.category.DEFAULT" />
  </intent-filter>
</activity>
```

### SearchActionActivity.java
```java
public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  String query = getIntent().getStringExtra(SearchManager.QUERY);
  // query = "Intitulé à recherché";
}
```