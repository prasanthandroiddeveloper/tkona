package com.sss.talakona;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sss.talakona.Room.Talakona;

import java.util.ArrayList;
import java.util.List;

public class TalakonaAdapter extends RecyclerView.Adapter<TalakonaAdapter.MyViewHolder> {

    private Context context;
    private List<Talakona> talakonaList;
    private AdapterListener adapterListener;
    public TalakonaAdapter(Context context, AdapterListener listener){

        this.context=context;
        talakonaList=new ArrayList<>();
        this.adapterListener=listener;
    }

    public void addRental(Talakona talakona){
        talakonaList.add(talakona);
        notifyDataSetChanged();
    }
    public void removeRental(int position){
        talakonaList.remove(position);
       notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rental_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Talakona talakona=talakonaList.get(position);
        holder.tvrentalservicename.setText(talakona.getName());
        holder.tvrentalprice.setText(talakona.getTotalCost());

        holder.Ivupdate.setOnClickListener(view -> {
            adapterListener.OnUpdate(talakona.getId(),position);
        });

        holder.IVdelete.setOnClickListener(view -> {
            adapterListener.OnDelete(talakona.getId(),position);
        });



    }

    @Override
    public int getItemCount() {
        Log.i("taalakonacount", "getItemCount: "+talakonaList.size());
        return talakonaList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tvrentalprice,tvrentalservicename,tvprintpdf;
        private ImageView IVdelete,Ivupdate;
        Bundle bundle=new Bundle();

        public MyViewHolder (@NonNull View itemView){
            super(itemView);
            tvrentalservicename=itemView.findViewById(R.id.rentalservicenameTV);
            tvrentalprice=itemView.findViewById(R.id.rentalpriceTV);
            tvprintpdf=itemView.findViewById(R.id.displaypdf);
            IVdelete=itemView.findViewById(R.id.deleteIV);
            Ivupdate=itemView.findViewById(R.id.updateIV);

//            tvprintpdf.setOnClickListener(view -> {
//                String GETSERVICENAME=talakonaList.get(getAdapterPosition()).getRentalservicename();
//                String GETPRICE=talakonaList.get(getAdapterPosition()).getRentalserviceprice();
//                bundle.putString("name",GETSERVICENAME);
//                bundle.putString("price",GETPRICE);
//                Intent in=new Intent(context,PdfActivity.class);
//                in.putExtras(bundle);
//                context.startActivity(in);
//
//
//            });

        }
    }
}
