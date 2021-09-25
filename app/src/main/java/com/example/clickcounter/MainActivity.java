package com.example.clickcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button BtnPlus;
    private Button BtnMin;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.ClickCounter);
        BtnPlus = findViewById(R.id.BtnPlus);
        BtnMin = findViewById(R.id.BtnMin);
        textView.setOnClickListener(clickListener);
        BtnPlus.setOnClickListener(clickListener);
        BtnMin.setOnClickListener(clickListener);

    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.BtnPlus : plus();
                break;
                case R.id.BtnMin : min();
                break;
            }

            counterUpdate();
            reset();
            prime(count);
        }
    };

    private void counterUpdate() {
        if (count == 0) {
            textView.setTextColor(Color.BLUE);
        }
        if (count < 0) {
            textView.setTextColor(Color.RED);
        }
        if (count > 0) {
            textView.setTextColor(Color.GREEN);
        }
    }

    private void plus(){
        count++;
        textView.setText(count + "");
    }

    private void min(){
        count--;
        textView.setText(count + "");
    }

    private void reset(){
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                count = 0;
                textView.setText(Integer.toString(count));
                counterUpdate();
                return true;
            }
        });
    }

    private void prime(int count){
        int a = 0;
        if(count == 0 || count == 1){

        } else {
            for(int i = 1; i <= count/2; i++){
                if(count % i == 0){
                    a++;
                }
            }
            if(a > 1){

            }else {
                textView.setTextColor(Color.parseColor("#FFFFFF"));
            }
        }
    }

    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("0", (String)textView.getText());
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        textView.setText(savedInstanceState.getString("0"));
    }
}
