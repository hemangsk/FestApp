package xyz.hemangkumar.infox.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.florent37.materialviewpager.MaterialViewPagerHelper;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;

import java.util.ArrayList;

import xyz.hemangkumar.infox.R;
import xyz.hemangkumar.infox.models.Event;


public class AboutEvent extends Fragment {
    private ArrayList<Event> events;
    private int position;

    public AboutEvent() {
        // Required empty public constructor
    }

    public static AboutEvent newInstance(ArrayList<Event> data,int pos) {
        AboutEvent fragment = new AboutEvent();
        fragment.events = data;
        fragment.position = pos;
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
        return inflater.inflate(R.layout.fragment_about_event, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ObservableScrollView observableScrollView = (ObservableScrollView) view.findViewById(R.id.scrollView);
        MaterialViewPagerHelper.registerScrollView(getActivity(), observableScrollView, null);
        CardView cardView = (CardView) view.findViewById(R.id.card_view);

        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(events.get(position).getAbout());
    }


}
