package com.example.my.a06;

import android.app.Activity; //[Comment] Unused imports
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.my.a06.R;
import com.squareup.picasso.Picasso;

//[Comment] Different image sizes
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private static Context sContext; //[Comment] why context is static? It's wrong


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageButton mImageButton; //[Comment] Wrong visibility modifier

        public ViewHolder(View v) {
            super(v);

            mImageButton = (ImageButton) v.findViewById(R.id.ib_recycler_item);
            mImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast toast = Toast.makeText(sContext,
                            "ImageButton", Toast.LENGTH_SHORT); //[Comment] Hardcode
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            });
        }

    }


    public RecyclerAdapter(Context context) {
        this.sContext=context; //[Comment] Unnecessary this
        //[Comment] Formatting
    }


    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);


        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if (position==0) {
            Picasso.with(sContext).load("file:///android_asset/picasso1.png").fit().into(holder.mImageButton);
        } else if (position==1){
            Picasso.with(sContext).load("file:///android_asset/picasso2.png").fit().into(holder.mImageButton); //[Comment] BAD. Use arrays for recyclerview contents
        }

    }

    @Override
    public int getItemCount() {
        return 2; //[Comment] Hardcode. Use array
    }
}