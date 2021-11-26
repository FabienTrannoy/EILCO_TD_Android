package com.example.tp5;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private final List<Contact> mContacts;

    public ContactAdapter(List<Contact> contacts){
        mContacts = contacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_contact, parent, false);

        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Contact contact = mContacts.get(position);

        TextView firstNameTextView = holder.firstNameTextView;
        firstNameTextView.setText(contact.getPrenom());

        TextView lastNameTextView = holder.lastNameTextView;
        lastNameTextView.setText(contact.getNom());

        ImageView imageView = holder.imageView;
        String url = contact.getImageURL();

        Glide
                .with(imageView)
                .load(url)
                .centerCrop()
                .into(imageView);
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView firstNameTextView;
        public TextView lastNameTextView;
        public ImageView imageView;

        public ViewHolder(View itemView){
            super(itemView);

            firstNameTextView = itemView.findViewById(R.id.textView_prenom);
            lastNameTextView = (TextView) itemView.findViewById(R.id.textView_nom);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
