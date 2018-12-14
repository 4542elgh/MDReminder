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
        TextView inactiveIngredient;
        TextView warnings;
        TextView whenUsing;
        TextView productNdc;
        TextView prodType;
        TextView route;
        TextView packageNdc;
        TextView brand_name;
        TextView dosageAndAdministration;
        TextView pregnancyOrBreastFeeding;
        TextView stop_use;
        TextView do_not_use;
        TextView indicationsAndUsage;
        TextView activeIngredient;

        public MDItemViewHolder(View itemView) { //grab item from view into this Holder
            super(itemView);
//            inactiveIngredient = (TextView) itemView.findViewById(R.id.inactiveIngredient);
            warnings = (TextView) itemView.findViewById(R.id.warnings);
            whenUsing = (TextView) itemView.findViewById(R.id.whenUsing);
            productNdc = (TextView) itemView.findViewById(R.id.productNdc);
//            prodType = (TextView) itemView.findViewById(R.id.prodType);
//            route = (TextView) itemView.findViewById(R.id.route);
//            packageNdc = (TextView) itemView.findViewById(R.id.packageNdc);
            brand_name = (TextView) itemView.findViewById(R.id.brand_name);
            dosageAndAdministration = (TextView) itemView.findViewById(R.id.dosageAndAdministration);
//            pregnancyOrBreastFeeding = (TextView) itemView.findViewById(R.id.pregnancyOrBreastFeeding);
//            stop_use = (TextView) itemView.findViewById(R.id.stop_use);
            do_not_use = (TextView) itemView.findViewById(R.id.do_not_use);
//            indicationsAndUsage = (TextView) itemView.findViewById(R.id.indicationsAndUsage);
//            activeIngredient = (TextView) itemView.findViewById(R.id.activeIngredient);
        }

        void bind(final int listIndex) {

//            inactiveIngredient.setText("Inactive Ingredient: "+listDrugs.get(listIndex).getInactiveIngredient());
            warnings.setText("Warnings: "+listDrugs.get(listIndex).getWarnings());
            whenUsing.setText("When Using: "+listDrugs.get(listIndex).getWhenUsing());
            productNdc.setText("Product NDC: "+listDrugs.get(listIndex).getProductNdc());
//            prodType.setText("Product Type: "+listDrugs.get(listIndex).getProdType());
//            route.setText("Route: "+listDrugs.get(listIndex).getRoute());
//            packageNdc.setText("Package NDC: "+listDrugs.get(listIndex).getPackageNdc());
            brand_name.setText("Brand Name: "+listDrugs.get(listIndex).getBrand_name());
            dosageAndAdministration.setText("Dosage and Administration: "+listDrugs.get(listIndex).getDosageAndAdministration());
//            pregnancyOrBreastFeeding.setText("Pregnancy or Breast Feeding: "+listDrugs.get(listIndex).getPregnancyOrBreastFeeding());
//            stop_use.setText("Stop Use: "+listDrugs.get(listIndex).getStop_use());
            do_not_use.setText("Do Not Use: "+listDrugs.get(listIndex).getDo_not_use());
//            indicationsAndUsage.setText("Indications and Usage: "+listDrugs.get(listIndex).getIndicationsAndUsage());
//            activeIngredient.setText("Active Ingredient: "+listDrugs.get(listIndex).getActiveIngredient());

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