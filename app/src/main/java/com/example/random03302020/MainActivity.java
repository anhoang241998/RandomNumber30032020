package com.example.random03302020;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    EditText mEditTextMin, mEditTextMax;
    Button mRandomButton, mAddButton, mResetButton;
    TextView mResultTextView;
    String mProcess = "";
    String mMinInputValue;
    String mMaxInputValue;
    int mMinValue;
    int mMaxValue;
    Random mRandomValue;
    ArrayList<Integer> rangeValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mEditTextMin = findViewById(R.id.editTextMin);
        mEditTextMax = findViewById(R.id.editTextMax);
        mRandomButton = findViewById(R.id.btn_random);
        mResultTextView = findViewById(R.id.textViewResult);
        mAddButton = findViewById(R.id.btn_add);
        mResetButton = findViewById(R.id.btn_reset);

        rangeValue = new ArrayList<>();

        if (rangeValue.size() == 0) {
            mRandomButton.setEnabled(false);
            mResetButton.setEnabled(false);
        }


        mAddButton.setOnClickListener(new View.OnClickListener() {
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
                }

                for (int i = mMinValue; i <= mMaxValue; i++) {
                    rangeValue.add(i);
                }

                if (rangeValue.size() > 0) {
                    mAddButton.setEnabled(false);
                    mResetButton.setEnabled(true);
                    mRandomButton.setEnabled(true);
                    mEditTextMin.setEnabled(false);
                    mEditTextMax.setEnabled(false);
                }
            }
        });

        mRandomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // hàm random
                mRandomValue = new Random();
//                int resultValue = randomValue.nextInt(mMaxValue - mMinValue + 1) + mMinValue;
//                mProcess = mResultTextView.getText().toString();
//                mProcess = mProcess + resultValue + (" - ");
//                mResultTextView.setText(mProcess);
                if (rangeValue.size() > 0) {

                    int index = mRandomValue.nextInt(rangeValue.size());
                    int showValue = rangeValue.get(index);
                    if (rangeValue.size() == 1) {
                        mProcess = mProcess + showValue;
                    } else {
                        mProcess = mProcess + showValue + " - ";
                    }
                    mResultTextView.setText(mProcess);
                    rangeValue.remove(index);

                } else {
                    Toast.makeText(MainActivity.this, "Game Over", Toast.LENGTH_SHORT).show();
                }


            }
        });

        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rangeValue.clear();
                mEditTextMax.setText("");
                mEditTextMin.setText("");
                mResultTextView.setText("");
                mAddButton.setEnabled(true);
                mResetButton.setEnabled(false);
                mRandomButton.setEnabled(false);
                mEditTextMin.setEnabled(true);
                mEditTextMax.setEnabled(true);
            }
        });
    }

}
