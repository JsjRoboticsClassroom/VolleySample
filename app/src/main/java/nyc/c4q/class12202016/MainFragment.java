package nyc.c4q.class12202016;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


import nyc.c4q.class12202016.backend.HouseApi;
import nyc.c4q.class12202016.backend.HouseResponse;
import nyc.c4q.class12202016.helpers.Consumer;

public class MainFragment extends Fragment {
    private RequestQueue mRequestQueue;
    private RecyclerView mRecyclerView;
    private View mRoot;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mRequestQueue = Volley.newRequestQueue(getContext());
    }

    @Override
    public void onStart(){
        super.onStart();
        Consumer<HouseResponse> listener = buildDataReceiver();
        mRequestQueue.add(HouseApi.buildDataRequest(listener));
    }

    public Consumer<HouseResponse> buildDataReceiver(){
        return new Consumer<HouseResponse>() {
            @Override
            public void accept(HouseResponse data) {
                mRecyclerView.setAdapter(new HouseAdapter(data));
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            }
        };
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        mRoot = inflater.inflate(R.layout.fragment_main, parent, false);
        mRecyclerView = (RecyclerView) mRoot.findViewById(R.id.content);
        return mRoot;
    }
}
