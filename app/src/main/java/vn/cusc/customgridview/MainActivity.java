package vn.cusc.customgridview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
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

        // dang ky su dung su kien long click  tren lstview de mo popup menu
        registerForContextMenu(grd);
    }

    private void taoDanhSach() {
        toys = new ArrayList<>();
        toys.add(new Toy("Toy 1", R.drawable.toy1));
        toys.add(new Toy("Toy 2", R.drawable.toy2));
        toys.add(new Toy("Toy 3", R.drawable.toy3));
        toys.add(new Toy("Toy 4", R.drawable.toy4));
        toys.add(new Toy("Toy 5", R.drawable.toy5));
    }

    // gan trinh don chinh cho ung dung
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    // don nhan su kien nguoi dung chon chuc nang tren trinh don
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mnThoat) {
            finish();
        }
        return true;
    }

    // gan trinh don ngu canh cho ung dung
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.popup_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    // don nhan su kien nguoi dung chon chuc nang tren trinh don
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.mnXoa) {
            // doc thong tin ve popup menu
            AdapterView.AdapterContextMenuInfo adp1 = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            // lay view da kich hoat popup menu
            View view = adp1.targetView;
            TextView tvPosition = (TextView) view.findViewById(R.id.tvPosition);
            // tim va xoa sv dc chon khoi danh sach
            toys.remove(Integer.parseInt(tvPosition.getText().toString()));
            // cap nhat lai grid view
            adp.notifyDataSetChanged();
        }

        if (item.getItemId() == R.id.mnXem) {
            // doc thong tin ve popup menu
            AdapterView.AdapterContextMenuInfo adp1 = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            // lay view da kich hoat popup menu
            View view = adp1.targetView;
            TextView tvPosition = (TextView) view.findViewById(R.id.tvPosition);

            Intent intent = new Intent(MainActivity.this, ToyDetail.class);
            intent.putExtra("ten", toys.get(Integer.parseInt(tvPosition.getText().toString())).getTen());
            intent.putExtra("hinh", toys.get(Integer.parseInt(tvPosition.getText().toString())).getHinh());

            // goi  mo chuc nang xem chi tiet
            startActivity(intent);
        }

        return true;
    }
}
