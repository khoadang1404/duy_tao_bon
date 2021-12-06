package com.example.bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1,btn2,btn3,btn4;
    TextView text;
    EditText edit1,edit2;
    DecimalFormat formatter = new DecimalFormat("#0.00");// format kiểu double
    String strso1;
    String strso2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = (EditText) findViewById(R.id.edit1_sothu1);
        edit2 = (EditText) findViewById(R.id.edit2_sothu2);
        text = (TextView) findViewById(R.id.text_viewketqua);
        btn1 = (Button) findViewById(R.id.btn1_tong);
        btn2 = (Button) findViewById(R.id.btn2_hieu);
        btn3 = (Button) findViewById(R.id.btn3_tich);
        btn4 = (Button) findViewById(R.id.btn4_thuong);

        btn1.setOnClickListener(this);//bắt sự kiện cho nhiều button
        btn2.setOnClickListener(this);//bắt sự kiện cho nhiều button
        btn3.setOnClickListener(this);//bắt sự kiện cho nhiều button
        btn4.setOnClickListener(this);//bắt sự kiện cho nhiều button
    }

    //tạo hàm tính toán các phép tính
    public void tinhtoan(int pt)
    {
        double kq = 0;
        //lấy số từ edit1 và edit 2
        strso1 = edit1.getText().toString();
        strso2 = edit2.getText().toString();
        //int a = Integer.parseInt(strso1);
        float a = Float.parseFloat(strso1);
        //int b = Integer.parseInt(strso2);
        float b = Float.parseFloat(strso2);
        //THcong:1,THtru:2,THnhan:3,THchia:4
        switch (pt) {
            case  1:
                kq = (double) a + b;
                break;
            case  2:
                kq = (double) a - b;
                break;
            case  3:
                kq = (double) a * b;
                break;
            case  4:
                kq =  (a*1.0) / b;
                break;
        }
        text.setText(text.getText() + formatter.format(kq));// xuất kết quả ra text view
    }

    // Bắt sự kiện cho các button
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn1_tong){
            text.setText("Tổng 2 số là : ");
            tinhtoan(1);
        }
        if(view.getId() == R.id.btn2_hieu){
            text.setText("Hiệu 2 số là : ");
            tinhtoan(2);
        }
        if(view.getId() == R.id.btn3_tich){
            text.setText("Tích 2 số là : ");
            tinhtoan(3);
        }
        if(view.getId() == R.id.btn4_thuong){
            text.setText("Thương 2 số là : ");
            tinhtoan(4);
        }
    }
}