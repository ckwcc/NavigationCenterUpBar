package com.ckw.zfsoft.votedemo.whole;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ckw.zfsoft.votedemo.R;

/**
 * 全部
 * A simple {@link Fragment} subclass.
 */
public class WholeFragment extends Fragment {


    public WholeFragment() {
        // Required empty public constructor
    }

    public static WholeFragment newInstance() {

        Bundle args = new Bundle();

        WholeFragment fragment = new WholeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_whole, container, false);
    }

}
