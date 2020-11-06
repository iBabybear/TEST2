package com.example.myapplication;
import android.content.DialogInterface;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private String[] mountainArray;
    private ProgressBar progressBar;
 /*   private EditText usernameView;
    private EditText resultView ;*/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative_layout_2);
        mountainArray = getResources().getStringArray(R.array.t1);
        initView();
        
    }

    private void initView() {
        RadioGroup rg = findViewById(R.id.visit_place_rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int index = -1;
                if (i == R.id.place1) {
                    index = 0;
                } else if (i == R.id.place2) {
                    index = 1;
                } else if (i == R.id.place3) {
                    index = 2;
                } else if (i == R.id.place4) {
                    index = 3;
                }
                if (index >= 0 && index < mountainArray.length) {
                    showUIToast(mountainArray[index]);
                }
            }
        });
        Button submitView = (Button) findViewById(R.id.submit);
        progressBar=(ProgressBar)findViewById(R.id.progress1) ;
        Button plusView = (Button)findViewById(R.id.plus_view);
        Button substractView =(Button)findViewById(R.id.substract_view);
        substractView.setOnClickListener(this);
        plusView.setOnClickListener(this);
        submitView.setOnClickListener(this);

        Button button = findViewById(R.id.submit);
        button.setOnClickListener(this);

      /*  submitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
            }
        });*/
    }


    private void showUIToast(final String info) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "您选择的景点是：" + info, Toast.LENGTH_LONG).show();
            }
        });


    }
private void updateProgressView(boolean plus){
        int progress = progressBar.getProgress();
        if(plus){
            progress +=10;
            if (progress>100)
                progress=100;
        }else{
            progress -=10;
            if (progress<0)
                progress=0;
        }
    progressBar.setProgress(progress);
}

/*private void onSubmit(){
    StringBuffer sb = new StringBuffer();
    sb.append(getString(R.string.your_hobbies_info,hobbyList.toString()));
    String username = usernameView.getText().toString();
    if (username !=null && !username.isEmpty()){
    sb.append("\n by" +username);
            }
            resultView.setText(sb.toString());
    }*/
@Override
public void onClick(View view) {
        int id=view.getId();
        switch (id){
            case R.id.plus_view:
                updateProgressView(true);
                break;
            case R.id.submit:
                onSubmitConfirm();
                break;
            case R.id.substract_view:
                updateProgressView(false);
                break;
            default:
                break;
        }
        }

public void onSubmitConfirm(){
    AlertDialog dlg;
    AlertDialog.Builder builder = new AlertDialog.Builder(this)
            .setTitle("对话框")
            .setIcon(R.mipmap.ic_launcher)
            .setMessage("是否确认提交")

           .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialog, int which) {

               }
           })
            .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

                 dlg = builder.create();
                 dlg.show();
            /*.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            })*/
}




}