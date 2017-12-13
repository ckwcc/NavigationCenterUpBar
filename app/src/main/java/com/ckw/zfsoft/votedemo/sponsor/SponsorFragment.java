package com.ckw.zfsoft.votedemo.sponsor;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ckw.zfsoft.votedemo.R;

/**
 * 发起的
 * A simple {@link Fragment} subclass.
 */
public class SponsorFragment extends Fragment {


    public SponsorFragment() {
        // Required empty public constructor
    }

    public static SponsorFragment newInstance() {

        Bundle args = new Bundle();

        SponsorFragment fragment = new SponsorFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sponsor, container, false);
    }

}
