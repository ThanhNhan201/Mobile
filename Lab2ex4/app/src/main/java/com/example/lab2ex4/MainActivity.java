package com.example.lab2ex4;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText editTextUsername;
    EditText editTextSalary;
    Button buttonCalculate;
    ScrollView scrollViewResult;

    List<salary> salaryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.text_username);
        editTextSalary = findViewById(R.id.text_salary);
        buttonCalculate = findViewById(R.id.button_calculate);
        scrollViewResult = findViewById(R.id.scrollview_result);
        salaryList = new ArrayList<>();

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                int salary = Integer.parseInt(editTextSalary.getText().toString());

                salary salary_p = new salary(username, salary);
                salary_p.calculateSalary();
                salaryList.add(salary_p);
                showResult();
            }
        });
    }
    private void showResult() {
        LinearLayout linearLayoutResult = findViewById(R.id.linearlayout_result);
        linearLayoutResult.removeAllViews();

        for (salary salary_p : salaryList) {
            TextView textView = new TextView(this);
            DecimalFormat decimalFormat = new DecimalFormat("#");
            String netSalaryStr = decimalFormat.format(salary_p.getNetSalary());
            textView.setText(salary_p.getUsername() + "- Net salary: " + netSalaryStr);
            linearLayoutResult.addView(textView);
        }
    }
}