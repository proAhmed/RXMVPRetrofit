package com.skook.skook.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.skook.skook.R;
import com.skook.skook.interfaces.AdapterClick;
import com.skook.skook.model.Offers;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ahmed shaban on 8/2/2017.
 */

public class MainOffersAdapter extends RecyclerView.Adapter<MainOffersAdapter.DataObjectHolder> {

    private List<Offers> offersList;
    private Context context;
    private static String LOG_TAG = "MyRecyclerViewAdapter";
    private AdapterClick adapterClick;

    static class DataObjectHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtMainLocation, txtLocationDetails, txtPrice, txtArea;
        ImageView imgOffers;
        ConstraintLayout conOffer;

        DataObjectHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtMainLocation = itemView.findViewById(R.id.txtMainLocation);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtArea = itemView.findViewById(R.id.txtArea);
            txtLocationDetails = itemView.findViewById(R.id.txtLocationDetails);
            imgOffers = itemView.findViewById(R.id.imgOffers);
            conOffer = itemView.findViewById(R.id.conOffer);
        }
    }

    public MainOffersAdapter(Activity context, ArrayList<Offers> offersList, AdapterClick adapterClick) {
        this.offersList = offersList;
        this.context = context;
        this.adapterClick = adapterClick;
    }


    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {


        View  view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.offers_main_items, parent, false);

        return new DataObjectHolder(view);
    }

    @Override
    public void onBindViewHolder(final DataObjectHolder holder, final int position) {


        holder.txtTitle.setText(offersList.get(position).getOffer_title());
        holder.txtMainLocation.setText(offersList.get(position).getRegion_title());
        holder.txtPrice.setText(offersList.get(position).getEdge() + "");
        holder.txtArea.setText(offersList.get(position).getDistance() + "");
        holder.txtLocationDetails.setText(offersList.get(position).getCity_title());
        Picasso.with(context).load(offersList.get(position).getImage()).fit().into(holder.imgOffers);
//        Picasso picasso = new Picasso.Builder(context)
//                .listener(new Picasso.Listener() {
//                    @Override
//                    public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception) {
//                        //Here your log
 //                    }
//                })
//                .build();
//        picasso.load(offersList.get(position).getImage())
//             //   .fit()
//                .into(holder.imgOffers);
         holder.conOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterClick.onClick(position);
            }
        });


    }

    @Override
    public int getItemCount() {
        return offersList.size();
    }
}



