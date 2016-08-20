package xyz.hemangkumar.infox.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;

import xyz.hemangkumar.infox.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainAboutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainAboutFragment extends Fragment {


    public MainAboutFragment() {
        // Required empty public constructor
    }

     public static MainAboutFragment newInstance() {
        MainAboutFragment fragment = new MainAboutFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_about, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ObservableScrollView observableScrollView = (ObservableScrollView) view.findViewById(R.id.scrollView);
        MaterialViewPagerHelper.registerScrollView(getActivity(), observableScrollView, null);
         CardView cardView = (CardView) view.findViewById(R.id.card_view);

      
    }

}
