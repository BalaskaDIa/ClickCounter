package com.example.clickcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView txtCounter;
    private Button buttonPlus;
    private Button buttonMinus;
    private int counter;

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view){
            switch (view.getId()) {
                case R.id.ButtonPlus :
                    counterPlus();
                    break;
                case R.id.ButtonMinus :
                    counterMinus();
                    break;

            }
            if (counter > 0) {
                txtCounter.setTextColor(Color.GREEN);
            }
            else if (counter < 0) {
                txtCounter.setTextColor(Color.RED);
            } else {
                txtCounter.setTextColor(Color.BLUE);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCounter = (TextView) findViewById(R.id.Counter);
        buttonPlus = (Button) findViewById(R.id.ButtonPlus);
        buttonPlus.setOnClickListener(clickListener);
        buttonMinus = (Button) findViewById(R.id.ButtonMinus);
        buttonMinus.setOnClickListener(clickListener);
        txtCounter = (TextView) findViewById(R.id.Counter);
        counterUpdate();

    }
    private void counterUpdate() {
        counter = 0;
        txtCounter.setText(counter + "");
    }
    private void counterPlus() {
        counter++;
        txtCounter.setText(counter + "");
    }
    private void counterMinus() {
        counter--;
        txtCounter.setText(counter+"");
    }


}
