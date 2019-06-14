package com.simrs.qt.simrs;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import android.widget.ListView;
import android.widget.TextView;

import com.simrs.qt.simrs.adapters.dayadapter;
import com.simrs.qt.simrs.model.daymodel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MenuHariIniFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MenuHariIniFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuHariIniFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ArrayList<daymodel> dm;
    ListView lv;
    TextView titletodayinfo;
    private static dayadapter adapter;

    private OnFragmentInteractionListener mListener;

    public MenuHariIniFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuHariIniFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuHariIniFragment newInstance(String param1, String param2) {
        MenuHariIniFragment fragment = new MenuHariIniFragment();
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
        View rootView =inflater.inflate(R.layout.fragment_viewinfotoday, container, false);
        // Set title bar
        ((MainActivity) getActivity())
                .setActionBarTitle(getString(R.string.title_menu_hariini));
        lv=(ListView)rootView.findViewById(R.id.listday);
        titletodayinfo = (TextView) rootView.findViewById(R.id.titledayinfo);
        titletodayinfo.setText("Jadwal Hari Ini");
        dm= new ArrayList<>();

        dm.add(new daymodel("Dr. A", "Gigi", "07:00","September 23, 2008"));
        dm.add(new daymodel("Dr. B", "Polianak", "08:00","February 9, 2009"));
        dm.add(new daymodel("Dr. C", "SP 3", "09:00","April 27, 2009"));
        dm.add(new daymodel("Dr. D", "Sp 4", "10:00","October 26, 2009"));
        dm.add(new daymodel("Dr. E", "sp 5", "11:00","May 20, 2010"));
        dm.add(new daymodel("Dr. F", "sp 6", "12:00","December 6, 2010"));


        adapter= new dayadapter(dm,rootView.getContext());

        lv.setAdapter(adapter);

        lv_onclick();
        return rootView;
    }

    public void lv_onclick()
    {

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                daymodel dataModel= dm.get(position);

                Snackbar.make(view, dataModel.getName()+"\n"+dataModel.getspesialis()+" API: "+dataModel.getJam(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }
        });
    }
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
         //   throw new RuntimeException(context.toString()
        //            + " must implement OnFragmentInteractionListener");
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
