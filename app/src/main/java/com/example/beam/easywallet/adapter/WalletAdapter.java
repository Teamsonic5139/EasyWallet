package com.example.beam.easywallet.adapter;

import com.example.beam.easywallet.model.Walllet;

import com.example.beam.easywallet.R;
import android.content.ContentValues;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;




/**
 * Created by Dell on 1/12/2560.
 */

public class WalletAdapter extends ArrayAdapter<Walllet> {

    private Context mContext;
    private ArrayList<Walllet> mWalletList;
    private int mLayoutResId;


    public WalletAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull ArrayList<Walllet> objects) {
        super(context, resource, objects);

        this.mContext = context;
        this.mLayoutResId = resource;
        this.mWalletList = objects;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemLayout = inflater.inflate(mLayoutResId, null);

        Walllet item = mWalletList.get(position);

        final ImageView walletImg = itemLayout.findViewById(R.id.image_view);
        final TextView walletName = itemLayout.findViewById(R.id.name_veiw);
        final TextView walletPrice = itemLayout.findViewById(R.id.price_view);

        walletName.setText(item.name);
        walletPrice.setText(item.price);


        String pictureFileName = item.image;
        AssetManager am = mContext.getAssets();
        try {
            InputStream stream = am.open(pictureFileName);
            Drawable drawable = Drawable.createFromStream(stream, null);
            walletImg.setImageDrawable(drawable);

        } catch (IOException e) {
            e.printStackTrace();
        }


        return itemLayout;
    }

}
///////////////////////////


