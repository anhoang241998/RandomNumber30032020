package com.example.random03302020;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    LinearLayout mLinearLayout;
    EditText mEditTextMin, mEditTextMax;
    Button mRandomButton;
    TextView mResultTextView;
    String mMinInputValue;
    String mMaxInputValue;
    int mMinValue;
    int mMaxValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLinearLayout = findViewById(R.id.linearLayout);
        mEditTextMin =  findViewById(R.id.editTextMin);
        mEditTextMax =  findViewById(R.id.editTextMax);
        mRandomButton =  findViewById(R.id.btn_random);
        mResultTextView = findViewById(R.id.textViewResult);

        mRandomButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                mMinInputValue = mEditTextMin.getText().toString();
                mMaxInputValue = mEditTextMax.getText().toString();
                if ((mMinInputValue.isEmpty()) || (mMaxInputValue.isEmpty())) {
                    Toast.makeText(MainActivity.this, "Bạn chưa nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                mMinValue = Integer.parseInt(mMinInputValue);
                mMaxValue = Integer.parseInt(mMaxInputValue);
                if (mMinValue >= mMaxValue) {
                    mMaxValue = mMinValue + 1;
                    mEditTextMax.setText(mMaxValue + "");
                    // hàm random
                }
                Random randomValue = new Random();
                int resultValue = randomValue.nextInt(mMaxValue - mMinValue + 1) + mMinValue;
                mResultTextView.setText(resultValue + " - ");
            }
        });
    }

}
