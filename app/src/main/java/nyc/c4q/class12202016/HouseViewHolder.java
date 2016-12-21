package nyc.c4q.class12202016;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nyc.c4q.class12202016.backend.House;

public class HouseViewHolder extends RecyclerView.ViewHolder {
    private final View mRoot;
    private final TextView mStyle;
    private final TextView mLocation;
    private final TextView mPrice;

    public HouseViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mRoot = itemView;
        mStyle = (TextView) mRoot.findViewById(R.id.style);
        mLocation = (TextView) mRoot.findViewById(R.id.location);
        mPrice = (TextView) mRoot.findViewById(R.id.price);
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.house_list_item, parent, false);
    }

    public void bind(House house) {
        mStyle.setText(house.getStyle());
        mLocation.setText(house.getLocation());
        mPrice.setText(house.getPrice());
    }
}
