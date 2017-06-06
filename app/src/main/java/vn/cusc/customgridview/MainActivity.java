package vn.cusc.customgridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Toy> toys;
    GridView grd;
    ToyAdapter adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grd = (GridView) findViewById(R.id.gridView);
        taoDanhSach();
        adp = new ToyAdapter(toys, MainActivity.this);
        grd.setAdapter(adp);
        Toast.makeText(MainActivity.this, "onCreate", Toast.LENGTH_SHORT).show();
    }

    private void taoDanhSach() {
        toys = new ArrayList<>();
        toys.add(new Toy("Toy 1", R.drawable.toy1));
        toys.add(new Toy("Toy 2", R.drawable.toy2));
        toys.add(new Toy("Toy 3", R.drawable.toy3));
        toys.add(new Toy("Toy 4", R.drawable.toy4));
        toys.add(new Toy("Toy 5", R.drawable.toy5));
    }
}
