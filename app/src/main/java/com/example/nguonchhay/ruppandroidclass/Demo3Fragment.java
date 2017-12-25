package com.example.nguonchhay.ruppandroidclass;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Demo3Fragment extends Fragment {
    private DemoFragmentCallBack callback;

    public Demo3Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_demo3, container, false);
        view.findViewById(R.id.btnFragmentNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onButtonPressed(3);
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DemoFragmentCallBack) {
            callback = (DemoFragmentCallBack) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        callback = null;
    }
}
