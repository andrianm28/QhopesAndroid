package com.simrs.qt.simrs;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import android.widget.ListView;
import android.widget.TextView;

import com.simrs.qt.simrs.adapters.MenuHariiniAdapter;
import com.simrs.qt.simrs.adapters.MenuHariiniAdapter2;
import com.simrs.qt.simrs.model.MenuHariiniModel;

import java.util.ArrayList;
import java.util.Collections;


public class MenuHariIniActivity extends AppCompatActivity {

    // Member variables.
    private RecyclerView mRecyclerView;
    private ArrayList<MenuHariiniModel> mMenuHariinisData = new ArrayList<MenuHariiniModel>();
    private MenuHariiniAdapter2 mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_hariini);

        // Initialize the RecyclerView.
        mRecyclerView = findViewById(R.id.recycler_menu_hariini);

        // Set the Layout Manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the ArrayList that will contain the data.
        mMenuHariinisData = new ArrayList<>();

        // Initialize the adapter and set it to the RecyclerView.
        mAdapter = new MenuHariiniAdapter2(this, mMenuHariinisData);
        mRecyclerView.setAdapter(mAdapter);

        // Get the data.
        initializeData();

        // Helper class for creating swipe to dismiss and drag and drop
        // functionality.
        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper
                .SimpleCallback(
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT |
                        ItemTouchHelper.DOWN | ItemTouchHelper.UP,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            /**
             * Defines the drag and drop functionality.
             *
             * @param recyclerView The RecyclerView that contains the list items
             * @param viewHolder The SportsViewHolder that is being moved
             * @param target The SportsViewHolder that you are switching the
             *               original one with.
             * @return true if the item was moved, false otherwise
             */
            @Override
            public boolean onMove(RecyclerView recyclerView,
                                  RecyclerView.ViewHolder viewHolder,
                                  RecyclerView.ViewHolder target) {
                // Get the from and to positions.
                int from = viewHolder.getAdapterPosition();
                int to = target.getAdapterPosition();

                // Swap the items and notify the adapter.
                Collections.swap(mMenuHariinisData, from, to);
                mAdapter.notifyItemMoved(from, to);
                return true;
            }

            /**
             * Defines the swipe to dismiss functionality.
             *
             * @param viewHolder The viewholder being swiped.
             * @param direction The direction it is swiped in.
             */
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder,
                                 int direction) {
                // Remove the item from the dataset.
                mMenuHariinisData.remove(viewHolder.getAdapterPosition());
                // Notify the adapter.
                mAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        });

        // Attach the helper to the RecyclerView.
        helper.attachToRecyclerView(mRecyclerView);
    }

    /**
     * Initialize the sports data from resources.
     */
    private void initializeData(){

        mMenuHariinisData.add(new MenuHariiniModel("Dr. A", "Gigi", "07:00","September 23, 2008"));
        mMenuHariinisData.add(new MenuHariiniModel("Dr. B", "Polianak", "08:00","February 9, 2009"));
        mMenuHariinisData.add(new MenuHariiniModel("Dr. C", "SP 3", "09:00","April 27, 2009"));
        mMenuHariinisData.add(new MenuHariiniModel("Dr. D", "Sp 4", "10:00","October 26, 2009"));
        mMenuHariinisData.add(new MenuHariiniModel("Dr. E", "sp 5", "11:00","May 20, 2010"));
        mMenuHariinisData.add(new MenuHariiniModel("Dr. F", "sp 6", "12:00","December 6, 2010"));
        mAdapter = new MenuHariiniAdapter2(mRecyclerView.getContext(), mMenuHariinisData);

        // Notify the adapter of the change.
        mAdapter.notifyDataSetChanged();
    }

    /**
     * onClick method for th FAB that resets the data.
     *
     * @param view The button view that was clicked.
     */
    public void resetSports(View view) {
        initializeData();
    }
//
//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//    ArrayList<MenuHariiniModel> mMenuHariinisData;
//    ListView lv;
//    TextView titletodayinfo;
//    private static MenuHariiniAdapter adapter;
//
//    private OnFragmentInteractionListener mListener;
//
//    public MenuHariIniActivity() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment MenuHariIniActivity.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static MenuHariIniActivity newInstance(String param1, String param2) {
//        MenuHariIniActivity fragment = new MenuHariIniActivity();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View rootView =inflater.inflate(R.layout.fragment_menu_hariini, container, false);
//        // Set title bar
//        ((MainActivity) getActivity())
//                .setActionBarTitle(getString(R.string.title_menu_hariini));
////        lv=(ListView)rootView.findViewById(R.id.listday);
//        titletodayinfo = (TextView) rootView.findViewById(R.id.titledayinfo);
//        titletodayinfo.setText("Jadwal Hari Ini");
//        mMenuHariinisData = new ArrayList<>();
//
//        mMenuHariinisData.add(new MenuHariiniModel("Dr. A", "Gigi", "07:00","September 23, 2008"));
//        mMenuHariinisData.add(new MenuHariiniModel("Dr. B", "Polianak", "08:00","February 9, 2009"));
//        mMenuHariinisData.add(new MenuHariiniModel("Dr. C", "SP 3", "09:00","April 27, 2009"));
//        mMenuHariinisData.add(new MenuHariiniModel("Dr. D", "Sp 4", "10:00","October 26, 2009"));
//        mMenuHariinisData.add(new MenuHariiniModel("Dr. E", "sp 5", "11:00","May 20, 2010"));
//        mMenuHariinisData.add(new MenuHariiniModel("Dr. F", "sp 6", "12:00","December 6, 2010"));
//
//
//        adapter= new MenuHariiniAdapter(mMenuHariinisData, rootView.getContext());
//
//        lv.setAdapter(adapter);
//
//        lv_onclick();
//        return rootView;
//    }
//
//    public void lv_onclick()
//    {
//
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                MenuHariiniModel dataModel= mMenuHariinisData.get(position);
//
//                Snackbar.make(view, dataModel.getNama_dokter()+
//                        "\n"+dataModel.getNama_poliklinik()+
//                        " API: "+dataModel.getJam_praktek(), Snackbar.LENGTH_LONG)
//                        .setAction("No action", null).show();
//            }
//        });
//    }
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//         //   throw new RuntimeException(context.toString()
//        //            + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
