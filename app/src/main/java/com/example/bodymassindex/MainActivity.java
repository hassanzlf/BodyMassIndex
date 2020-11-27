package com.example.bodymassindex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText Height, Weight;
    TextView answer;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Height=(EditText) findViewById(R.id.Height);
        Weight=(EditText) findViewById(R.id.Weight);
        answer=(TextView) findViewById(R.id.answer);
        calculate=(Button) findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();

            }
        });

    }
    private void calculateBMI(){
        String heightStr=Height.getText().toString();
        String weightStr=Weight.getText().toString();

        if(heightStr!=null && !"".equals(heightStr) && weightStr!=null &&!"".equals(weightStr)){
            float heightvalue=Float.parseFloat(heightStr)/100;
            float weightValue=Float.parseFloat(weightStr);

            float bmi =weightValue/(heightvalue * heightvalue);

            displayBMI(bmi);

        }

        }
    private void displayBMI(float bmi){
        String bmiLabel="";

        if (Float.compare(bmi, 15f) <= 0) {
            bmiLabel = "Very severely underweight";
        } else if (Float.compare(bmi, 15f) > 0  &&  Float.compare(bmi, 16f) <= 0) {
            bmiLabel = "very underweight";
        } else if (Float.compare(bmi, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {
            bmiLabel = "Underweight";
        } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {
            bmiLabel = "Normal";
        } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
            bmiLabel = "Overweight";
        } else if (Float.compare(bmi, 30f) > 0  &&  Float.compare(bmi, 35f) <= 0) {
            bmiLabel = "Very Overweight";
        } else if (Float.compare(bmi, 35f) > 0  &&  Float.compare(bmi, 40f) <= 0) {
            bmiLabel = "Obese";
        } else {
            bmiLabel = "Fat fuck";
        }

        bmiLabel = bmi + "\n\n" + bmiLabel;
        answer.setText(bmiLabel);
       /* if (bmi<=16){
            bmiLabel="Too fucking skinny";
        }*/

       /* if (Float.compare(bmi,15f)<=0){
            bmiLabel="Too fucking skinny";
        } else if (Float.compare(bmi,15f)>0 &&Float.compare(bmi,16f)<=0) {
            bmiLabel="Very Skinny";
        } else if (Float.compare(bmi,15f)>0 &&Float.compare(bmi,16f)<=0) {
            bmiLabel="Very Skinny";

    }*/
}
}