package com.example.random03302020;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    EditText mEditTextMin, mEditTextMax;
    Button mRandomButton;
    TextView mResultTextView;
    String mProcess;
    long mButtonClickCount;
    String mMinInputValue;
    String mMaxInputValue;
    int mMinValue;
    int mMaxValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mEditTextMin =  findViewById(R.id.editTextMin);
        mEditTextMax =  findViewById(R.id.editTextMax);
        mRandomButton =  findViewById(R.id.btn_random);
        mResultTextView = findViewById(R.id.textViewResult);

        mRandomButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                mButtonClickCount++;
                mMinInputValue = mEditTextMin.getText().toString();
                mMaxInputValue = mEditTextMax.getText().toString();
                if ((mMinInputValue.isEmpty()) || (mMaxInputValue.isEmpty())) {
                    Toast.makeText(MainActivity.this, "Bạn chưa nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                mMinValue = Integer.parseInt(mMinInputValue);
                mMaxValue = Integer.parseInt(mMaxInputValue);

                if(mButtonClickCount > (mMaxValue - mMinValue + 1)){
                    Toast.makeText(MainActivity.this, "Bạn đã nhấn đủ số lần", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (mMinValue >= mMaxValue) {
                    mMaxValue = mMinValue + 1;
                    mEditTextMax.setText(mMaxValue + "");
                    // hàm random
                }
                Random randomValue = new Random();
                int resultValue = randomValue.nextInt(mMaxValue - mMinValue + 1) + mMinValue;
                mProcess = mResultTextView.getText().toString();
                mProcess = mProcess + resultValue + (" - ");
                mResultTextView.setText(mProcess);




            }
        });
    }

}
