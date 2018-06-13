package com.example.peilin.rpilightcontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    public void send(String keyword) {
        MessageSender messageSender = new MessageSender();
        messageSender.execute(keyword);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button flashBtn = (Button) findViewById(R.id.button);
        flashBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(MainActivity.this, "Sending command", Toast.LENGTH_SHORT).show();
        try {
            send("flash");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
