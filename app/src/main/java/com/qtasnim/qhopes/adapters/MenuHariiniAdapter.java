package com.qtasnim.qhopes.adapters;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.qtasnim.qhopes.R;
import com.qtasnim.qhopes.model.MenuHariiniModel;

import java.util.ArrayList;

public class MenuHariiniAdapter extends RecyclerView.Adapter<MenuHariiniAdapter.ViewHolder> {


    private View.OnClickListener onItemClickListener;

    // Member variables.
    private ArrayList<MenuHariiniModel> mMenuHariiniModel;
    private Context mContext;
    private TextView
                mNamaDokter,
                mNamaPoliklinik,
                mKuotaPasien,
                mPasienTerlayani,
                mPasienTerdaftar,
                mPasienMengantri,
                mJamPraktek,
                mDialogPoliklinik,
                mCheckin;
    private Button
                mBtnDialogKembali,
                mBtnDialogDaftar;
    private Dialog dialog;
    private LayoutInflater inflater;
    private View dialogView;

    public void setItemClickListener(View.OnClickListener clickListener) {
        onItemClickListener = clickListener;
    }

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
        MenuHariiniModel currentModel = mMenuHariiniModel.get(position);
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

        /**
         * Constructor for the ViewHolder, used in onCreateViewHolder().
         *
         * @param itemView The rootview of the list_item.xml layout file.
         */
        ViewHolder(View itemView) {
            super(itemView);
            itemView.setTag(this);
            itemView.setOnClickListener(onItemClickListener);
            mNamaDokter = itemView.findViewById(R.id.tv_nama_dokter);
            mNamaPoliklinik = itemView.findViewById(R.id.tv_nama_poliklink);
            mKuotaPasien = itemView.findViewById(R.id.tv_kuota_pasien);
            mPasienTerlayani = itemView.findViewById(R.id.tv_pasien_terlayani);
            mPasienTerdaftar = itemView.findViewById(R.id.tv_pasien_terdaftar);
            mPasienMengantri = itemView.findViewById(R.id.tv_pasien_mengantri);
            mJamPraktek = itemView.findViewById(R.id.tv_jam_praktek);
//            mCheckin = itemView.findViewById(R.id.)

            itemView.setOnClickListener(this);
        }

        void bindTo(MenuHariiniModel currentModel){

//             Load the images into the ImageView using the Glide library.
//            Glide.with(mContext).load(
//                    currentSport.getImageResource()).into(mSportsImage);

            mNamaDokter.setText(currentModel.getNama_dokter());
            mNamaPoliklinik.setText(currentModel.getNama_poliklinik());
            mJamPraktek.setText(currentModel.getJam_praktek());
            mKuotaPasien.setText("Kuota  : "+currentModel.getKuota_pasien()+" Pasien");
            mPasienTerlayani.setText("Terlayani : "+currentModel.getPasien_terlayani()+" Pasien");
            mPasienTerdaftar.setText("Daftar : 0 Pasien");
            mPasienMengantri.setText("Antri         : 0 Pasien");
        }

        /**
         * Handle click to show DetailActivity.
         *
         * @param view View that is clicked.
         */
        @Override
        public void onClick(View view) {

        }
    }
}
