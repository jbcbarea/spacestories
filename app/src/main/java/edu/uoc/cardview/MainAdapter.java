package edu.uoc.cardview;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import edu.uoc.cardview.modelos.CuentosRV;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    //Inicializamos variables
    public static int[] imgCuentos = new int[]{
            R.drawable.cero, R.drawable.uno, R.drawable.dos, R.drawable.tres, R.drawable.cuatro, R.drawable.cinco, R.drawable.seis, R.drawable.siete,
            R.drawable.ocho, R.drawable.nueve, R.drawable.diez, R.drawable.once, R.drawable.doce, R.drawable.trece, R.drawable.catorce, R.drawable.quince,
            R.drawable.dieciseis, R.drawable.diecisiete, R.drawable.magooz, R.drawable.diecinueve, R.drawable.veinte, R.drawable.veintiuno, R.drawable.veintidos,
            R.drawable.veintitrs, R.drawable.veinticuatro, R.drawable.veinticinco, R.drawable.veintiseis, R.drawable.veintisiete, R.drawable.veintiocho, R.drawable.veintinueve, R.drawable.treinta, R.drawable.treintayuno, R.drawable.treintaydos, R.drawable.treintaytres,
            R.drawable.treintaycuatro, R.drawable.treintaycinco, R.drawable.treintayseis, R.drawable.treintaysiete, R.drawable.treintayocho, R.drawable.treintaynueve, R.drawable.cuarenta,
            R.drawable.cuarentauno, R.drawable.cuarentados, R.drawable.cuarentatres, R.drawable.cuarentacuatro, R.drawable.cuatrocinco, R.drawable.cuatroseis, R.drawable.cuatrosiete,
            R.drawable.cuatroocho, R.drawable.cuarentaynueve, R.drawable.cincuenta, R.drawable.cincuentauno,
            R.drawable.cincuentados, R.drawable.cincuentatres, R.drawable.cincuentacuatro, R.drawable.cincuentacinco, R.drawable.cincuentaseis, R.drawable.cincuentasiete, R.drawable.cincuentaocho, R.drawable.cincuentanueve,
            R.drawable.sesenta, R.drawable.sesentayuno,
    };

    Activity activity;
    ArrayList<CuentosRV> cuentosRV = new ArrayList<CuentosRV>();
    List<CuentosRV> cuentosRVSearchView = new ArrayList<>();
    Context context;

    //Creamos el constructor
    public MainAdapter(Activity activity, ArrayList<CuentosRV> arrayList, Context context) {
        this.activity = activity;
        this.cuentosRVSearchView = arrayList;
        cuentosRV = new ArrayList<>();
        cuentosRV.addAll(cuentosRVSearchView);
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inicializamos Vistas
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        //ViewHolder holder = new ViewHolder(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Inicializamos los objetos de contactos
        //ContactObject model = arrayList.get(position);
        CuentosRV cuentosList = cuentosRVSearchView.get(position);
        //holder.txtTitle.setText(Integer.toString(cuentosList.getId()));
        holder.txtTitle.setText(cuentosList.getTitle());
        holder.imgView.setImageResource(imgCuentos[cuentosList.getImage()]);
        //Glide.with(context).load(cuentosList.getImage()).into(holder.imgView);
        //int ident = model.getContact_Photo();
        //holder.imgView.setImageDrawable(cuentosList.getImage());
        //Aqui por medio de holder referenciamos el layout donde tenemos cada fila del RecyclerView para que con un método setOnclickListener al pulksar nos llecve a la nueva Activity
        holder.imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                System.out.println(cuentosList.getTitle());
                System.out.println(cuentosList.getImage());
                System.out.println(cuentosList.getId());
                Intent intent = new Intent(context, ContentCuentos.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Id", cuentosList.getId());
                intent.putExtra("Title", cuentosList.getTitle());
                intent.putExtra("Image", cuentosList.getImage());

                context.getApplicationContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        //Return array size
        return cuentosRVSearchView.size();
    }

    public void filter(String strSearch) {
        if (strSearch.length() == 0) {
            cuentosRVSearchView.clear();
            cuentosRVSearchView.addAll(cuentosRV);
        } else {
           // if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                cuentosRVSearchView.clear();
                List<CuentosRV> collect = cuentosRVSearchView.stream()
                        .filter(i -> i.getTitle().toLowerCase().contains(strSearch.toLowerCase()))
                        .collect(Collectors.toList());

                cuentosRVSearchView.clear();
                cuentosRVSearchView.addAll(collect);

                }
                for (CuentosRV i : cuentosRV) {
                    if (i.getTitle().toLowerCase().contains(strSearch)) {
                        cuentosRVSearchView.add(i);
                    }
                }
                notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        //Referenciamos las variables, it´s holding the view somehow
        TextView txtTitle;
        ImageView imgView;
        ConstraintLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Asignamos las variables
            txtTitle = itemView.findViewById(R.id.txtTitle);
            imgView = itemView.findViewById(R.id.img);
            //parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }

}

