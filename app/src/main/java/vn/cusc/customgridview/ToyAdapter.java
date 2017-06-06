package vn.cusc.customgridview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ntdan on 6/6/2017.
 */
public class ToyAdapter extends BaseAdapter{
    ArrayList<Toy> toys;
    Context context;

    public ToyAdapter(ArrayList<Toy> toys, Context context) {
        this.toys = toys;
        this.context = context;
    }

    @Override
    public int getCount() {
        return toys.size();
    }

    @Override
    public Object getItem(int position) {
        return toys.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        Cell cell;

        if(convertView == null)
        {
            cell = new Cell();

            convertView = ((Activity)context).getLayoutInflater().inflate(R.layout.toy_cell, parent, false);
            cell.hinh = (ImageView) convertView.findViewById(R.id.imageView);
            cell.ten = (TextView)convertView.findViewById(R.id.textView);

            convertView.setTag(cell);
        }else
        {
            cell = (Cell)convertView.getTag();
        }

        cell.ten.setText(toys.get(position).getTen());
        cell.hinh.setImageResource(toys.get(position).getHinh());

        cell.hinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Ban da chon: " + toys.get(position).getTen(), Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    class Cell{
        ImageView hinh;
        TextView ten;
    }
}
