package com.example.dato_labexercise4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] names, version, api, rDate,dbmsg;
    ListView list;

    int[] cLogo = {R.drawable.v1, R.drawable.v1point5, R.drawable.v1point6, R.drawable.v2, R.drawable.v2point2, R.drawable.v2point3, R.drawable.v3, R.drawable.v4, R.drawable.v4point1,
            R.drawable.v4point4, R.drawable.v5, R.drawable.v6, R.drawable.v7, R.drawable.v8, R.drawable.v9, R.drawable.androidten};

    ArrayList<Android> androidList =  new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        names = getResources().getStringArray(R.array.androidNames);
        version = getResources().getStringArray(R.array.androidVersions);
        api = getResources().getStringArray(R.array.androidAPI);
        rDate = getResources().getStringArray(R.array.androidRdate);
        dbmsg = getResources().getStringArray(R.array.dbmsg);
        list = findViewById(R.id.lvAndroids);

        for(int i = 0; i < names.length; i++){
            androidList.add(new Android(cLogo[i], names[i], version[i], api[i], rDate[i], dbmsg[i]));
        }

        list = findViewById(R.id.lvAndroids);
        AndroidAdapter adapter = new AndroidAdapter(this, R.layout.item, androidList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle(androidList.get(i).getName());
        dialog.setIcon(androidList.get(i).getLogo());
        dialog.setMessage(androidList.get(i).getDbmsg());
        dialog.setNeutralButton("CLOSE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick (DialogInterface dialog,int which){
                dialog.dismiss();
            }
        });
        dialog.create().show();

    }
}
