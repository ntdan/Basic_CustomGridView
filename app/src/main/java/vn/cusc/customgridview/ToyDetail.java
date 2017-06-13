package vn.cusc.customgridview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ToyDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toy_detail);

        // nhan gia tri duoc chuyen toi
        Intent intent = getIntent();
        // trich lay ten va hinh
        String ten = intent.getStringExtra("ten");
        int hinh = intent.getIntExtra("hinh", 0);

        ImageView img = (ImageView) findViewById(R.id.imgDetail);
        img.setImageResource(hinh);

        TextView tvTen = (TextView) findViewById(R.id.tvTen);
        tvTen.setText(ten);
    }
}
