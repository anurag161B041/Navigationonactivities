package com.hitmain.navigationonactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView tview;
    private Button bbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle extras=getIntent().getExtras();
        tview=(TextView)findViewById(R.id.textView2);
        bbutton=(Button)findViewById(R.id.mybutton);

        if(extras!=null){
            String message=extras.getString("Message");
            String msg=extras.getString("India");
            int myInt=extras.getInt("Mayank");
            tview.setText(  message +   msg + String.valueOf(myInt));
        }
        bbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent=getIntent();
                returnIntent.putExtra("returnData", "From SecondActivity");
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        });

    }
}
