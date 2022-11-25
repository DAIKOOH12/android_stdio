package com.example.btl_caculator;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.btl_caculator.database.CalculationHistory;
import com.example.btl_caculator.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ActivityMainBinding binding;
    private double total = 0;
    private String result = "";
    private String result2 = "";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        setClickForButton();
    }

    public void setClickForButton() {
        binding.btnConversion.setOnClickListener(this);
        binding.btnSquare.setOnClickListener(this);
        binding.btnAC.setOnClickListener(this);
        binding.btnOption.setOnClickListener(this);
        binding.btnNumber7.setOnClickListener(this);
        binding.btnNumber8.setOnClickListener(this);
        binding.btnNumber9.setOnClickListener(this);
        binding.btnAC.setOnClickListener(this);
        binding.btnC.setOnClickListener(this);
        binding.btnNumber4.setOnClickListener(this);
        binding.btnNumber5.setOnClickListener(this);
        binding.btnNumber6.setOnClickListener(this);
        binding.btnPlus.setOnClickListener(this);
        binding.btnMinus.setOnClickListener(this);
        binding.btnNumber1.setOnClickListener(this);
        binding.btnNumber2.setOnClickListener(this);
        binding.btnNumber3.setOnClickListener(this);
        binding.btnMultipy.setOnClickListener(this);
        binding.btnDivide.setOnClickListener(this);
        binding.btnNumber0.setOnClickListener(this);
        binding.btnResult.setOnClickListener(this);
        binding.btnConversion.setOnClickListener(this);
        binding.btnSin.setOnClickListener(this);
        binding.btnCos.setOnClickListener(this);
        binding.btnLog.setOnClickListener(this);
        binding.btnMod.setOnClickListener(this);
        binding.btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HistoryInterface.class);
                startActivity(intent);
            }
        });
        binding.btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickQuit();
            }
        });
    }

    public void onClickQuit() {
        AlertDialog.Builder aBuilder = new AlertDialog.Builder(MainActivity.this);
        aBuilder.setTitle("Warning!");
        aBuilder.setMessage("Bạn có chắc muốn thoát?");
        aBuilder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnConversion: {
                Intent intent = new Intent(MainActivity.this, Conversion.class);
                startActivity(intent);
                break;
            }
            case R.id.btnNumber1: {
                String etResult = binding.etResult.getText().toString();
                if (!TextUtils.isEmpty(etResult) && result == "") {
                    binding.etResult.setTextSize(20.0f);
                    binding.etResult.setText("");
                }
                if (result.contains("+")) {
                    result += binding.btnNumber1.getText().toString();
                    binding.etCaculation1.append("1");
                    if (result2 != "") {
                        if (result.contains("+")) {
                            String split = result.replace("+", " ");
                            String[] a = split.split(" ");
                            double sum = Double.parseDouble(a[0]) + Double.parseDouble(a[1]);
                            total = sum;
                        }
                    } else {
                        result2 += binding.btnNumber1.getText().toString();
                        total += Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("-")) {
                    result += binding.btnNumber1.getText().toString();
                    binding.etCaculation1.append("1");
                    if (result2 != "") {
                        if (result.contains("-")) {
                            String split = result.replace("-", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) - Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber1.getText().toString();
                        total -= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("x")) {
                    result += binding.btnNumber1.getText().toString();
                    binding.etCaculation1.append("1");
                    if (result2 != "") {
                        if (result.contains("x")) {
                            String split = result.replace("x", " ");
                            String[] a = split.split(" ");
                            double mult = Double.parseDouble(a[0]) * Double.parseDouble(a[1]);
                            total = mult;
                        }
                    } else {
                        result2 += binding.btnNumber1.getText().toString();
                        total *= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains(":")) {
                    result += binding.btnNumber1.getText().toString();
                    binding.etCaculation1.append("1");
                    if (result2 != "") {
                        if (result.contains(":")) {
                            String split = result.replace(":", " ");
                            String[] a = split.split(" ");
                            double mult = Double.parseDouble(a[0]) / Double.parseDouble(a[1]);
                            total = mult;

                        }
                    } else {
                        result2 += binding.btnNumber1.getText().toString();
                        total /= Double.parseDouble(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("%")) {
                    result += binding.btnNumber1.getText().toString();
                    binding.etCaculation1.append("1");
                    if (result2 != "") {
                        if (result.contains("%")) {
                            String split = result.replace("%", " ");
                            String[] a = split.split(" ");
                            double mult = Double.parseDouble(a[0]) % Double.parseDouble(a[1]);
                            total = mult;
                        }
                    } else {
                        result2 += binding.btnNumber1.getText().toString();
                        total %= Double.parseDouble(result2);
                    }
                    binding.etResult.setText(total + "");
                } else {
                    binding.etCaculation1.append("1");
                    result += binding.btnNumber1.getText().toString();
                    binding.etResult.append("1");
                }
                break;
            }
            case R.id.btnNumber2: {
                String etResult = binding.etResult.getText().toString();
                if (!TextUtils.isEmpty(etResult) && result == "") {
                    binding.etResult.setTextSize(20.0f);
                    binding.etResult.setText("");
                }
                if (result.contains("+")) {
                    result += binding.btnNumber2.getText().toString();
                    binding.etCaculation1.append("2");
                    if (result2 != "") {
                        if (result.contains("+")) {
                            String split = result.replace("+", " ");
                            String[] a = split.split(" ");
                            double sum = Double.parseDouble(a[0]) + Double.parseDouble(a[1]);
                            total = sum;
                        }
                    } else {
                        result2 += binding.btnNumber2.getText().toString();
                        total += Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("-")) {
                    result += binding.btnNumber2.getText().toString();
                    binding.etCaculation1.append("2");
                    if (result2 != "") {
                        if (result.contains("-")) {
                            String split = result.replace("-", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) - Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber2.getText().toString();
                        total -= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("x")) {
                    result += binding.btnNumber2.getText().toString();
                    binding.etCaculation1.append("2");
                    if (result2 != "") {
                        if (result.contains("x")) {
                            String split = result.replace("x", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) * Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber2.getText().toString();
                        total *= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains(":")) {
                    result += binding.btnNumber2.getText().toString();
                    binding.etCaculation1.append("2");
                    if (result2 != "") {
                        if (result.contains(":")) {
                            String split = result.replace(":", " ");
                            String[] a = split.split(" ");
                            double mult = Double.parseDouble(a[0]) / Double.parseDouble(a[1]);
                            total = mult;
                        }
                    } else {
                        result2 += binding.btnNumber2.getText().toString();
                        total /= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("%")) {
                    result += binding.btnNumber2.getText().toString();
                    binding.etCaculation1.append("2");
                    if (result2 != "") {
                        if (result.contains("%")) {
                            String split = result.replace("%", " ");
                            String[] a = split.split(" ");
                            double mult = Double.parseDouble(a[0]) % Double.parseDouble(a[1]);
                            total = mult;
                        }
                    } else {
                        result2 += binding.btnNumber2.getText().toString();
                        total %= Double.parseDouble(result2);
                    }
                    binding.etResult.setText(total + "");
                } else {
                    binding.etCaculation1.append("2");
                    result += binding.btnNumber2.getText().toString();
                    binding.etResult.append("2");
                }
                break;
            }
            case R.id.btnNumber3: {
                String etResult = binding.etResult.getText().toString();
                if (!TextUtils.isEmpty(etResult) && result == "") {
                    binding.etResult.setTextSize(20.0f);
                    binding.etResult.setText("");
                }
                if (result.contains("+")) {
                    result += binding.btnNumber3.getText().toString();
                    binding.etCaculation1.append("3");
                    if (result2 != "") {
                        if (result.contains("+")) {
                            String split = result.replace("+", " ");
                            String[] a = split.split(" ");
                            double sum = Double.parseDouble(a[0]) + Double.parseDouble(a[1]);
                            total = sum;
                        }
                    } else {
                        result2 += binding.btnNumber3.getText().toString();
                        total += Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("-")) {
                    result += binding.btnNumber3.getText().toString();
                    binding.etCaculation1.append("3");
                    if (result2 != "") {
                        if (result.contains("-")) {
                            String split = result.replace("-", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) - Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber3.getText().toString();
                        total -= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("x")) {
                    result += binding.btnNumber3.getText().toString();
                    binding.etCaculation1.append("3");
                    if (result2 != "") {
                        if (result.contains("x")) {
                            String split = result.replace("x", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) * Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber3.getText().toString();
                        total *= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains(":")) {
                    result += binding.btnNumber3.getText().toString();
                    binding.etCaculation1.append("3");
                    if (result2 != "") {
                        if (result.contains(":")) {
                            String split = result.replace(":", " ");
                            String[] a = split.split(" ");
                            double mult = Double.parseDouble(a[0]) / Double.parseDouble(a[1]);
                            total = mult;
                        }
                    } else {
                        result2 += binding.btnNumber3.getText().toString();
                        total /= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("%")) {
                    result += binding.btnNumber3.getText().toString();
                    binding.etCaculation1.append("3");
                    if (result2 != "") {
                        if (result.contains("%")) {
                            String split = result.replace("%", " ");
                            String[] a = split.split(" ");
                            double mult = Double.parseDouble(a[0]) % Double.parseDouble(a[1]);
                            total = mult;
                        }
                    } else {
                        result2 += binding.btnNumber3.getText().toString();
                        total %= Double.parseDouble(result2);
                    }
                    binding.etResult.setText(total + "");
                } else {
                    binding.etCaculation1.append("3");
                    result += binding.btnNumber3.getText().toString();
                    binding.etResult.append("3");
                }
                break;
            }
            case R.id.btnNumber4: {
                String etResult = binding.etResult.getText().toString();
                if (!TextUtils.isEmpty(etResult) && result == "") {
                    binding.etResult.setTextSize(20.0f);
                    binding.etResult.setText("");
                }
                if (result.contains("+")) {
                    result += binding.btnNumber4.getText().toString();
                    binding.etCaculation1.append("4");
                    if (result2 != "") {
                        if (result.contains("+")) {
                            String split = result.replace("+", " ");
                            String[] a = split.split(" ");
                            double sum = Double.parseDouble(a[0]) + Double.parseDouble(a[1]);
                            total = sum;
                        }
                    } else {
                        result2 += binding.btnNumber4.getText().toString();
                        total += Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("-")) {
                    result += binding.btnNumber4.getText().toString();
                    binding.etCaculation1.append("4");
                    if (result2 != "") {
                        if (result.contains("-")) {
                            String split = result.replace("-", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) - Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber4.getText().toString();
                        total -= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("x")) {
                    result += binding.btnNumber4.getText().toString();
                    binding.etCaculation1.append("4");
                    if (result2 != "") {
                        if (result.contains(":")) {
                            String split = result.replace("x", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) * Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber4.getText().toString();
                        total *= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains(":")) {
                    result += binding.btnNumber4.getText().toString();
                    binding.etCaculation1.append("4");
                    if (result2 != "") {
                        if (result.contains(":")) {
                            String split = result.replace(":", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) / Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber4.getText().toString();
                        total /= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("%")) {
                    result += binding.btnNumber4.getText().toString();
                    binding.etCaculation1.append("4");
                    if (result2 != "") {
                        if (result.contains("%")) {
                            String split = result.replace("%", " ");
                            String[] a = split.split(" ");
                            double mult = Double.parseDouble(a[0]) % Double.parseDouble(a[1]);
                            total = mult;
                        }
                    } else {
                        result2 += binding.btnNumber4.getText().toString();
                        total %= Double.parseDouble(result2);
                    }
                    binding.etResult.setText(total + "");
                } else {
                    binding.etCaculation1.append("4");
                    result += binding.btnNumber4.getText().toString();
                    binding.etResult.append("4");
                }
                break;
            }
            case R.id.btnNumber5: {
                String etResult = binding.etResult.getText().toString();
                if (!TextUtils.isEmpty(etResult) && result == "") {
                    binding.etResult.setTextSize(20.0f);
                    binding.etResult.setText("");
                }
                if (result.contains("+")) {
                    result += binding.btnNumber5.getText().toString();
                    binding.etCaculation1.append("5");
                    if (result2 != "") {
                        if (result.contains("+")) {
                            String split = result.replace("+", " ");
                            String[] a = split.split(" ");
                            double sum = Double.parseDouble(a[0]) + Double.parseDouble(a[1]);
                            total = sum;
                        }
                    } else {
                        result2 += binding.btnNumber5.getText().toString();
                        total += Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("-")) {
                    result += binding.btnNumber5.getText().toString();
                    binding.etCaculation1.append("5");
                    if (result2 != "") {
                        if (result.contains("-")) {
                            String split = result.replace("-", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) - Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber5.getText().toString();
                        total -= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("x")) {
                    result += binding.btnNumber5.getText().toString();
                    binding.etCaculation1.append("5");
                    if (result2 != "") {
                        if (result.contains("x")) {
                            String split = result.replace("x", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) * Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber5.getText().toString();
                        total *= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains(":")) {
                    result += binding.btnNumber5.getText().toString();
                    binding.etCaculation1.append("5");
                    if (result2 != "") {
                        if (result.contains(":")) {
                            String split = result.replace(":", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) / Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber5.getText().toString();
                        total /= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("%")) {
                    result += binding.btnNumber5.getText().toString();
                    binding.etCaculation1.append("5");
                    if (result2 != "") {
                        if (result.contains("%")) {
                            String split = result.replace("%", " ");
                            String[] a = split.split(" ");
                            double mult = Double.parseDouble(a[0]) % Double.parseDouble(a[1]);
                            total = mult;
                        }
                    } else {
                        result2 += binding.btnNumber5.getText().toString();
                        total %= Double.parseDouble(result2);
                    }
                    binding.etResult.setText(total + "");
                } else {
                    binding.etCaculation1.append("5");
                    result += binding.btnNumber5.getText().toString();
                    binding.etResult.append("5");
                }
                break;
            }
            case R.id.btnNumber6: {
                String etResult = binding.etResult.getText().toString();
                if (!TextUtils.isEmpty(etResult) && result == "") {
                    binding.etResult.setTextSize(20.0f);
                    binding.etResult.setText("");
                }
                if (result.contains("+")) {
                    result += binding.btnNumber6.getText().toString();
                    binding.etCaculation1.append("6");
                    if (result2 != "") {
                        if (result.contains("+")) {
                            String split = result.replace("+", " ");
                            String[] a = split.split(" ");
                            double sum = Double.parseDouble(a[0]) + Double.parseDouble(a[1]);
                            total = sum;
                        }
                    } else {
                        result2 += binding.btnNumber6.getText().toString();
                        total += Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("-")) {
                    result += binding.btnNumber6.getText().toString();
                    binding.etCaculation1.append("6");
                    if (result2 != "") {
                        if (result.contains("-")) {
                            String split = result.replace("-", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) - Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber6.getText().toString();
                        total -= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("x")) {
                    result += binding.btnNumber6.getText().toString();
                    binding.etCaculation1.append("6");
                    if (result2 != "") {
                        if (result.contains("x")) {
                            String split = result.replace("x", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) * Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber6.getText().toString();
                        total *= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains(":")) {
                    result += binding.btnNumber6.getText().toString();
                    binding.etCaculation1.append("6");
                    if (result2 != "") {
                        if (result.contains(":")) {
                            String split = result.replace(":", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) / Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber6.getText().toString();
                        total /= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("%")) {
                    result += binding.btnNumber6.getText().toString();
                    binding.etCaculation1.append("6");
                    if (result2 != "") {
                        if (result.contains("%")) {
                            String split = result.replace("%", " ");
                            String[] a = split.split(" ");
                            double mult = Double.parseDouble(a[0]) % Double.parseDouble(a[1]);
                            total = mult;
                        }
                    } else {
                        result2 += binding.btnNumber6.getText().toString();
                        total %= Double.parseDouble(result2);
                    }
                    binding.etResult.setText(total + "");
                } else {
                    binding.etCaculation1.append("6");
                    result += binding.btnNumber6.getText().toString();
                    binding.etResult.append("6");
                }
                break;
            }
            case R.id.btnNumber7: {
                String etResult = binding.etResult.getText().toString();
                if (!TextUtils.isEmpty(etResult) && result == "") {
                    binding.etResult.setTextSize(20.0f);
                    binding.etResult.setText("");
                }
                if (result.contains("+")) {
                    result += binding.btnNumber7.getText().toString();
                    binding.etCaculation1.append("7");
                    if (result2 != "") {
                        if (result.contains("+")) {
                            String split = result.replace("+", " ");
                            String[] a = split.split(" ");
                            double sum = Double.parseDouble(a[0]) + Double.parseDouble(a[1]);
                            total = sum;
                        }
                    } else {
                        result2 += binding.btnNumber7.getText().toString();
                        total += Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("-")) {
                    result += binding.btnNumber7.getText().toString();
                    binding.etCaculation1.append("7");
                    if (result2 != "") {
                        if (result.contains("-")) {
                            String split = result.replace("-", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) - Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber7.getText().toString();
                        total -= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("x")) {
                    result += binding.btnNumber7.getText().toString();
                    binding.etCaculation1.append("7");
                    if (result2 != "") {
                        if (result.contains("x")) {
                            String split = result.replace("x", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) * Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber7.getText().toString();
                        total *= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains(":")) {
                    result += binding.btnNumber7.getText().toString();
                    binding.etCaculation1.append("7");
                    if (result2 != "") {
                        if (result.contains(":")) {
                            String split = result.replace(":", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) / Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber7.getText().toString();
                        total /= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("%")) {
                    result += binding.btnNumber7.getText().toString();
                    binding.etCaculation1.append("7");
                    if (result2 != "") {
                        if (result.contains("%")) {
                            String split = result.replace("%", " ");
                            String[] a = split.split(" ");
                            double mult = Double.parseDouble(a[0]) % Double.parseDouble(a[1]);
                            total = mult;
                        }
                    } else {
                        result2 += binding.btnNumber7.getText().toString();
                        total %= Double.parseDouble(result2);
                    }
                    binding.etResult.setText(total + "");
                } else {
                    binding.etCaculation1.append("7");
                    result += binding.btnNumber7.getText().toString();
                    binding.etResult.append("7");
                }
                break;
            }
            case R.id.btnNumber8: {
                String etResult = binding.etResult.getText().toString();
                if (!TextUtils.isEmpty(etResult) && result == "") {
                    binding.etResult.setTextSize(20.0f);
                    binding.etResult.setText("");
                }
                if (result.contains("+")) {
                    result += binding.btnNumber8.getText().toString();
                    binding.etCaculation1.append("8");
                    if (result2 != "") {
                        if (result.contains("+")) {
                            String split = result.replace("+", " ");
                            String[] a = split.split(" ");
                            double sum = Double.parseDouble(a[0]) + Double.parseDouble(a[1]);
                            total = sum;
                        }
                    } else {
                        result2 += binding.btnNumber8.getText().toString();
                        total += Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("-")) {
                    result += binding.btnNumber8.getText().toString();
                    binding.etCaculation1.append("8");
                    if (result2 != "") {
                        if (result.contains("-")) {
                            String split = result.replace("-", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) - Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber8.getText().toString();
                        total -= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("x")) {
                    result += binding.btnNumber8.getText().toString();
                    binding.etCaculation1.append("8");
                    if (result2 != "") {
                        if (result.contains("x")) {
                            String split = result.replace("x", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) * Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber8.getText().toString();
                        total *= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains(":")) {
                    result += binding.btnNumber8.getText().toString();
                    binding.etCaculation1.append("8");
                    if (result2 != "") {
                        if (result.contains(":")) {
                            String split = result.replace(":", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) / Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber8.getText().toString();
                        total /= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("%")) {
                    result += binding.btnNumber8.getText().toString();
                    binding.etCaculation1.append("8");
                    if (result2 != "") {
                        if (result.contains("%")) {
                            String split = result.replace("%", " ");
                            String[] a = split.split(" ");
                            double mult = Double.parseDouble(a[0]) % Double.parseDouble(a[1]);
                            total = mult;
                        }
                    } else {
                        result2 += binding.btnNumber8.getText().toString();
                        total %= Double.parseDouble(result2);
                    }
                    binding.etResult.setText(total + "");
                } else {
                    binding.etCaculation1.append("8");
                    result += binding.btnNumber8.getText().toString();
                    binding.etResult.append("8");
                }
                break;
            }
            case R.id.btnNumber9: {
                String etResult = binding.etResult.getText().toString();
                if (!TextUtils.isEmpty(etResult) && result == "") {
                    binding.etResult.setTextSize(20.0f);
                    binding.etResult.setText("");
                }
                if (result.contains("+")) {
                    result += binding.btnNumber9.getText().toString();
                    binding.etCaculation1.append("9");
                    if (result2 != "") {
                        if (result.contains("+")) {
                            String split = result.replace("+", " ");
                            String[] a = split.split(" ");
                            double sum = Double.parseDouble(a[0]) + Double.parseDouble(a[1]);
                            total = sum;
                        }
                    } else {
                        result2 += binding.btnNumber9.getText().toString();
                        total += Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("-")) {
                    result += binding.btnNumber9.getText().toString();
                    binding.etCaculation1.append("9");
                    if (result2 != "") {
                        if (result.contains("-")) {
                            String split = result.replace("-", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) - Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber9.getText().toString();
                        total -= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("x")) {
                    result += binding.btnNumber9.getText().toString();
                    binding.etCaculation1.append("9");
                    if (result2 != "") {
                        if (result.contains("x")) {
                            String split = result.replace("x", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) * Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber9.getText().toString();
                        total *= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains(":")) {
                    result += binding.btnNumber9.getText().toString();
                    binding.etCaculation1.append("9");
                    if (result2 != "") {
                        if (result.contains(":")) {
                            String split = result.replace(":", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) / Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber9.getText().toString();
                        total /= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("%")) {
                    result += binding.btnNumber9.getText().toString();
                    binding.etCaculation1.append("9");
                    if (result2 != "") {
                        if (result.contains("%")) {
                            String split = result.replace("%", " ");
                            String[] a = split.split(" ");
                            double mult = Double.parseDouble(a[0]) % Double.parseDouble(a[1]);
                            total = mult;
                        }
                    } else {
                        result2 += binding.btnNumber9.getText().toString();
                        total %= Double.parseDouble(result2);
                    }
                    binding.etResult.setText(total + "");
                } else {
                    binding.etCaculation1.append("9");
                    result += binding.btnNumber9.getText().toString();
                    binding.etResult.append("9");
                }
                break;
            }
            case R.id.btnNumber0: {
                String etResult = binding.etResult.getText().toString();
                if (!TextUtils.isEmpty(etResult) && result == "") {
                    binding.etResult.setTextSize(20.0f);
                    binding.etResult.setText("");
                }
                if (result.contains("+")) {
                    result += binding.btnNumber0.getText().toString();
                    binding.etCaculation1.append("0");
                    if (result2 != "") {
                        if (result.contains("+")) {
                            String split = result.replace("+", " ");
                            String[] a = split.split(" ");
                            double sum = Double.parseDouble(a[0]) + Double.parseDouble(a[1]);
                            total = sum;
                        }
                    } else {
                        result2 += binding.btnNumber0.getText().toString();
                        total += Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("-")) {
                    result += binding.btnNumber0.getText().toString();
                    binding.etCaculation1.append("0");
                    if (result2 != "") {
                        if (result.contains("-")) {
                            String split = result.replace("-", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) - Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber0.getText().toString();
                        total -= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("x")) {
                    result += binding.btnNumber0.getText().toString();
                    binding.etCaculation1.append("0");
                    if (result2 != "") {
                        if (result.contains("x")) {
                            String split = result.replace("x", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) * Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber0.getText().toString();
                        total *= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains(":")) {
                    result += binding.btnNumber0.getText().toString();
                    binding.etCaculation1.append("0");
                    if (result2 != "") {
                        if (result.contains(":")) {
                            String split = result.replace(":", " ");
                            String[] a = split.split(" ");
                            double differ = Double.parseDouble(a[0]) / Double.parseDouble(a[1]);
                            total = differ;
                        }
                    } else {
                        result2 += binding.btnNumber0.getText().toString();
                        total /= Integer.parseInt(result2);
                    }
                    binding.etResult.setText(total + "");
                } else if (result.contains("%")) {
                    result += binding.btnNumber0.getText().toString();
                    binding.etCaculation1.append("0");
                    if (result2 != "") {
                        if (result.contains("%")) {
                            String split = result.replace("%", " ");
                            String[] a = split.split(" ");
                            double mult = Double.parseDouble(a[0]) % Double.parseDouble(a[1]);
                            total = mult;
                        }
                    } else {
                        result2 += binding.btnNumber0.getText().toString();
                        total %= Double.parseDouble(result2);
                    }
                    binding.etResult.setText(total + "");
                } else {
                    binding.etCaculation1.append("0");
                    result += binding.btnNumber0.getText().toString();
                    binding.etResult.append("0");
                }
                break;
            }
            case R.id.btnPlus: {
                String get_cal = binding.etCaculation1.getText().toString();
                if (result.contains("+")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append("+");
                    result += binding.btnPlus.getText().toString();
                    result2 = "";
                } else if (result.contains("-")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append("+");
                    result += binding.btnPlus.getText().toString();
                    result2 = "";
                } else if (result.contains("x")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append("x");
                    result += binding.btnPlus.getText().toString();
                    result2 = "";
                } else if (result.contains(":")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append("+");
                    result += binding.btnPlus.getText().toString();
                    result2 = "";
                }
                else if (result.contains("%")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append("+");
                    result += binding.btnPlus.getText().toString();
                    result2 = "";
                }
                else {
                    if (TextUtils.isEmpty(get_cal)) {
                        Toast.makeText(this, "Hãy nhập 1 số trước đó", Toast.LENGTH_SHORT).show();
                    } else {
                        binding.etCaculation1.append("+");
                        total = Integer.parseInt(result);
                        result += binding.btnPlus.getText().toString();
                    }
                }
                break;
            }
            case R.id.btnMinus: {
                String get_cal = binding.etCaculation1.getText().toString();
                if (result.contains("-")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append("-");
                    result += binding.btnMinus.getText().toString();
                    result2 = "";
                } else if (result.contains("+")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append("-");
                    result += binding.btnMinus.getText().toString();
                    result2 = "";
                } else if (result.contains("x")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append("-");
                    result += binding.btnMinus.getText().toString();
                    result2 = "";
                } else if (result.contains(":")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append("-");
                    result += binding.btnMinus.getText().toString();
                    result2 = "";
                }
                else if (result.contains("%")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append("-");
                    result += binding.btnMinus.getText().toString();
                    result2 = "";
                }
                else {
                    if (TextUtils.isEmpty(get_cal)) {
                        Toast.makeText(this, "Hãy nhập 1 số trước đó", Toast.LENGTH_SHORT).show();
                    } else {
                        binding.etCaculation1.append("-");
                        total = Integer.parseInt(result);
                        result += binding.btnMinus.getText().toString();
                    }
                }
                break;
            }
            case R.id.btnMultipy: {
                String get_cal = binding.etCaculation1.getText().toString();
                if (result.contains("x")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append("x");
                    result += binding.btnMultipy.getText().toString();
                    result2 = "";
                } else if (result.contains("+")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append("x");
                    result += binding.btnMultipy.getText().toString();
                    result2 = "";
                } else if (result.contains("-")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append("x");
                    result += binding.btnMultipy.getText().toString();
                    result2 = "";
                } else if (result.contains(":")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append("x");
                    result += binding.btnMultipy.getText().toString();
                    result2 = "";
                }
                else if (result.contains("%")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append("x");
                    result += binding.btnMultipy.getText().toString();
                    result2 = "";
                }else {
                    if (TextUtils.isEmpty(get_cal)) {
                        Toast.makeText(this, "Hãy nhập 1 số trước đó", Toast.LENGTH_SHORT).show();
                    } else {
                        binding.etCaculation1.append("x");
                        total = Integer.parseInt(result);
                        result += binding.btnMultipy.getText().toString();
                    }
                }
                break;
            }

            case R.id.btnDivide: {
                String get_cal = binding.etCaculation1.getText().toString();
                if (result.contains(":")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append(":");
                    result += binding.btnDivide.getText().toString();
                    result2 = "";
                } else if (result.contains("+")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append(":");
                    result += binding.btnDivide.getText().toString();
                    result2 = "";
                } else if (result.contains("-")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append(":");
                    result += binding.btnDivide.getText().toString();
                    result2 = "";
                } else if (result.contains("x")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append(":");
                    result += binding.btnDivide.getText().toString();
                    result2 = "";
                }
                else if (result.contains("%")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append(":");
                    result += binding.btnDivide.getText().toString();
                    result2 = "";
                } else {
                    if (TextUtils.isEmpty(get_cal)) {
                        Toast.makeText(this, "Hãy nhập 1 số trước đó", Toast.LENGTH_SHORT).show();
                    } else {
                        binding.etCaculation1.append(":");
                        total = Integer.parseInt(result);
                        result += binding.btnDivide.getText().toString();
                    }
                }
                break;
            }
            case R.id.btnMod: {
                String get_cal = binding.etCaculation1.getText().toString();
                if (result.contains(":")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append("%");
                    result += binding.btnMod.getText().toString();
                    result2 = "";
                } else if (result.contains("+")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append("%");
                    result += binding.btnMod.getText().toString();
                    result2 = "";
                } else if (result.contains("-")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append("%");
                    result += binding.btnMod.getText().toString();
                    result2 = "";
                } else if (result.contains("x")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append("%");
                    result += binding.btnMod.getText().toString();
                    result2 = "";
                } else if (result.contains("%")) {
                    result = total + "";
                    binding.etCaculation1.setText(result);
                    binding.etCaculation1.append("%");
                    result += binding.btnMod.getText().toString();
                    result2 = "";
                } else {
                    if (TextUtils.isEmpty(get_cal)) {
                        Toast.makeText(this, "Hãy nhập 1 số trước đó", Toast.LENGTH_SHORT).show();
                    } else {
                        binding.etCaculation1.append("%");
                        total = Integer.parseInt(result);
                        result += binding.btnMod.getText().toString();
                        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            }
            case R.id.btnSquare: {
                String get_result = binding.etResult.getText().toString();
                if (!TextUtils.isEmpty(get_result)) {
                    Double sqrt = Math.sqrt(Double.parseDouble(get_result));
                    binding.etResult.setText(sqrt + "");
                    total = sqrt;
                }
                break;
            }
            case R.id.btnSin: {
                String get_result = binding.etResult.getText().toString();
                if (!TextUtils.isEmpty(get_result)) {
                    Double sin = Math.sin(Double.parseDouble(get_result));
                    binding.etResult.setText(sin + "");
                    total = sin;
                }
                break;
            }
            case R.id.btnCos: {
                String get_result = binding.etResult.getText().toString();
                if (!TextUtils.isEmpty(get_result)) {
                    Double cos = Math.cos(Double.parseDouble(get_result));
                    binding.etResult.setText(cos + "");
                    total = cos;
                }
                break;
            }
            case R.id.btnLog: {
                String get_result = binding.etResult.getText().toString();
                if (!TextUtils.isEmpty(get_result)) {
                    Double log = Math.log(Double.parseDouble(get_result));
                    binding.etResult.setText(log + "");
                    total = log;
                }
                break;
            }
            case R.id.btnAC: {
                binding.etCaculation1.setText("");
                binding.etResult.setText("");
                total = 0;
                result = "";
                result2 = "";
                break;
            }
            case R.id.btnC: {
                String get_total_result = binding.etResult.getText().toString();
                String get_calcutlation = binding.etCaculation1.getText().toString();
                get_calcutlation = get_calcutlation.substring(0, get_calcutlation.length() - 1);
                String getLastChar = get_calcutlation.substring(get_calcutlation.length() - 1, get_calcutlation.length());
                if (getLastChar.equals("+")) {
                    result = get_calcutlation;
                    binding.etCaculation1.setText(result);
                    binding.etResult.setText(result.substring(0, result.length() - 1));
                } else if (getLastChar.equals("-")) {
                    result = get_calcutlation;
                    binding.etCaculation1.setText(result);
                    binding.etResult.setText(result.substring(0, result.length() - 1));
                } else if (getLastChar.equals("x")) {
                    result = get_calcutlation;
                    binding.etCaculation1.setText(result);
                    binding.etResult.setText(result.substring(0, result.length() - 1));
                } else if (getLastChar.equals(":")) {
                    result = get_calcutlation;
                    binding.etCaculation1.setText(result);
                    binding.etResult.setText(result.substring(0, result.length() - 1));
                } else {
                    result = get_calcutlation;
                    binding.etCaculation1.setText(result);
                    binding.etResult.setText(result);
                    if (result.contains("+")) {
                        String split = result.replace("+", " ");
                        String[] a = split.split(" ");
                        double differ = Double.parseDouble(a[0]) + Double.parseDouble(a[1]);
                        total = differ;
                        binding.etResult.setText(total + "");
                    }
                    if (result.contains("-")) {
                        String split = result.replace("-", " ");
                        String[] a = split.split(" ");
                        double differ = Double.parseDouble(a[0]) - Double.parseDouble(a[1]);
                        total = differ;
                        binding.etResult.setText(total + "");
                    }
                    if (result.contains("x")) {
                        String split = result.replace("x", " ");
                        String[] a = split.split(" ");
                        double differ = Double.parseDouble(a[0]) * Double.parseDouble(a[1]);
                        total = differ;
                        binding.etResult.setText(total + "");
                    }
                    if (result.contains(":")) {
                        String split = result.replace(":", " ");
                        String[] a = split.split(" ");
                        double differ = Double.parseDouble(a[0]) / Double.parseDouble(a[1]);
                        total = differ;
                        binding.etResult.setText(total + "");
                    }
                }
                if (TextUtils.isEmpty(get_total_result)) {
                    Log.e("stop", "Đã dừng");
                }
                break;
            }
            case R.id.btnResult: {
                binding.etResult.setTextSize(50.0f);
                binding.etResult.setText(total + "");
                binding.etCaculation1.setText("");
                CalculationHistory calculationHistory = new CalculationHistory(this);
                History history = new History(result, (float) total);
                calculationHistory.addHistory(history);
                total = 0;
                result = "";
                result2 = "";
                break;
            }
        }
    }
}