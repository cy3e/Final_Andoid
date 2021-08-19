package com.example.me_net;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleviewAdapter extends RecyclerView.Adapter<RecycleviewAdapter.ViewHolder>
{

    private ViewGroup parent;
    private int viewType;

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView usuario,caption;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            usuario = (TextView)itemView.findViewById(R.id.user);
            caption = (TextView)itemView.findViewById(R.id.capti);
            img = (ImageView)itemView.findViewById(R.id.meme);
        }
    }

    public List<data> datalist;

    public RecycleviewAdapter(List<data> datalist) {
        this.datalist = datalist;
    }

    public ViewHolder onCreateViewHolder() {
        return onCreateViewHolder();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType)
    {
        this.parent = parent;
        viewType = ViewType;
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.posts,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.usuario.setText(datalist.get(position).getUsuario());
        holder.caption.setText(datalist.get(position).getCapt());
        holder.img.setImageResource(datalist.get(position).getImgs());
    }

    @Override
    public int getItemCount()
    {
        return datalist.size();
    }
}
