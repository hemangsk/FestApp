package xyz.hemangkumar.infox.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import xyz.hemangkumar.infox.EventActivity;
import xyz.hemangkumar.infox.R;
import xyz.hemangkumar.infox.adapters.EventAdapter;
import xyz.hemangkumar.infox.models.Event;

public class AboutFragment extends Fragment {
    private static final boolean GRID_LAYOUT = false;
    public static ArrayList<Event> dataList = new ArrayList<>();
    public static EventAdapter eventAdapter;
    RecyclerView recyclerView;
    public AboutFragment() {
        // Required empty public constructor
    }

    public static AboutFragment newInstance() {
        AboutFragment fragment = new AboutFragment();

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
        return inflater.inflate(R.layout.fragment_about, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager;

        if(GRID_LAYOUT == true){
            layoutManager = new GridLayoutManager(getActivity(), 2);
        }
        else{
            layoutManager = new LinearLayoutManager(getActivity());
        }

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        recyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        Context ctx = getActivity();
        Log.e("ResultValue ", "Here");
        SharedPreferences sharedPreferences = ctx.getSharedPreferences("Source", Context.MODE_PRIVATE);
        String res= "";
                res = sharedPreferences.getString("Events", "");
        Log.e("ResultValue ", res.toString());
        Log.e("ResultValue ", "And");
        if(res.equals("")){
            Log.e("Res is null", "Yo");
            final String url = "https://raw.githubusercontent.com/hemangsk/json_endpoints/master/test.json";
            new AsyncHttpTask().execute(url);
        }

        else{
            try {
                Log.e("Res is not null, ", String.valueOf(res.length()));

        Log.e("Now", res.toString());

               JSONArray jsonArray = new JSONArray(res);
                Log.e("CEHC", jsonArray.toString());
                ArrayList<Event> events = Event.fromJson(jsonArray, new ArrayList<Event>());

                Event.setData(events);








                eventAdapter = new EventAdapter(getActivity(), events);
                eventAdapter.setOnItemClickListener(new EventAdapter.ClickListener() {
                    @Override
                    public void onItemClick(int position, View v) {
                        Intent intent = new Intent(getActivity(), EventActivity.class);
                        intent.putExtra("POS", position);
                        startActivity(intent);
                    }

                    @Override
                    public void onItemLongClick(int position, View v) {

                    }
                });
                recyclerView.setAdapter(eventAdapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }




    }


    public class AsyncHttpTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... params) {
            Integer result = 0;
            String res ="";
            HttpURLConnection urlConnection;
            try {
                URL url = new URL(params[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                int statusCode = urlConnection.getResponseCode();

                // 200 represents HTTP OK
                if (statusCode == 200) {
                    BufferedReader r = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = r.readLine()) != null) {
                        response.append(line);
                    }
                    //parseResult(response.toString());
                    res = response.toString();
                    result = 1; // Successful
                } else {
                    result = 0; //"Failed to fetch data!";
                }
            } catch (Exception e) {
               e.printStackTrace();
            }
            return res; //"Failed to fetch data!";
        }

        @Override
        protected void onPostExecute(String s) {
            // Download complete. Let us update UI
            Log.e("RESULT", String.valueOf(s.length()));

            JSONArray jsonArray = null;
            try {
                s = s.replace("\\\"", "\"");
                Context ctx = getActivity();
                SharedPreferences sharedPreferences = ctx.getSharedPreferences("Source", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                Log.e("Putting", String.valueOf(s.length()));
                editor.putString("Events",s);
                editor.commit();

                Log.e("CHECK", s);
                jsonArray = new JSONArray(s);
                Log.e("CEHC", jsonArray.toString());
                ArrayList<Event> events = Event.fromJson(jsonArray, new ArrayList<Event>());

                Event.setData(events);








            eventAdapter = new EventAdapter(getActivity(), events);
            eventAdapter.setOnItemClickListener(new EventAdapter.ClickListener() {
                @Override
                public void onItemClick(int position, View v) {
                    Intent intent = new Intent(getActivity(), EventActivity.class);
                    intent.putExtra("POS", position);
                    startActivity(intent);
                }

                @Override
                public void onItemLongClick(int position, View v) {

                }
            });
            recyclerView.setAdapter(eventAdapter);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


}

