package com.simrs.qt.simrs.adapters;



import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.simrs.qt.simrs.R;
import com.simrs.qt.simrs.model.MenuHariiniModel;

import java.util.ArrayList;

public class MenuHariiniAdapter extends ArrayAdapter<MenuHariiniModel> implements View.OnClickListener{

    private ArrayList<MenuHariiniModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtsp;
        TextView txtjam;
        ImageView info;
    }

    public MenuHariiniAdapter(ArrayList<MenuHariiniModel>data, Context context) {
        super(context, R.layout.view_datarow_menu_hariini, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position=(Integer) v.getTag();
        Object object= getItem(position);
        MenuHariiniModel dataModel=(MenuHariiniModel)object;

        switch (v.getId())
        {
            case R.id.item_info:
                Snackbar.make(v, "Release date " +dataModel.getJam_praktek(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        MenuHariiniModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.view_datarow_menu_hariini, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.name);
            viewHolder.txtsp = (TextView) convertView.findViewById(R.id.spesialis);
            viewHolder.txtjam = (TextView) convertView.findViewById(R.id.jam);
            viewHolder.info = (ImageView) convertView.findViewById(R.id.item_info);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }



        viewHolder.txtName.setText(dataModel.getNama_dokter());
        viewHolder.txtsp.setText(dataModel.getNama_poliklinik());
        viewHolder.txtjam.setText(dataModel.getJam_praktek());
        viewHolder.info.setOnClickListener(this);
        viewHolder.info.setTag(position);
        // Return the completed view to render on screen
        return convertView;
    }
}
