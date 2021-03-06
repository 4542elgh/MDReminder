package com.example.herr.MDReader;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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

        View view = inflater.inflate(R.layout.cardview_item, parent, shouldAttachToParentImmediately);
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
        ImageView imageView;
        ImageView packageView;
        public MDItemViewHolder(View itemView) { //grab item from view into this Holder
            super(itemView);


//            ((ImageView)view).setImageBitmap(BitmapFactory.decodeFile("/data/data/com.myapp/files/someimage.jpg"));
            inactiveIngredient = (TextView) itemView.findViewById(R.id.inactiveIngredient);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            packageView = (ImageView) itemView.findViewById(R.id.packageView);
            inactiveIngredient = (TextView) itemView.findViewById(R.id.inactiveIngredient);
            warnings = (TextView) itemView.findViewById(R.id.warnings);
            whenUsing = (TextView) itemView.findViewById(R.id.whenUsing);
            productNdc = (TextView) itemView.findViewById(R.id.productNdc);
            prodType = (TextView) itemView.findViewById(R.id.prodType);
            route = (TextView) itemView.findViewById(R.id.route);
            packageNdc = (TextView) itemView.findViewById(R.id.packageNdc);
            brand_name = (TextView) itemView.findViewById(R.id.brand_name);
            dosageAndAdministration = (TextView) itemView.findViewById(R.id.dosageAndAdministration);
            pregnancyOrBreastFeeding = (TextView) itemView.findViewById(R.id.pregnancyOrBreastFeeding);
            stop_use = (TextView) itemView.findViewById(R.id.stop_use);
            do_not_use = (TextView) itemView.findViewById(R.id.do_not_use);
            indicationsAndUsage = (TextView) itemView.findViewById(R.id.indicationsAndUsage);
            activeIngredient = (TextView) itemView.findViewById(R.id.activeIngredient);
        }

        // TODO: get ndc image show
        void bind(final int listIndex) {
            packageView.setImageResource(0);
            String drawableName = listDrugs.get(listIndex).getProductNdc();
            drawableName = "a"+ drawableName;
            drawableName = drawableName.replace('-','a'); // e.g. output: a000a000
            Log.d("i am getting called", drawableName);

            int drawableId = instance.getResources().getIdentifier(drawableName,"drawable", instance.getPackageName());
            if (drawableId != 0) {
                Log.d("i am getting called","");
                Picasso.get().load(instance.getResources().getIdentifier(drawableName,"drawable", instance.getPackageName())).into(packageView);

            }


            String urlString =  "https://api.qrserver.com/v1/create-qr-code/?size=150x150&data="
                    + "https%3A%2F%2Fapi.fda.gov%2Fdrug%2Fndc.json%3Fsearch%3Dproduct_ndc%3A";

                    try {
                        urlString+=URLEncoder.encode(listDrugs.get(listIndex).getProductNdc(), "UTF-8");
                    }
                    catch (UnsupportedEncodingException e){
                        e.printStackTrace();
                    }
            //Picasso.with(this).load(urlString).into(imageView);
            Picasso.get().load(urlString).into(imageView);
            inactiveIngredient.setText("Inactive Ingredient: "+listDrugs.get(listIndex).getInactiveIngredient());
            warnings.setText("Warnings: "+listDrugs.get(listIndex).getWarnings());
            whenUsing.setText("When Using: "+listDrugs.get(listIndex).getWhenUsing());
            productNdc.setText("Product NDC: "+listDrugs.get(listIndex).getProductNdc());
            prodType.setText("Product Type: "+listDrugs.get(listIndex).getProdType());
            route.setText("Route: "+listDrugs.get(listIndex).getRoute());
            packageNdc.setText("Package NDC: "+listDrugs.get(listIndex).getPackageNdc());
            brand_name.setText(listDrugs.get(listIndex).getBrand_name());
            dosageAndAdministration.setText("Dosage and Administration: "+listDrugs.get(listIndex).getDosageAndAdministration());
            pregnancyOrBreastFeeding.setText("Pregnancy or Breast Feeding: "+listDrugs.get(listIndex).getPregnancyOrBreastFeeding());
            stop_use.setText("Stop Use: "+listDrugs.get(listIndex).getStop_use());
            do_not_use.setText("Do Not Use: "+listDrugs.get(listIndex).getDo_not_use());
            indicationsAndUsage.setText("Indications and Usage: "+listDrugs.get(listIndex).getIndicationsAndUsage());
            activeIngredient.setText("Active Ingredient: "+listDrugs.get(listIndex).getActiveIngredient());

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
                     /*intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
                    intent.putExtra("urlString", urlString);
                    intent.setPackage("com.android.chrome");
                    instance.startActivity(intent);*/
//                }
//            });

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