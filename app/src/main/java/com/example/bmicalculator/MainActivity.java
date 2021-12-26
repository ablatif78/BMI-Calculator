package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText heighttext,weighttext;
    RadioGroup myRadioGroup;
    TextView bmiview;
    Double centimetre,inches;
    Double result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heighttext=findViewById(R.id.heightID);
        weighttext=findViewById(R.id.weightID);
        myRadioGroup=findViewById(R.id.radiogroupID);
        bmiview=findViewById(R.id.BMIviewID);
    }



    public void claculateFunction(View view) {
        Double numbervalue1=Double.parseDouble(heighttext.getText().toString());
        int selectedRadioBTNID= myRadioGroup.getCheckedRadioButtonId();

        if (selectedRadioBTNID==R.id.radiobutton1){
            centimetre=numbervalue1 * 0.01;
            result = centimetre * centimetre;
        }
        else {
            inches=numbervalue1 * 0.0254;
            result=inches*inches;
        }

        Double numbervalue2= Double.parseDouble(weighttext.getText().toString());

        Double numbervalue= numbervalue2 / result;
        if (numbervalue==25.0 || 25.0<numbervalue ){
            bmiview.setText("Overweight"+"\n"+(Math.round(numbervalue)));
        }
        else {
            bmiview.setText("Healthy"+"\n"+(Math.round(numbervalue)));
        }
    }


}