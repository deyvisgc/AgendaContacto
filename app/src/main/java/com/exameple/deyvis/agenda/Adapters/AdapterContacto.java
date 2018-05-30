package com.exameple.deyvis.agenda.Adapters;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.exameple.deyvis.agenda.Modelo.Contacto;
import com.exameple.deyvis.agenda.uss.contactos.R;

import java.util.List;

/**
 * Created by guima on 27/11/2015.
 */
public class AdapterContacto extends BaseAdapter {

    private List<Contacto> list;
    private Activity activity;
    ImageView call;


    public AdapterContacto(Activity activity, List<Contacto> list) {
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View v = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.detalle_contacto, null);

        }
        Contacto conta = list.get(position);
        TextView tvNombreV = (TextView) v.findViewById(R.id.tvNombreV);
        tvNombreV.setText(conta.getNombre());
        final TextView tvNumeroV = (TextView) v.findViewById(R.id.tvNumeroV);
        tvNumeroV.setText(conta.getTelefono());
        TextView tvEmailV = (TextView) v.findViewById(R.id.tvEmailV);
        tvEmailV.setText(conta.getEmail());


        call = (ImageView)v.findViewById(R.id.llamar);


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("telefono" + tvNumeroV));

                        if (ActivityCompat.checkSelfPermission(v.getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            // TODO: Consider calling
                            //    ActivityCompat#requestPermissions
                            // here to request the missing permissions, and then overriding
                            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                            //                                          int[] grantResults)
                            // to handle the case where the user grants the permission. See the documentation
                            // for ActivityCompat#requestPermissions for more details.
                            return;

                        }
                        v.getContext().startActivity(intent);
                        Log.d("llamo",""+tvNumeroV);

                    }
                });





            }
        });



        return v;
    }



}