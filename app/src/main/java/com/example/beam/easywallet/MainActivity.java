package com.example.beam.easywallet;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.app.AlertDialog;
import java.util.ArrayList;

import com.example.beam.easywallet.db.WallletDB;
import com.example.beam.easywallet.adapter.WalletAdapter;
import com.example.beam.easywallet.model.Walllet;


public class MainActivity extends AppCompatActivity {


    private WallletDB mHelper;
    private SQLiteDatabase mDb;

    private ArrayList<Walllet> mWalletItemList = new ArrayList<>();
    private WalletAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelper = new WallletDB(this);
        mDb = mHelper.getReadableDatabase();


        loadDataFromDb();
        mAdapter = new WalletAdapter(
                this,
                R.layout.item,
                mWalletItemList
        );

        ListView lv =  findViewById(R.id.list_view);
        lv.setAdapter(mAdapter);


        Button bIncome = findViewById(R.id.income);
        Button bExpense = findViewById(R.id.expense);


        bIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SaveClass.class);

                startActivity(intent);

            }
        });

        bExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SaveExpense.class);

                startActivity(intent);
            }
        });
    }

    private void loadDataFromDb() {
        Cursor cursor = mDb.query(
                WallletDB.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );

        mWalletItemList.clear();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndex(WallletDB.COL_ID));
            String image = cursor.getString(cursor.getColumnIndex(WallletDB.COL_IMAGE));
            String name = cursor.getString(cursor.getColumnIndex(WallletDB.COL_TITLE));
            String price = cursor.getString(cursor.getColumnIndex(WallletDB.COL_PRICE));
            ;

            Walllet item= new Walllet(id, name, price, image);
            mWalletItemList.add(item);
        }
    }

}
