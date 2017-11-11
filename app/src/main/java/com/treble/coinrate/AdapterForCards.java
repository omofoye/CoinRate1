package com.treble.coinrate;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DAMILOLA on 11/2/2017.
 */

public class AdapterForCards extends RecyclerView.Adapter<AdapterForCards.ViewHolder> {
    private Activity mContext;
    private List<String> currenciesEx ;
    private String mCoinType;
    private int num;


    public AdapterForCards(Activity context,List<String> mCurrencies, String coinType){
        super();
        this.mContext = context;
        this.currenciesEx = mCurrencies;
        this.mCoinType = coinType;
    }

    @Override
    public int getItemCount() {
        if(currenciesEx.size() != 0){
         return    num = currenciesEx.size();
        }

        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView  cardTitle,convFig,   cardTxt;
        private ViewHolder(View v){
            super(v);
            cardTitle =  v.findViewById(R.id.card_title);
            convFig =  v.findViewById(R.id.conversion_fig);
            cardTxt =  v.findViewById(R.id.card_text);


        }
    }


    @Override
    public AdapterForCards.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listProvider = inflater.inflate(R.layout.conversion_card, parent, false);
        return new AdapterForCards.ViewHolder(listProvider);
    }

    @Override
    public void onBindViewHolder(AdapterForCards.ViewHolder holder, int position) {
        String getRate = currenciesEx.get(position);

        final List<String> currencyTypeA = new ArrayList<String>();

        currencyTypeA.add("USD");
        currencyTypeA.add("EUR");
        currencyTypeA.add("NGN");
        currencyTypeA.add("GBP");
        currencyTypeA.add("AED");
        currencyTypeA.add("SAR");
        currencyTypeA.add("JPY");
        currencyTypeA.add("INR");
        currencyTypeA.add("EGP");
        currencyTypeA.add("CNY");
        currencyTypeA.add("BRL");
        currencyTypeA.add("AUD");
        currencyTypeA.add("CAD");
        currencyTypeA.add("CHF");
        currencyTypeA.add("DKK");
        currencyTypeA.add("ISK");
        currencyTypeA.add("KES");
        currencyTypeA.add("QAR");
        currencyTypeA.add("SGD");
        currencyTypeA.add("ZAR");

        final List<String> currencyTxtB = new ArrayList<>();
        currencyTxtB.add("Dollars");
        currencyTxtB.add("Euros");
        currencyTxtB.add("Naira");
        currencyTxtB.add("Great Britain pounds");
        currencyTxtB.add("UAE dirham");
        currencyTxtB.add("Saudi Arabia Riyal");
        currencyTxtB.add("Japan Yen");
        currencyTxtB.add("Indian Rupee");
        currencyTxtB.add("Egypt pounds");
        currencyTxtB.add("China Yuan");
        currencyTxtB.add("Brazil Real");
        currencyTxtB.add("Australian dollars");
        currencyTxtB.add("Canada Dollar");
        currencyTxtB.add("Switzerland Francs");
        currencyTxtB.add("Denmark Krone");
        currencyTxtB.add("Iceland Krona");
        currencyTxtB.add("Kenya Shilling");
        currencyTxtB.add( "Qatar Riyal");
        currencyTxtB.add( "Singapore Dollar");
        currencyTxtB.add("South Africa Rand");




//       String you = currencyTypeA[position];
//       String rate = getRate;

        holder.cardTitle.setText("1 "+mCoinType+" - "+currencyTypeA.get(position));
        holder.convFig.setText(getRate);
        holder.cardTxt.setText("Click here for "+currencyTxtB.get(position)+" to "+mCoinType+" exchange rate");

    }



}
