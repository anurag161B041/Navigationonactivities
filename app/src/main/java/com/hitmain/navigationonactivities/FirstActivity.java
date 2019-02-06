package com.hitmain.navigationonactivities;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {
    private Button mybutton;
    private final int REQUEST_CODE=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        mybutton=(Button) findViewById(R.id.navigatebutton);
        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("Message","HY");
                intent.putExtra("Mayank",456);
                intent.putExtra("India","India is the best nation in the world");
                startActivityForResult(intent,REQUEST_CODE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE){
            if(resultCode==RESULT_OK){
                String result=data.getStringExtra("returnData");
                Toast.makeText(FirstActivity.this,result,Toast.LENGTH_LONG).show();
            }
        }
    }
}
