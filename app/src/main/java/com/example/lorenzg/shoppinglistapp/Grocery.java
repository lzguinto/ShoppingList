package com.example.lorenzg.shoppinglistapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Grocery extends AppCompatActivity {

    public int Number = 0;
    public String[] list = new String[10];
    public String txtItem;
    public EditText edtxtItem;
    public Button btnAdd;
    public Button btnReset;
    public Button btnFinish;
    public TextView txtLimit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery);

        edtxtItem = (EditText) findViewById(R.id.edtxtItem);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnReset = (Button) findViewById(R.id.btnReset);
        btnFinish = (Button) findViewById(R.id.btnFinish);
        txtLimit = (TextView) findViewById(R.id.txtLimit);
    }

    public void btnAdd(View vw) {

        txtItem = edtxtItem.getText().toString();

        if (txtItem.isEmpty()) {
            txtLimit.setText("You have not entered an item.");
        } else {
            if (Number >= 10) {
                txtLimit.setText("You've reached your limit of 10 items.");
            } else {
                list[Number] = txtItem;
                Number = Number + 1;
                txtLimit.setText("");
                String count = String.format("Current Items: %d", Number);
                txtLimit.setText(count);
            }
        }
    }

    public void btnReset(View vw) {
        Number = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].isEmpty()) {
            } else {
                list[i] = "";
            }
        }
        txtLimit.setText("");
    }

    public void btnFinish(View vw) {

        Intent shoplist = new Intent(this, shoplist.class);

        String[] itemName = new String[list.length];

        for (int i = 0; i < list.length; i++) {
            if (list[i].isEmpty()) {
                itemName[i] = "";
            } else {
                itemName[i] = txtItem;
            }
        }

        shoplist.putExtra("SHOPPING_LIST", itemName);
        startActivityForResult(shoplist, 0);
        setContentView(R.layout.activity_shoplist);
    }
}


