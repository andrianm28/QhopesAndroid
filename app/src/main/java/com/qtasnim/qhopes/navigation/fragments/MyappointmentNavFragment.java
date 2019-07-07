package com.qtasnim.qhopes.navigation.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.qtasnim.qhopes.R;
import com.qtasnim.qhopes.activities.MainActivity;
import com.qtasnim.qhopes.fragments.UpcomingAppointmentFragment;

public class MyappointmentNavFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    public MyappointmentNavFragment() {
        // Required empty public constructor
    }

    public static MyappointmentNavFragment newInstance(String param1, String param2) {
        MyappointmentNavFragment fragment = new MyappointmentNavFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_nav_myappointment, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
        // Set title bar
        ((MainActivity) getActivity())
                .setActionBarTitle(getString(R.string.title_myappointment));

        ToggleButton mUpcoming = rootView.findViewById(R.id.btn_upcoming_appointment);

        mUpcoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpcomingAppointmentFragment fragment2 = new UpcomingAppointmentFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_appointment, fragment2);
                fragmentTransaction.commit();

            }
        });

        return rootView;
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
