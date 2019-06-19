package com.qtasnim.qhopes;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragmentNav.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragmentNav#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragmentNav extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView mTextMessage;
    CarouselView carouselView;
    ImageButton btn_week,idbtn_menu_berita,idbtn_menu_spesialis,btn_daftar,idbtn_menu_info,btn_day;


    int[] sampleImages = {R.drawable.jp1, R.drawable.jp2, R.drawable.jp3, R.drawable.jp4};



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HomeFragmentNav() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragmentNav.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragmentNav newInstance(String param1, String param2) {
        HomeFragmentNav fragment = new HomeFragmentNav();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_nav_home, container, false);
        mTextMessage = (TextView) rootView.findViewById(R.id.message);
        centerTitle();
        // Set title bar
        ((MainActivity) getActivity())
                .setActionBarTitle(getString(R.string.title_beranda));


        carouselView = rootView.findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);

        btn_day = (ImageButton) rootView.findViewById(R.id.idbtn_menu_hari_ini);
        btn_day_click();
        btn_week = (ImageButton) rootView.findViewById(R.id.idbtn_menu_minggu_ini);
        btn_week_click();
        idbtn_menu_berita = (ImageButton) rootView.findViewById(R.id.idbtn_menu_berita);
        idbtn_menu_berita_click();
        idbtn_menu_spesialis = (ImageButton) rootView.findViewById(R.id.idbtn_menu_spesialis);
        idbtn_menu_spesialis_click();
//        btn_daftar = (ImageButton) rootView.findViewById(R.id.btn_daftar);
//        btn_daftar_click();
        idbtn_menu_info = (ImageButton) rootView.findViewById(R.id.idbtn_menu_info);
        idbtn_menu_info_click();

        return rootView;
    }

    private void centerTitle() {
        ArrayList<View> textViews = new ArrayList<>();

        getActivity().getWindow().getDecorView().findViewsWithText(textViews, getActivity().getTitle(), View.FIND_VIEWS_WITH_TEXT);

        if(textViews.size() > 0) {
            AppCompatTextView appCompatTextView = null;
            if(textViews.size() == 1) {
                appCompatTextView = (AppCompatTextView) textViews.get(0);
            } else {
                for(View v : textViews) {
                    if(v.getParent() instanceof Toolbar) {
                        appCompatTextView = (AppCompatTextView) v;
                        break;
                    }
                }
            }

            if(appCompatTextView != null) {
                ViewGroup.LayoutParams params = appCompatTextView.getLayoutParams();
                params.width = ViewGroup.LayoutParams.MATCH_PARENT;
                appCompatTextView.setLayoutParams(params);
                appCompatTextView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            }
        }
    }

    public void btn_day_click(){
        btn_day.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                //   Intent i=new Intent(getApplicationContext(), viewinfoday.class);//target = nama class
                //     startActivity(i);

                MenuHariIniActivity fm =  new MenuHariIniActivity();

                Intent intent = new Intent(getActivity(), MenuHariIniActivity.class);
                startActivity(intent);


//                 FragmentTransaction fragmentTransaction = getActivity().beginTransaction();
//                      fragmentTransaction.replace(R.id.frameLayout,fm);
//                   fragmentTransaction.commit();

            }
        });

    }


    public void btn_week_click()
    {
        btn_week.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MingguanFragment fm =  new MingguanFragment();


                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,fm);
                fragmentTransaction.commit();
            }
        });
    }

    public void idbtn_menu_berita_click()
    {
        idbtn_menu_berita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsFragment fm =  new NewsFragment();


                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,fm);
                fragmentTransaction.commit();
            }
        });
    }

    public void idbtn_menu_spesialis_click()
    {
        idbtn_menu_spesialis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SpesialisFragment fm = new SpesialisFragment();


                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,fm);
                fragmentTransaction.commit();
            }
        });
    }

    public void btn_daftar_click()
    {
        btn_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PendaftaranFragmentNav fm = new PendaftaranFragmentNav();


                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,fm);
                fragmentTransaction.commit();
            }
        });
    }


    public void idbtn_menu_info_click()
    {
        idbtn_menu_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                infoFragment fm = new infoFragment();


                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,fm);
                fragmentTransaction.commit();

            }
        });
    }


    ImageListener imageListener = new ImageListener() {
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
        } else {
          //  throw new RuntimeException(context.toString()
           //         + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
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
