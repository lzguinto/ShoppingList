package com.example.lorenzg.shoppinglistapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class shoplist extends AppCompatActivity {

    public Button btnBack;
    public CheckBox[] chkList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoplist);


        chkList = new CheckBox[]{
                    (CheckBox) findViewById(R.id.chkFirst),
                    (CheckBox) findViewById(R.id.chkSecond),
                    (CheckBox) findViewById(R.id.chkThird),
                    (CheckBox) findViewById(R.id.chkFourth),
                    (CheckBox) findViewById(R.id.chkFifth),
                    (CheckBox) findViewById(R.id.chkSix),
                    (CheckBox) findViewById(R.id.chkSeven),
                    (CheckBox) findViewById(R.id.chkEight),
                    (CheckBox) findViewById(R.id.chkNine),
                    (CheckBox) findViewById(R.id.chkTen)
        };

        btnBack = (Button) findViewById(R.id.btnBack);

        String[] shoppinglist = getIntent().getStringArrayExtra("SHOPPING_LIST");

            for (int i = 0; i < chkList.length; i++) {
                chkList[i].setText(shoppinglist[i]);
        }
    }

    public void btnBack(View vw) {
        Intent Grocery = new Intent(this, Grocery.class);
            setResult(0, Grocery);
            setContentView(R.layout.activity_grocery);
    }
}
