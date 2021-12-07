package com.example.homework_1;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MotionEvent;
import android.view.View;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.homework_1.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bstar, bhash, clear, sd1, sd2, sd3;
    SpeedDial sd_1;
    SpeedDial sd_2;
    SpeedDial sd_3;
    ImageButton bcall;
    TextView number_written;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText nameLabel,numberLabel;
    Button save_button, close_button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButtons();
        setListeners();
        initSpeedDials();
        if (ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},100);
        }

    }

    private void initButtons()
    {
        b0 = findViewById(R.id.b0);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        bstar = findViewById(R.id.bstar);
        bhash = findViewById(R.id.bhash);
        clear = findViewById(R.id.clear);
        sd1 = findViewById(R.id.speed_dial_1);
        sd2 = findViewById(R.id.speed_dial_2);
        sd3 = findViewById(R.id.speed_dial_3);
        bcall = findViewById(R.id.bcall);
        number_written = findViewById(R.id.number_written);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setListeners()
    {
        b0.setOnClickListener(new View.OnClickListener(){
              @Override
              public void onClick(View v) {
                  number_written.setText(number_written.getText().toString()+"0");
              }
          }
        );
        b1.setOnClickListener(new View.OnClickListener(){
              @Override
              public void onClick(View v) {
                  number_written.setText(number_written.getText().toString()+"1");
              }
          }
        );
        b2.setOnClickListener(new View.OnClickListener(){
              @Override
              public void onClick(View v) {
                  number_written.setText(number_written.getText().toString()+"2");
              }
          }
        );
        b3.setOnClickListener(new View.OnClickListener(){
              @Override
              public void onClick(View v) {
                  number_written.setText(number_written.getText().toString()+"3");
              }
          }
        );
        b4.setOnClickListener(new View.OnClickListener(){
              @Override
              public void onClick(View v) {
                  number_written.setText(number_written.getText().toString()+"4");
              }
          }
        );
        b5.setOnClickListener(new View.OnClickListener(){
              @Override
              public void onClick(View v) {
                  number_written.setText(number_written.getText().toString()+"5");
              }
          }
        );
        b6.setOnClickListener(new View.OnClickListener(){
              @Override
              public void onClick(View v) {
                  number_written.setText(number_written.getText().toString()+"6");
              }
          }
        );
        b7.setOnClickListener(new View.OnClickListener(){
              @Override
              public void onClick(View v) {
                  number_written.setText(number_written.getText().toString()+"7");
              }
          }
        );
        b8.setOnClickListener(new View.OnClickListener(){
              @Override
              public void onClick(View v) {
                  number_written.setText(number_written.getText().toString()+"8");
              }
          }
        );
        b9.setOnClickListener(new View.OnClickListener(){
              @Override
              public void onClick(View v) {
                  number_written.setText(number_written.getText().toString()+"9");
              }
          }
        );
        clear.setOnClickListener(new View.OnClickListener(){
              @Override
              public void onClick(View v) {
                  number_written.setText("");
              }
          }
        );
        sd1.setOnClickListener(new View.OnClickListener(){
              @Override
              public void onClick(View v) {
                  call_number(sd_1.getNumber());
              }
          }
        );
        sd2.setOnClickListener(new View.OnClickListener(){
              @Override
              public void onClick(View v) {
                  call_number(sd_2.getNumber());
              }
          }
        );

        sd3.setOnClickListener(new View.OnClickListener(){
               @Override
               public void onClick(View v) {
                   call_number(sd_3.getNumber());
               }
           }
        );

        sd1.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View arg0) {
                changeSD_Info(sd_1);
                return true;
            }
        });

        sd2.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View arg0) {
                changeSD_Info(sd_2);
                return true;
            }
        });

        sd3.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View arg0) {
                changeSD_Info(sd_3);
                return true;
            }
        });

        bcall.setOnClickListener(new View.OnClickListener(){
              @Override
              public void onClick(View v) {
                  call_number(number_written.getText().toString());
              }
          }
        );
    }

    private void initSpeedDials()
    {
        sd_1 = new SpeedDial();
        sd_2 = new SpeedDial();
        sd_3 = new SpeedDial();
    }
    private void call_number(String number)
    {
        String activity_input = "tel:" + number;


        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(activity_input)));
    }

    public void changeSD_Info(SpeedDial sd)
    {
        dialogBuilder = new AlertDialog.Builder(this);
        final View popUpView = getLayoutInflater().inflate(R.layout.sp_info, null);
        nameLabel = (EditText) popUpView.findViewById(R.id.label_name);
        numberLabel = (EditText) popUpView.findViewById(R.id.label_number);
        save_button = (Button) popUpView.findViewById(R.id.save_button);
        close_button = (Button) popUpView.findViewById(R.id.close_button);

        dialogBuilder.setView(popUpView);
        dialog = dialogBuilder.create();
        dialog.show();

        save_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                sd.setSD(nameLabel.getText().toString(), numberLabel.getText().toString());
                dialog.dismiss();
            }
        });

        close_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}