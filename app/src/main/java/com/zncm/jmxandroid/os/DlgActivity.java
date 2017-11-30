package com.zncm.jmxandroid.os;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.zncm.jmxandroid.R;
import com.zncm.jmxandroid.base.BaseAc;
import com.zncm.jmxandroid.base.MyApp;

import java.util.ArrayList;
import java.util.Calendar;

public class DlgActivity extends BaseAc {
    Context ctx;
    private Button dlg1;
    private Button dlg2;
    private Button dlg3;
    private Button dlg4;
    private Button dlg5;

    private Button dlg6;
    private Button dlg7;
    private Button dlg8;
    private Button dlg9;
    ArrayList<Integer> list = new ArrayList<>();

    Handler mHandler = new Handler();
    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;


        dlg1 = (Button) findViewById(R.id.dlg1);
        dlg2 = (Button) findViewById(R.id.dlg2);
        dlg3 = (Button) findViewById(R.id.dlg3);
        dlg4 = (Button) findViewById(R.id.dlg4);
        dlg5 = (Button) findViewById(R.id.dlg5);


        dlg6 = (Button) findViewById(R.id.dlg6);
        dlg7 = (Button) findViewById(R.id.dlg7);
        dlg8 = (Button) findViewById(R.id.dlg8);
        dlg9 = (Button) findViewById(R.id.dlg9);


        dlg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dlg1();
            }
        });
        dlg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg2();


            }
        });
        dlg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg3();

            }
        });
        dlg4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg4();


            }
        });

        dlg5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg5();
            }
        });
        dlg6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg6();

            }
        });
        dlg7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg7();
            }


        });
        dlg8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg8();

            }
        });
        dlg9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                TimePickerDialog dialog = new TimePickerDialog(ctx,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                d("选择时间：" + hourOfDay + "时" + minute + "分");
                            }
                        }, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE), true);
                dialog.show();


            }
        });


    }

    private void dlg8() {
        Calendar c = Calendar.getInstance();
        DatePickerDialog dialog = new DatePickerDialog(ctx,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        d("选择日期：" + year + "年" + (monthOfYear+1) + "月" + dayOfMonth + "日");
                    }
                }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    private void dlg7() {
        final int MAX_PROGRESS = 100;
        final ProgressDialog dialog = new ProgressDialog(ctx);
        dialog.setTitle("我是标题");
        dialog.setProgress(0);
        dialog.setMax(MAX_PROGRESS);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                mHandler.removeCallbacksAndMessages(null);
                d("进度被打断");
            }
        });
        dialog.show();

        progress = 0;
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                d("" + progress);
                progress++;
                dialog.setProgress(progress);
                if (progress == 100) {
                    dialog.cancel();
                } else {
                    mHandler.postDelayed(this, 100);
                }
            }
        }, 100);
    }
    private void dlg6() {
        ProgressDialog dialog = new ProgressDialog(ctx);
        dialog.setTitle("我是标题");
        dialog.setMessage("等待中...  想关闭请杀掉app");
        dialog.setIndeterminate(true);
        dialog.setCancelable(true);
        dialog.show();
    }

    private void dlg5() {
        final String[] items = {"项目1", "项目2", "项目3", "项目4"};
        final boolean selected[] = {false, true, false, false};
        list.clear();
        for (int i = 0, size = selected.length; i < size; ++i) {
            if (selected[i]) {
                list.add(i);
            }
        }
        AlertDialog.Builder dialog = new AlertDialog.Builder(ctx);
        dialog.setTitle("我是标题")
                .setMultiChoiceItems(items, selected,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                if (isChecked) {
                                    list.add(which);
                                } else {
                                    list.remove(Integer.valueOf(which));
                                }
                            }
                        })
                .setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if (list.size() == 0) {
                                    d("你什么都没选啊，小伙");
                                } else {
                                    StringBuilder str = new StringBuilder();
                                    for (int i = 0, size = list.size(); i < size; i++) {
                                        str.append(items[list.get(i)]);
                                        if (i < size - 1) {
                                            str.append(", ");
                                        }
                                    }
                                    d("你选中了: " + str.toString());
                                }
                            }
                        });
        dialog.show();
    }

    private void dlg4() {
        int select = 1; //表示单选对话框初始时选中哪一项

        final String[] items = {"项目1", "项目2", "项目3", "项目4"};
        AlertDialog.Builder dialog = new AlertDialog.Builder(ctx);
        dialog.setTitle("我是标题")
                .setSingleChoiceItems(items, select,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                d("选择: " + items[which]);
                            }
                        })
                .setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
        dialog.show();
    }

    private void dlg3() {
        final String[] items = {"项目1", "项目2", "项目3", "项目4"};
        AlertDialog.Builder dialog = new AlertDialog.Builder(ctx);
        dialog.setTitle("我是标题")
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        d("选择: " + items[which]);
                    }
                });
        dialog.show();
    }

    private void dlg2() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(ctx);
        dialog.setIcon(R.drawable.ic_launcher)
                .setTitle("我是标题")
                .setMessage("我是要显示的消息")
                .setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                d("确定");
                            }
                        })
                .setNeutralButton("说明",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                d("说明");
                            }
                        })
                .setNegativeButton("取消",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                d("取消");
                            }
                        });
        dialog.show();
    }



    private void dlg1() {
        final AlertDialog.Builder dialog = new AlertDialog.Builder(ctx) {
            @Override
            public AlertDialog create() {
                d("对话框create，创建时调用");
                return super.create();
            }

            @Override
            public AlertDialog show() {
                d("对话框show，显示时调用");
                return super.show();
            }
        };

        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                d("对话框取消");
            }
        });

        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialog) {
                d("对话框销毁");
            }
        });

        dialog.setIcon(R.drawable.ic_launcher)
                .setTitle("我是标题")
                .setMessage("我是要显示的消息")
                .setCancelable(true)
                .setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                d("点击确定");
                            }
                        })
                .setNegativeButton("取消",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                d("点击取消");
                            }
                        });
        dialog.show();
    }


    public static void d(String msg) {
        Toast.makeText(MyApp.getInstance().ctx, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_dlg;
    }
}
