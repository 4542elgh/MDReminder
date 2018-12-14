package com.example.herr.MDReader;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class MDRecyclerViewAdapter extends RecyclerView.Adapter<MDRecyclerViewAdapter.MDItemViewHolder> {

    Context instance; //referencing instance, so this adapter know what app was doing
    Intent intent = null;
    ArrayList<Drug> listDrugs; //new arraylist of newsitem from async task

    public MDRecyclerViewAdapter(Context context, ArrayList<Drug> listDrugs){ //constructor
        this.instance = context;
        this.listDrugs = listDrugs;
    }

    @Override
    public MDRecyclerViewAdapter.MDItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(R.layout.recycler_view_item, parent, shouldAttachToParentImmediately);
        MDItemViewHolder viewHolder = new MDItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MDRecyclerViewAdapter.MDItemViewHolder holder, int position) { //bind new's 3 attributes and onclick listener for that item, then intent a webview
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return listDrugs.size();
    }

    public class MDItemViewHolder extends RecyclerView.ViewHolder{ //text items for the POJO
        TextView title;
        TextView description;
        TextView date;

        public MDItemViewHolder(View itemView) { //grab item from view into this Holder
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            date = (TextView) itemView.findViewById(R.id.date);
        }

        void bind(final int listIndex) {
            //bind 3 newsItem attribute to this newsHolder
            title.setText("Title: "+listDrugs.get(listIndex).getPackageNdc() );
            description.setText("Description: "+listDrugs.get(listIndex).getBrand_name());
            date.setText("Date: "+listDrugs.get(listIndex).getRoute() );

            //binding click listener
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    String urlString = listDrugs.get(listIndex).getUrl(); //get url
//                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString)); //fire a new intent
////                    intent = new Intent(instance, WebActivity.class); //fire a new intent
//                    intent.putExtra("urlString", urlString); //push the url to webview
//                    instance.startActivity(intent); //redirect to new view
//                }
//            });
        }
    }
}