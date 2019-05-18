package com.example.fabricwork;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.DrawableUtils;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private Context context;

    private ImageList[] imageList;

    public ImageAdapter(ImageList[] imageList) {
        this.context = context;
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int i) {
        final ImageList myimageList = imageList[i];
        viewHolder.imageView.setImageResource(imageList[i].getImgId());
        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


               // Toast.makeText(view.getContext(), "clciked", Toast.LENGTH_LONG).show();

                Uri imageUri =Uri.parse("android:resouce://com.example.fabricwork/drawable"+ R.drawable.titlea);
                Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                intent.setType("image/jpeg");
                //intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("/Users/prabalkar/AndroidStudioProjects/ud851-Sunshine-student/FabricWork/app/src/main/res/drawable/titlea.jpeg"));
                intent.setPackage("com.whatsapp");
                intent.putExtra(Intent.EXTRA_STREAM, imageUri);
                view.getContext().startActivity(Intent.createChooser(intent, "share Image"));


            }
        });
    }

    @Override
    public int getItemCount() {
        return imageList.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public RelativeLayout relativeLayout;
        public TextView share;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);
            share = itemView.findViewById(R.id.textView);
        }
    }
}
