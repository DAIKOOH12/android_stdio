package com.example.btl_caculator;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.os.IResultReceiver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomApter extends ArrayAdapter<History> {
    private HistoryInterface context;
    private int resource;
    private ArrayList<History> alHistory;

    //Khoi tao CustomAdapter
    public CustomApter(@NonNull HistoryInterface context, int resource, @NonNull ArrayList<History> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.alHistory=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = new ViewHolder();
        if(convertView==null){

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_history,null);

            //convertView = LayoutInflater.from(context).inflate(R.layout.item_history,parent,false);
            viewHolder=new ViewHolder();

            viewHolder.tvCal=convertView.findViewById(R.id.tvCal);
            viewHolder.tvTotal=convertView.findViewById(R.id.tvTotal);
            viewHolder.btnXoaMot = convertView.findViewById(R.id.btnXoaMot);

            convertView.setTag(viewHolder);
        }
        else {
            viewHolder= (ViewHolder) convertView.getTag();
        }

        History history=alHistory.get(position);
        viewHolder.tvCal.setText(history.getCal());
        viewHolder.tvTotal.setText(history.getTotal()+"");

        viewHolder.btnXoaMot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.DialogXoaMot(history.getCal(),history.getTotal(),history.getPosition());

            }
        });

        return convertView;
    }


    public class ViewHolder{
        private TextView tvCal;
        private TextView tvTotal;
        private ImageView btnXoaMot;
    }
}
