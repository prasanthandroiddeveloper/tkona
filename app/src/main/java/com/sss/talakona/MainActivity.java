package com.sss.talakona;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sss.talakona.Room.Talakona;
import com.sss.talakona.Room.TalakonaDao;
import com.sss.talakona.Room.TalakonaDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity  implements AdapterListener{

    EditText etvechicleno,etname,etphone,etcity,etnumperson,ettwowhlr,etthreewhlr,etfourwhlr,etbustruck,etstillcmra,etvideocmra;
    TextView tvtotalcost;
    Button btnsave;
    String TWOWHLR,THREEWHLR,FOURWHLR,BUSTRUCK,STLCMRA,VISCMRA,FEEPERSON,VEHICLENO,NAME,PHONE,CITY;
    int TWOWHLRI=25,THREEWHLRI=50,FOURWHLRI=100,BUSTRUCKI=200,STLCMRAI=50,VISCMRAI=100,FEEPERSONI=10,result=0,x,y,z,p,q,r,a;
     TalakonaDao talakonaDao;
    TalakonaDatabase talakonaDatabase;
    private TalakonaAdapter talakonaAdapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etvechicleno=findViewById(R.id.vechicleNoET);
        etname=findViewById(R.id.nameET);
        etphone=findViewById(R.id.phoneET);
        etcity=findViewById(R.id.ctvET);
        etnumperson=findViewById(R.id.personsET);
        ettwowhlr=findViewById(R.id.twowhlrET);
        etthreewhlr=findViewById(R.id.threewhlrET);
        etfourwhlr=findViewById(R.id.fourwhlrET);
        etbustruck=findViewById(R.id.bustruckET);
        etstillcmra=findViewById(R.id.stillCmraET);
        etvideocmra=findViewById(R.id.videoCmraET);
        tvtotalcost=findViewById(R.id.totalcostTV);
        btnsave=findViewById(R.id.saveBtn);

        talakonaDatabase=TalakonaDatabase.getInstance(this);
        talakonaDao=talakonaDatabase.getDao();

        talakonaAdapter=new TalakonaAdapter(this,this);
        recyclerView=findViewById(R.id.rentalRecycler);
        recyclerView.setAdapter(talakonaAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchrental();
        btnsave.setOnClickListener(view -> {
            VEHICLENO=etvechicleno.getText().toString().trim();
            NAME=etname.getText().toString().trim();
            PHONE=etphone.getText().toString().trim();
            CITY=etcity.getText().toString().trim();
            TWOWHLR=ettwowhlr.getText().toString().trim();
            THREEWHLR=etthreewhlr.getText().toString().trim();
            FOURWHLR=etfourwhlr.getText().toString().trim();
            BUSTRUCK=etbustruck.getText().toString().trim();
            STLCMRA=etstillcmra.getText().toString().trim();
            VISCMRA=etvideocmra.getText().toString().trim();
            FEEPERSON=etnumperson.getText().toString().trim();


            if(!TextUtils.isEmpty(TWOWHLR)){
                x=Integer.parseInt(TWOWHLR)*TWOWHLRI;
                Log.i("TWOWHLR", String.valueOf(result));
            }
            if(!TextUtils.isEmpty(THREEWHLR)){
                y=Integer.parseInt(THREEWHLR)*THREEWHLRI;
                Log.i("THREEWHLR", String.valueOf(result));
            }
            if(!TextUtils.isEmpty(FOURWHLR)){
                z=Integer.parseInt(FOURWHLR)*FOURWHLRI;
                Log.i("FOURWHLR", String.valueOf(result));
            }
            if(!TextUtils.isEmpty(BUSTRUCK)){
                p=Integer.parseInt(BUSTRUCK)*BUSTRUCKI;
                Log.i("BUSTRUCK", String.valueOf(result));
            }
            if(!TextUtils.isEmpty(STLCMRA)){
                q=Integer.parseInt(STLCMRA)*STLCMRAI;
                Log.i("BUSTRUCK", String.valueOf(result));
            }
            if(!TextUtils.isEmpty(VISCMRA)){
                r=Integer.parseInt(VISCMRA)*VISCMRAI;
                Log.i("BUSTRUCK", String.valueOf(result));
            }
            if(!TextUtils.isEmpty(FEEPERSON)){
                a=Integer.parseInt(FEEPERSON)*FEEPERSONI;
                Log.i("BUSTRUCK", String.valueOf(result));
            }
            result=x+y+z+p+q+r;

            tvtotalcost.setText(String.valueOf(result));
            Talakona talakona=new Talakona(0,VEHICLENO,NAME,PHONE,CITY,String.valueOf(FEEPERSON),TWOWHLR,THREEWHLR,FOURWHLR,BUSTRUCK,STLCMRA,VISCMRA,String.valueOf(result));
            talakonaAdapter.addRental(talakona);
            talakonaDao.insert(talakona);

            Toast.makeText(this, "Data Submitted Successfully", Toast.LENGTH_LONG).show();

        });

    }

    private void fetchrental(){
        List<Talakona> talakonaList= talakonaDao.getTalakona();
        Log.i("talakonalist", String.valueOf(talakonaList));
        for(int i=0;i<talakonaList.size();i++){
            Talakona talakona=talakonaList.get(i);
            Log.i("talakonalist", String.valueOf((talakonaList.get(i))));
            Log.i("talakona", String.valueOf(talakona));
            talakonaAdapter.addRental(talakona);
        }
    }

    @Override
    public void OnUpdate(int id, int pos) {

    }

    @Override
    public void OnDelete(int id, int pos) {

    }


    //




}