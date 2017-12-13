package com.ckw.zfsoft.votedemo.participant;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ckw.zfsoft.votedemo.R;

/**
 * 参与的
 * A simple {@link Fragment} subclass.
 */
public class ParticipantFragment extends Fragment {


    public ParticipantFragment() {
        // Required empty public constructor
    }

    public static ParticipantFragment newInstance() {

        Bundle args = new Bundle();

        ParticipantFragment fragment = new ParticipantFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_participant, container, false);
    }

}
