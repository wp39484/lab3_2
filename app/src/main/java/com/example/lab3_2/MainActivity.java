package com.example.lab3_2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Kliknięto przycisk FAB", Toast.LENGTH_SHORT).show();

                Intent intencja = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intencja,REQUEST_IMAGE_CAPTURE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id){
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "Kliknięto przycisk settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_contact:
                Toast.makeText(getApplicationContext(), "Kliknięto przycisk contact", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_about:
                Toast.makeText(getApplicationContext(), "Kliknięto przycisk about", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_logout:
                Toast.makeText(getApplicationContext(), "Kliknięto przycisk logout", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void kliknij(View view) {
        Toast.makeText(getApplicationContext(), "Kliknięto przycisk button", Toast.LENGTH_SHORT).show();

        Intent intencja = new Intent(this, LoginActivity.class);
        startActivity(intencja);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        Bundle extras = data.getExtras();
        Bitmap imageBitmap = (Bitmap) extras.get("data");
        ConstraintLayout lay = findViewById(R.id.cont);
        lay.setBackground(new BitmapDrawable(getResources(),imageBitmap));
    }

    public void losuj(View view) {

        Random liczba = new Random();
        int elo = liczba.nextInt(5);
        Toast.makeText(getApplicationContext(), ""+elo , Toast.LENGTH_SHORT).show();


        View but2 = findViewById(R.id.button2);
        switch(elo) {
            case 0:
                but2.setBackgroundResource(R.drawable.gala);
                break;
            case 1:
                but2.setBackgroundResource(R.drawable.ic_launcher_background);
                break;
            case 2:
                but2.setBackgroundResource(R.drawable.photo);
                break;
            case 3:
                but2.setBackgroundResource(R.drawable.ic_launcher_foreground);
                break;
            case 4:
                but2.setBackgroundColor(Color.GREEN);
                break;
        }
    }
}
