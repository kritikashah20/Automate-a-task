package com.example.sendmessage;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


//    EditText number;
//    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        number = findViewById(R.id.editText);
//        imageView = findViewById(R.id.imageView);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @RequiresApi(api = Build.VERSION_CODES.M)
//            @Override
//            public void onClick(View v) {
//                String num = number.getText().toString();
//                if (num.trim().length() > 0) {
//                    String dial = "tel:" + num;
//                    if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                        // TODO: Consider calling
//                        //    Activity#requestPermissions
//                        // here to request the missing permissions, and then overriding
//                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//                        //                                          int[] grantResults)
//                        // to handle the case where the user grants the permission. See the documentation
//                        // for Activity#requestPermissions for more details.
//                        return;
//                    }
//                    startActivity(new Intent((Intent.ACTION_CALL), Uri.parse(dial)));
//                }
//
//                else {
//                    Toast.makeText(getApplicationContext(), "Enter Valid Number", Toast.LENGTH_LONG).show();
//                }
//            }
//        });


    final EditText number , sms;
    Button button;

        number=findViewById(R.id.editText);
        sms=findViewById(R.id.editText2);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SmsManager smsManager =SmsManager.getDefault();
                    smsManager.sendTextMessage(number.getText().toString(), null, sms.getText().toString(), null, null);
                    Toast.makeText(getApplicationContext(), "Sent Successfully", Toast.LENGTH_LONG).show();
                }
                catch(Exception e) {
                    Toast.makeText(getApplicationContext(),"Failed to send", Toast.LENGTH_LONG).show();
                }
            }
        });
       }
}
