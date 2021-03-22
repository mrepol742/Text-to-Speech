package com.android.DROID_MJ.texttospeech;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Locale;
import android.view.ViewGroup;

public class b extends Activity {
    private TextView a;
    private ImageButton b;
    private final int c = 100;
    private String d;
    private ArrayList<String> e;
    private Intent f;
    private String g = "Say Hi to DROID_MJ";
    private View h;
    private Toast i;
    private int j = 0;

    protected void onCreate(Bundle bundle) {
        if (VERSION.SDK_INT >= 21) {
            setTheme(R.style.b);
        }
        super.onCreate(bundle);
        setContentView(R.layout.b);
        this.a = (TextView) findViewById(R.id.i);
        this.b = (ImageButton) findViewById(R.id.j);
        this.b.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                b.this.b1();
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 100:
                if (i2 == -1 && intent != null) {
                    this.e = intent.getStringArrayListExtra("android.speech.extra.RESULTS");
                    this.d = new StringBuilder(String.valueOf(this.a.getText().toString())).append("\n").append((String) this.e.get(0)).toString();
                    this.a.setText(this.d);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void b1() {
        this.f = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        this.f.putExtra("android.speech.extra.LANGUAGE", Locale.getDefault());
        this.f.putExtra("android.speech.extra.PROMPT", this.g);
        try {
            startActivityForResult(this.f, 100);
        } catch (ActivityNotFoundException e) {
            b2();
        }
    }

    private void b2() {
        this.h = getLayoutInflater().inflate(R.layout.c, (ViewGroup) findViewById(R.id.k));
        ((TextView) this.h.findViewById(R.id.l)).setText(R.string.e);
        this.i = new Toast(getApplicationContext());
        this.i.setDuration(b.this.j);
        this.i.setView(this.h);
        this.i.show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.b, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.h:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
         }
    }
}

