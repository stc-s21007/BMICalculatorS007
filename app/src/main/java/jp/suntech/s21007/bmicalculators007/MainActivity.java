package jp.suntech.s21007.bmicalculators007;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnListener listener=new BtnListener();
        //Button
        Button btActBmi =findViewById(R.id.btActBmi);
        Button btClear=findViewById(R.id.btClear);
        btActBmi.setOnClickListener(listener);
        btClear.setOnClickListener(listener);

    }
    private class BtnListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            //EditText
            EditText AgeInput=findViewById(R.id.etAge);
            EditText HeightInput=findViewById(R.id.etHeight);
            EditText WeightInput=findViewById(R.id.etWeight);

            //TextView
            TextView AnsDegreeOutput=findViewById(R.id.tvAns);
            TextView AnsBMIOutput=findViewById(R.id.tvAnsWeight);
            TextView TvAnsText1=findViewById(R.id.tvAns_1);
            TextView TvAnsText2=findViewById(R.id.tvAns_2);
            TextView TvKg=findViewById(R.id.tv_kg);

            int id= view.getId();
            switch (id) {
                case R.id.btActBmi:
                    try{
                        int Age;
                        float AnsBMI, Height, Weight, AnsKg;

                        String Degree = "", BMW = "";
                        String InputAge = AgeInput.getText().toString();
                        Age = Integer.parseInt(InputAge);
                        String InputHeight = HeightInput.getText().toString();
                        Height = Float.parseFloat(InputHeight);
                        String InputWeight = WeightInput.getText().toString();
                        Weight = Float.parseFloat(InputWeight);

                        String tvAns1 = getResources().getString(R.string.tv_Ans_txt_1);
                        String tvAns2 = getResources().getString(R.string.tv_Ans_txt_2);
                        String tvKg = getResources().getString(R.string.tv_kg);

                        if (Age >= 16) {
                            AnsBMI = Weight / ((Height / 100) * (Height / 100));
                            AnsKg = ((Height / 100) * (Height / 100)) * 22;
                            if (AnsBMI >= 18.5) {
                                if (AnsBMI >= 25.0) {
                                    if (AnsBMI >= 30.0) {
                                        if (AnsBMI >= 35.0) {
                                            if (AnsBMI >= 40.0) {
                                                Degree = "肥満(4度)";
                                            } else {
                                                Degree = "肥満(3度)";
                                            }
                                        } else {
                                            Degree = "肥満(2度)";
                                        }
                                    } else {
                                        Degree = "肥満(1度)";
                                    }
                                } else {
                                    Degree = "普通体重";
                                }
                            } else {
                                Degree = "低体重";
                            }
                            BigDecimal x = new BigDecimal(AnsKg);
                            x = x.setScale(1, BigDecimal.ROUND_DOWN);
                            BMW = "" + x;
                            AnsDegreeOutput.setText(Degree);
                            AnsBMIOutput.setText(BMW);
                            TvAnsText1.setText(tvAns1);
                            TvAnsText2.setText(tvAns2);
                            TvKg.setText(tvKg);
                        } else if (Age >= 6) {
                            //OnAgeConfirmDialogFragment dialogFragment=new OnAgeConfirmDialogFragment();
                            //dialogFragment.show(getSupportFragmentManager(),"OnAgeConfirmFragment");
                            AnsBMI = Weight / (((Height * 100) * (Height * 100) * (Height * 100)) * 10);
                            if (AnsBMI >= 100) {
                                if (AnsBMI >= 115) {
                                    if (AnsBMI >= 145) {
                                        if (AnsBMI >= 160) {
                                            Degree = "太りすぎ";
                                        } else {
                                            Degree = "太りぎみ";
                                        }
                                    } else {
                                        Degree = "普通";
                                    }
                                } else {
                                    Degree = "やせぎみ";
                                }
                            } else {
                                Degree = "やせすぎ";
                            }
                            AnsDegreeOutput.setText(Degree);
                            TvAnsText1.setText("ローレル指数より" + tvAns1);
                        } else {
                            AnsBMI = Weight / ((Height / 100) * (Height / 100));
                            switch (Age) {
                                case 0:
                                    if (AnsBMI >= 14.5) {
                                        if (AnsBMI >= 16.0) {
                                            if (AnsBMI >= 18.0) {
                                                if (AnsBMI >= 20.0) {
                                                    Degree = "太りすぎ";
                                                } else {
                                                    Degree = "太りぎみ";
                                                }
                                            } else {
                                                Degree = "普通";
                                            }
                                        } else {
                                            Degree = "やせぎみ";
                                        }
                                    } else {
                                        Degree = "やせすぎ";
                                    }
                                    break;
                                case 1:
                                    if (AnsBMI >= 14.5) {
                                        if (AnsBMI >= 15.5) {
                                            if (AnsBMI >= 17.5) {
                                                if (AnsBMI >= 19.5) {
                                                    Degree = "太りすぎ";
                                                } else {
                                                    Degree = "太りぎみ";
                                                }
                                            } else {
                                                Degree = "普通";
                                            }
                                        } else {
                                            Degree = "やせぎみ";
                                        }
                                    } else {
                                        Degree = "やせすぎ";
                                    }
                                    break;
                                case 2:
                                    if (AnsBMI >= 13.5) {
                                        if (AnsBMI >= 15.0) {
                                            if (AnsBMI >= 17.0) {
                                                if (AnsBMI >= 18.5) {
                                                    Degree = "太りすぎ";
                                                } else {
                                                    Degree = "太りぎみ";
                                                }
                                            } else {
                                                Degree = "普通";
                                            }
                                        } else {
                                            Degree = "やせぎみ";
                                        }
                                    } else {
                                        Degree = "やせすぎ";
                                    }
                                    break;
                                case 3:
                                    if (AnsBMI >= 13.5) {
                                        if (AnsBMI >= 14.5) {
                                            if (AnsBMI >= 16.5) {
                                                if (AnsBMI >= 18) {
                                                    Degree = "太りすぎ";
                                                } else {
                                                    Degree = "太りぎみ";
                                                }
                                            } else {
                                                Degree = "普通";
                                            }
                                        } else {
                                            Degree = "やせぎみ";
                                        }
                                    } else {
                                        Degree = "やせすぎ";
                                    }
                                    break;
                                case 4:
                                    if (AnsBMI >= 13.0) {
                                        if (AnsBMI >= 14.5) {
                                            if (AnsBMI >= 16.5) {
                                                if (AnsBMI >= 18) {
                                                    Degree = "太りすぎ";
                                                } else {
                                                    Degree = "太りぎみ";
                                                }
                                            } else {
                                                Degree = "普通";
                                            }
                                        } else {
                                            Degree = "やせぎみ";
                                        }
                                    } else {
                                        Degree = "やせすぎ";
                                    }
                                    break;
                                case 5:
                                    if (AnsBMI >= 13.0) {
                                        if (AnsBMI >= 14.5) {
                                            if (AnsBMI >= 16.5) {
                                                if (AnsBMI >= 18.5) {
                                                    Degree = "太りすぎ";
                                                } else {
                                                    Degree = "太りぎみ";
                                                }
                                            } else {
                                                Degree = "普通";
                                            }
                                        } else {
                                            Degree = "やせぎみ";
                                        }
                                    } else {
                                        Degree = "やせすぎ";
                                    }
                                    break;
                            }

                            AnsDegreeOutput.setText(Degree);
                            TvAnsText1.setText("カウプ指数より" + tvAns1);
                        }
                    }
                    catch (Exception e){
                        OnAlertDialogFragment Dialog=new OnAlertDialogFragment();
                        Dialog.show(getSupportFragmentManager(),"AlertDialog");
                    }
                    break;
                case R.id.btClear:
                    AgeInput.setText("");
                    HeightInput.setText("");
                    WeightInput.setText("");
                    AnsBMIOutput.setText("");
                    AnsDegreeOutput.setText("");
                    TvAnsText1.setText("");
                    TvAnsText2.setText("");
                    TvKg.setText("");
                    break;
            }
        }
    }
}