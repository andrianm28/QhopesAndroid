package com.qtasnim.qhopes.navigation.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.qtasnim.qhopes.R;
import com.qtasnim.qhopes.activities.MainActivity;
import com.qtasnim.qhopes.activities.MenuBeritaActivity;
import com.qtasnim.qhopes.activities.MenuHariIniActivity;
import com.qtasnim.qhopes.activities.MenuInfoActivity;
import com.qtasnim.qhopes.activities.MenuKontakActivity;
import com.qtasnim.qhopes.activities.MenuMingguiniActivity;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.Objects;


public class HomeNavFragment extends Fragment implements View.OnClickListener {

    private int[] sampleImages = {R.drawable.jp1, R.drawable.jp2, R.drawable.jp3, R.drawable.jp4};
    private OnFragmentInteractionListener mListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void setActionBar(){
        ((MainActivity) Objects.requireNonNull(getActivity()))
                .setActionBarTitle(getString(R.string.title_beranda));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_nav_home, container, false);
        setActionBar();

        CarouselView carousel_view = rootView.findViewById(R.id.carousel_view);
        carousel_view.setPageCount(sampleImages.length);
        carousel_view.setImageListener(imageListener);

        ImageButton btnMenuHariini = rootView.findViewById(R.id.btn_menu_hariini);
        btnMenuHariini.setOnClickListener(this);
        ImageButton btnMenuMingguini = rootView.findViewById(R.id.btn_menu_mingguini);
        btnMenuMingguini.setOnClickListener(this);
        ImageButton btnMenuSpesialis = rootView.findViewById(R.id.btn_menu_spesialis);
        btnMenuSpesialis.setOnClickListener(this);
        ImageButton btnMenuBerita = rootView.findViewById(R.id.btn_menu_berita);
        btnMenuBerita.setOnClickListener(this);
        ImageButton btnMenuInfo = rootView.findViewById(R.id.btn_menu_info);
        btnMenuInfo.setOnClickListener(this);
        ImageButton btnMenuKontak = rootView.findViewById(R.id.btn_menu_kontak);
        btnMenuKontak.setOnClickListener(this);

        return rootView;
    }


    private ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_menu_hariini:
                Intent intent1 = new Intent(getActivity(), MenuHariIniActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_menu_mingguini:
                Intent intent2 = new Intent(getActivity(), MenuMingguiniActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_menu_spesialis:
                Intent intent3 = new Intent(getActivity(), MenuSpesialisActivity.class);
                startActivity(intent3);
                break;
            case R.id.btn_menu_berita:
                Intent intent4 = new Intent(getActivity(), MenuBeritaActivity.class);
                startActivity(intent4);
                break;
            case R.id.btn_menu_info:
                Intent intent5 = new Intent(getActivity(), MenuInfoActivity.class);
                startActivity(intent5);
                break;
            case R.id.btn_menu_kontak:
                Intent intent6 = new Intent(getActivity(), MenuKontakActivity.class);
                startActivity(intent6);
                break;
        }
    }
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
