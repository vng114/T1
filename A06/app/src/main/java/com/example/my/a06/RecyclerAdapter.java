package com.example.my.a06;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    String[] mImageLibrary={"file:///android_asset/picasso1.png",
            "file:///android_asset/picasso2.png"};

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageItem;
        Context mContextMainActivity;

        public ViewHolder(View v, final Context parentContext) {
            super(v);

            mContextMainActivity=parentContext;
            mImageItem = (ImageView) v.findViewById(R.id.image_item_recycler);

            mImageItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast toast = Toast.makeText(mContextMainActivity,
                            v.getClass().getSimpleName().substring(MainActivity.NAME_CLASS_ADD), Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            });
        }
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);


        ViewHolder vh = new ViewHolder(v,parent.getContext());
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Picasso.with(holder.mContextMainActivity).load(mImageLibrary[position]).fit().into(holder.mImageItem);
    }

    @Override
    public int getItemCount() {

        return mImageLibrary.length;
    }
}