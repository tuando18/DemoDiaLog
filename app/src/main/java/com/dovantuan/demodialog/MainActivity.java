package com.dovantuan.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_alert, btn_confirm, btn_custum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_alert = findViewById(R.id.btn_alert);
        btn_confirm = findViewById(R.id.btn_confirm);
        btn_custum = findViewById(R.id.btn_custom);

        btn_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();
            }
        });

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmDialog();
            }
        });

        btn_custum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustumDialog();
            }
        });
    }

    void showAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Thông Báo");
        builder.setIcon(android.R.drawable.ic_delete);
        builder.setMessage("Đã xóa thành công");
        builder.setCancelable(false);//kh cho phép bỏ qua dialog

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Lệnh tắt dialog
                 dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();//hiện thị dialog
    }

    void showConfirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Thông Báo");
        builder.setIcon(android.R.drawable.ic_delete);
        builder.setMessage("Bạn có đồng ý xóa dữ liệu?");
        builder.setCancelable(false);//kh cho phép bỏ qua dialog

        builder.setPositiveButton("Đồng ý xóa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Viết lệnh xóa ở đây: gọi DAO để xóa dữ liệu

                Toast.makeText(MainActivity.this, "Đã xóa dữ liệu", Toast.LENGTH_SHORT).show();
                //Lệnh tắt dialog
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Không xóa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();//hiện thị dialog
    }

    void showCustumDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        LayoutInflater inflater = getLayoutInflater();

        View v = inflater.inflate(R.layout.dialog_reg, null);

        builder.setCancelable(false);
        builder.setView(v);
        AlertDialog dialog = builder.create();

        //viết lệnh tương tác với các view trong dialog
        EditText ed_username = v.findViewById(R.id.ed_username);
        EditText ed_pass = v.findViewById(R.id.ed_passwd);
        EditText ed_email = v.findViewById(R.id.ed_email);

        Button btn_reg = v.findViewById(R.id.btn_reg);
        Button btn_cancel = v.findViewById(R.id.btn_cancel);
        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lấy dữ liệu
                String username = ed_username.getText().toString();

                Toast.makeText(MainActivity.this, "User= " + username, Toast.LENGTH_SHORT).show();
                //tắt dialog
                dialog.dismiss();
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //tắt dialog
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}