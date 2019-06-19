package com.qtasnim.qhopes.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.qtasnim.qhopes.R;
import com.qtasnim.qhopes.model.MenuHariiniModel;

import java.util.ArrayList;

public class MenuHariiniAdapter extends RecyclerView.Adapter<MenuHariiniAdapter.ViewHolder> {


    // Member variables.
    private ArrayList<MenuHariiniModel> mMenuHariiniModel;
    private Context mContext;


    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;

    /**
     * Constructor that passes in the sports data and the context.
     *
     * @param mMenuHariiniModel ArrayList containing the sports data.
     * @param context Context of the application.
     */
    public MenuHariiniAdapter(Context context, ArrayList<MenuHariiniModel> mMenuHariiniModel) {
        this.mMenuHariiniModel = mMenuHariiniModel;
        this.mContext = context;
    }


    /**
     * Required method for creating the viewholder objects.
     *
     * @param parent The ViewGroup into which the new View will be added
     *               after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return The newly created ViewHolder.
     */
    @Override
    public MenuHariiniAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.view_item_menu_hariini, parent, false));
    }

    /**
     * Required method that binds the data to the viewholder.
     *
     * @param holder The viewholder into which the data should be put.
     * @param position The adapter position.
     */
    @Override
    public void onBindViewHolder(MenuHariiniAdapter.ViewHolder holder,
                                 int position) {
        // Get current sport.
        MenuHariiniModel currentModel = mMenuHariiniModel.get(position);

        // Populate the textviews with data.
        holder.bindTo(currentModel);


    }

    /**
     * Required method for determining the size of the data set.
     *
     * @return Size of the data set.
     */
    @Override
    public int getItemCount() {
        return mMenuHariiniModel.size();
    }


    /**
     * ViewHolder class that represents each row of data in the RecyclerView.
     */
    class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        // Member Variables for the TextViews
        private TextView mNamaDokter;
        private TextView mNamaPoliklinik;
        private TextView mJamPraktek;
        private TextView mJumlahPasien;
        private TextView mCheckin;
        private TextView mJumlahTerlayani;


        /**
         * Constructor for the ViewHolder, used in onCreateViewHolder().
         *
         * @param itemView The rootview of the list_item.xml layout file.
         */
        ViewHolder(View itemView) {
            super(itemView);

            // Initialize the views.
            mNamaDokter = itemView.findViewById(R.id.tv_nama_dokter);
            mNamaPoliklinik = itemView.findViewById(R.id.tv_nama_poliklink);
            mJamPraktek = itemView.findViewById(R.id.tv_jam_praktek);
            mJumlahPasien = itemView.findViewById(R.id.tv_jumlah_pasien);
//            mCheckin = itemView.findViewById(R.id.)
            mJumlahTerlayani= itemView.findViewById(R.id.tv_jumlah_terlayani);

            // Set the OnClickListener to the entire view.
            itemView.setOnClickListener(this);
        }

        void bindTo(MenuHariiniModel currentModel){
            // Populate the textviews with data.
            mNamaDokter.setText(currentModel.getNama_dokter());
            mNamaPoliklinik.setText(currentModel.getNama_poliklinik());
            mJamPraktek.setText(currentModel.getJam_praktek());
            mJumlahPasien.setText(currentModel.getJumlah_pasien()+" pasien, ");
            mJumlahTerlayani.setText(currentModel.getJumlah_terlayani()+" terlayani");

            // Load the images into the ImageView using the Glide library.
//            Glide.with(mContext).load(
//                    currentSport.getImageResource()).into(mSportsImage);
        }

        /**
         * Handle click to show DetailActivity.
         *
         * @param view View that is clicked.
         */
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onClick(View view) {
            MenuHariiniModel currentModel = mMenuHariiniModel.get(getAdapterPosition());


            AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
            alertDialog.setTitle(currentModel.getNama_poliklinik());
            alertDialog.setMessage(currentModel.getNama_dokter());
            alertDialog.setPositiveButton("DAFTAR", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alertDialog.setNegativeButton("KEMBALI", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            AlertDialog dialog = alertDialog.create();
            dialog.show();
        }
    }
}
