package com.wardrobeapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends Fragment {

    private View mStartView;

    public StartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mStartView= inflater.inflate(com.wardrobeapp.R.layout.fragment_start, container, false);
        getActivity().setTitle(getString(com.wardrobeapp.R.string.app_name));
        return mStartView;
    }

}
