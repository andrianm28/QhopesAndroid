package com.qtasnim.qhopes.navigation.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.qtasnim.qhopes.activities.MainActivity;
import com.qtasnim.qhopes.R;
import com.qtasnim.qhopes.adapters.ProfilAdapter;
import com.qtasnim.qhopes.model.profilpasienmodel;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfilNavFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfilNavFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfilNavFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<profilpasienmodel> mMenuHariinisData;
    ListView lv;
    private static ProfilAdapter adapter;
    TextView titleprofil;

    private OnFragmentInteractionListener mListener;

    public ProfilNavFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfilNavFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfilNavFragment newInstance(String param1, String param2) {
        ProfilNavFragment fragment = new ProfilNavFragment();
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                // Create new fragment and transaction
                Fragment newFragment = new HomeNavFragment();
                // consider using Java coding conventions (upper first char class names!!!)
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                transaction.replace(R.id.containerViewPager, newFragment);
                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =inflater.inflate(R.layout.fragment_nav_profil, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();

        // Set title bar
        ((MainActivity) getActivity())
                .setActionBarTitle(getString(R.string.title_profil));

        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lv=(ListView)rootView.findViewById(R.id.listprofil);
        titleprofil = (TextView) rootView.findViewById(R.id.title_dataprofil);
       titleprofil.setText("Nomor Rekam Medis");
        mMenuHariinisData= new ArrayList<>();

        mMenuHariinisData.add(new profilpasienmodel("Pasien 1", "112233"));
        mMenuHariinisData.add(new profilpasienmodel("Pasien 2", "223344"));
        mMenuHariinisData.add(new profilpasienmodel("Pasien 3", "441231"));


        adapter = new ProfilAdapter(mMenuHariinisData, rootView.getContext());

        lv.setAdapter(adapter);

        lv_profilonclick();
        return rootView;
    }

    public void lv_profilonclick()
    {

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                profilpasienmodel dataModel= mMenuHariinisData.get(position);
                String filennorekmedfrominfo =  (String) dataModel.getno_med_rec()+"";
                Snackbar.make(view, dataModel.getName()+"\n"+" No Rekam Medis : "+filennorekmedfrominfo, Snackbar.LENGTH_LONG)
                       .setAction("No action", null).show();
           //     Intent intent = new Intent(getActivity(),PendaftaranNavFragment.class);
           //     Bundle bundle = new Bundle();
             //   bundle.putString("datainfonorekmed", filennorekmedfrominfo);
             //   intent.putExtras(bundle);
//                startActivity(intent);

                 PendaftaranNavFragment fm = new PendaftaranNavFragment();



                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
               fragmentTransaction.replace(R.id.frameLayout,fm);
                 fragmentTransaction.commit();


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
          //          + " must implement OnFragmentInteractionListener");
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
