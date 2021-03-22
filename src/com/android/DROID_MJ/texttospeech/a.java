package com.android.DROID_MJ.texttospeech;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;
import java.util.Locale;
import android.view.KeyEvent;

public class a extends Activity {
    private ImageButton a;
    private AudioManager b;
    private ImageButton c;
    private TextToSpeech d;
    private EditText e;
    private String f;
    private SeekBar g;
    private String h = "What's on your mind?";

    private void initControls(SeekBar seek, final int stream) {
    seek.setMax(this.b.getStreamMaxVolume(stream));
    seek.setProgress(this.b.getStreamVolume(stream));
    seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
          public void onProgressChanged(SeekBar bar, int progress, boolean fromUser) {
          a.this.b.setStreamVolume(stream, progress, AudioManager.FLAG_PLAY_SOUND);
    }

          public void onStartTrackingTouch(SeekBar bar) {
          }

           public void onStopTrackingTouch(SeekBar bar) {
          }
    });
}

    protected void onCreate(Bundle a) {
        super.onCreate(a);
        setContentView(R.layout.a);
        this.e = (EditText) findViewById(R.id.a);
        this.c = (ImageButton) findViewById(R.id.b);
        this.a = (ImageButton) findViewById(R.id.c);
        this.b = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        this.g = (SeekBar)findViewById(R.id.d);
        initControls(this.g, AudioManager.STREAM_MUSIC);
        this.e.setHint(this.h);
        this.d = new TextToSpeech(getApplicationContext(), new OnInitListener() {
            public void onInit(int i) {
                if (i != -1) {
                    a.this.d.setLanguage(Locale.US);
                }
            }
        });
        this.a.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                a.this.a1();
            }
        });
        this.c.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                a.this.a2();
            }
        });
        this.a.setOnLongClickListener(new OnLongClickListener() {
            public boolean onLongClick(View v) {
                a5();
            return true;
            }
        });
        this.c.setOnLongClickListener(new OnLongClickListener() {
            public boolean onLongClick(View v) {
                a4();
            return true;
            }
        });
    }

    public void onDestroy() {
        if (this.d != null) {
            this.d.stop();
            this.d.shutdown();
        }
        super.onDestroy();
    }

    private void a1() {
        a3();
    }

    private void a2() {
        this.f = this.e.getText().toString();
        Toast.makeText(getApplicationContext(), this.f, 0).show();
        this.d.speak(this.f, 0, null);
    }

    private void a3() {
        System.exit(0);
    }
   
    private void a4() {
        Toast.makeText(this, "Voice", 0).show();
    }
    
    private void a5() {
        Toast.makeText(this, "Exit", 0).show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.a, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.f:
                startActivity(new Intent(this, b.class));
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
         }
    }
}
