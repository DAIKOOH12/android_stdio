package com.example.btl_caculator;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.DecimalFormat;

public class MToKM extends Fragment {
    private EditText editText;
    private TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.m_to_km,container,false);
        editText=(EditText) view.findViewById(R.id.etCount);
        textView=view.findViewById(R.id.tvResult);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String result=editText.getText().toString();
                Double a=Double.parseDouble(result);
                a/=100;
                textView.setText(new DecimalFormat("##.##").format(a)+" km");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return view;
    }
}

