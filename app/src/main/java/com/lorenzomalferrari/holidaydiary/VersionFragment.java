package com.lorenzomalferrari.holidaydiary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 *
 * @author Lorenzo Malferrari
 * My Website: www.lorenzomalferrari.com
 * My profile on GitHub: https://github.com/lorenzomalferrari
 * A simple {@link VersionFragment} subclass.
 */
public class VersionFragment extends Fragment {


    public VersionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_version, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Version");
    }

}
