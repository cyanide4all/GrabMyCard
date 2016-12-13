package cyanoboru.grabmycard;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import cyanoboru.grabmycard.Main;
import cyanoboru.grabmycard.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Signin extends AppCompatActivity implements View.OnClickListener {

    protected Button sigin;
    protected Button register;
    protected Button google;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_signin);

        sigin = (Button) findViewById(R.id.SiginSigin);
        register = (Button) findViewById(R.id.SiginRegister);
        google = (Button) findViewById(R.id.SiginGoogle);

        // extension point
        sigin.setOnClickListener(this);
        register.setOnClickListener(this);
        google.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // extension point
        startActivity(new Intent(Signin.this,Main.class));
    }
}
