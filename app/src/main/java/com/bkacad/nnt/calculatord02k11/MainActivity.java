package com.bkacad.nnt.calculatord02k11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnCong, btnTru, btnNhan, btnChia;
    private TextView tvResult;
    private EditText edtA, edtB;

    private void initUI(){
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        tvResult = findViewById(R.id.tvResult);
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
    }
    private void btnClick(){
        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        btnClick();
    }

    @Override
    public void onClick(View v) {
        // Lấy dữ liệu
        String strA = edtA.getText().toString();
        if(strA.isEmpty()){
            edtA.setError("Hãy nhập dữ liệu");
            return;
        }
        String strB = edtB.getText().toString();
        if(strB.isEmpty()){
            edtB.setError("Hãy nhập dữ liệu");
            return;
        }

        // Ép kiểu về số
        double a = 0, b = 0, rs = 0;
        try{
            a = Double.parseDouble(strA);
            b = Double.parseDouble(strB);
        }
        catch (Exception e){
            tvResult.setText("Dữ liệu không hợp lệ");
            return;
        }

        switch (v.getId()){
            case R.id.btnCong:
                rs = Calculator.tong(a, b);
                break;
            case R.id.btnTru:
                rs = Calculator.hieu(a, b);
                break;
            case R.id.btnNhan:
                rs = Calculator.tich(a, b);
                break;
            case R.id.btnChia:
                try {
                    rs = Calculator.thuong(a, b);
                } catch (Exception e) {
                    tvResult.setText(e.getMessage());
                    return;
                }
                break;
        }
        tvResult.setText(String.valueOf(rs));
    }
}