package com.haley.project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.haley.checkcodeview.CheckCodeCompleteListener;
import com.haley.checkcodeview.CheckCodeEditText;

public class MainActivity extends AppCompatActivity implements CheckCodeCompleteListener {


    private CheckCodeEditText codeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.codeEditText = (CheckCodeEditText) findViewById(R.id.checkcode_view);
        codeEditText.addCompleteListener(this);
    }

    @Override
    public void finish() {
        Toast.makeText(this, "finish input code" +codeEditText.getText() , Toast.LENGTH_LONG).show();
    }
}
