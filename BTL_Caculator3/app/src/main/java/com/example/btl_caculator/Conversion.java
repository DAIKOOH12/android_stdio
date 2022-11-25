package com.example.btl_caculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.btl_caculator.databinding.ActivityConversionBinding;
import com.google.android.material.tabs.TabLayout;

public class Conversion extends AppCompatActivity implements View.OnClickListener {
    ActivityConversionBinding binding;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConversionBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setOnClick();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void setOnClick(){
        binding.btnCMToM.setOnClickListener(this);
        binding.btnMToKM.setOnClickListener(this);
        binding.btnKGToTa.setOnClickListener(this);
        binding.btnKGToTan.setOnClickListener(this);
        binding.btnSecToMi.setOnClickListener(this);
        binding.btnMiToHo.setOnClickListener(this);
        binding.btnSecToHo.setOnClickListener(this);
        binding.btnHoToDay.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCMToM:{
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                CmToM cmToM=new CmToM();
                fragmentTransaction.add(R.id.resultFragment,cmToM);
                fragmentTransaction.commit();
                break;
            }
            case R.id.btnMToKM:{
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                MToKM mToKM=new MToKM();
                fragmentTransaction.add(R.id.resultFragment,mToKM);
                fragmentTransaction.commit();
                break;
            }
            case R.id.btnKGToTa:{
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                KgToTa kgToTa=new KgToTa();
                fragmentTransaction.add(R.id.resultFragment,kgToTa);
                fragmentTransaction.commit();
                break;
            }
            case R.id.btnKGToTan:{
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                KgToTan kgToTan=new KgToTan();
                fragmentTransaction.add(R.id.resultFragment,kgToTan);
                fragmentTransaction.commit();
                break;
            }
            case R.id.btnSecToMi:{
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                SecToMinute secToMinute=new SecToMinute();
                fragmentTransaction.add(R.id.resultFragment,secToMinute);
                fragmentTransaction.commit();
                break;
            }
            case R.id.btnMiToHo:{
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                MinuteToHour minuteToHour=new MinuteToHour();
                fragmentTransaction.add(R.id.resultFragment,minuteToHour);
                fragmentTransaction.commit();
                break;
            }
            case R.id.btnSecToHo:{
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                SecToHour secToHour=new SecToHour();
                fragmentTransaction.add(R.id.resultFragment,secToHour);
                fragmentTransaction.commit();
                break;
            }
            case R.id.btnHoToDay:{
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                HourToDay hourToDay=new HourToDay();
                fragmentTransaction.add(R.id.resultFragment,hourToDay);
                fragmentTransaction.commit();
                break;
            }
        }
    }
}