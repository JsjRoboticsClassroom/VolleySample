package nyc.c4q.class12202016;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.class12202016.backend.House;
import nyc.c4q.class12202016.backend.HouseResponse;

public class HouseAdapter extends RecyclerView.Adapter<HouseViewHolder> {
    private final List<House> mData;

    public HouseAdapter(HouseResponse data) {
        mData = data.getHouses();
    }

    @Override
    public HouseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HouseViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(HouseViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
