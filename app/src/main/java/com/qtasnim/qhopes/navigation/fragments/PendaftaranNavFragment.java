package com.qtasnim.qhopes.navigation.fragments;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.qtasnim.qhopes.R;
import com.qtasnim.qhopes.activities.MainActivity;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PendaftaranNavFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PendaftaranNavFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PendaftaranNavFragment extends Fragment {

    Dialog dialog;
    private OnFragmentInteractionListener mListener;

    public PendaftaranNavFragment() {
        // Required empty public constructor
    }

    public static PendaftaranNavFragment newInstance(String param1, String param2) {
        PendaftaranNavFragment fragment = new PendaftaranNavFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Set title bar
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
        ((MainActivity) getActivity())
                .setActionBarTitle(getString(R.string.title_pendaftaran));
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_nav_pendaftaran, container, false);
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
