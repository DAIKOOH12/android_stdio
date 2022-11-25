package com.example.btl_caculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.btl_caculator.database.CalculationHistory;

import java.util.ArrayList;
import java.util.List;


public class HistoryInterface extends AppCompatActivity {
    private ListView lstView;
    private CalculationHistory calculationHistory=new CalculationHistory(this);
    private CustomApter customApter;
    private ArrayList<History> a=new ArrayList<History>();
    private Button btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_history_interface);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        a=calculationHistory.getHistory(a);

        lstView=findViewById(R.id.lvHistory);
        btnClear=findViewById(R.id.btnClearHistory);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearHistory();
                finish();
                //getData();
                startActivity(getIntent());
            }
        });

        setAdapter();
    }
    private void clearHistory(){
        calculationHistory.deleteHistory();
    }
    private void setAdapter(){
        if(customApter==null){
            customApter=new CustomApter(this,R.layout.item_history,a);
            lstView.setAdapter(customApter);
        }else{
            customApter.notifyDataSetChanged();
            lstView.setSelection(lstView.getCount()-1);
        }
    }

    private void getData(){
        Cursor data = calculationHistory.GetData("SELECT * FROM cal_history");
        a.clear();
        data.moveToFirst();
        while(data.isAfterLast() == false) {
            History history=new History();
            history.setPosition(data.getInt(0));
            history.setCal(data.getString(1));
            history.setTotal(data.getFloat(2));
            a.add(history);
            data.moveToNext();
        }
        customApter.notifyDataSetChanged();
    }

    public void DialogXoaMot(String cal, float total, int id) {
        AlertDialog.Builder aBuilder = new AlertDialog.Builder(HistoryInterface.this);
        aBuilder.setTitle("Warning!");
        aBuilder.setMessage("Bạn có chắc muốn xóa?");
        aBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                calculationHistory.Xoa(cal,total,id);
                Toast.makeText(HistoryInterface.this, "Đã xóa", Toast.LENGTH_SHORT).show();
                //calculationHistory.getHistory(a);
                //setAdapter();
                //startActivity(getIntent());
                getData();
            }
        });
        aBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        aBuilder.create().show();
    }

}