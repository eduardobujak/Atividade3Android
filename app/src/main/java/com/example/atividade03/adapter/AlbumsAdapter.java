package com.example.atividade03.adapter;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atividade03.DetalheAlbumsActivity;
import com.example.atividade03.model.AlbumsClass;
import com.example.atividade03.R;
import java.util.List;


public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.TodoViewHolder> {
    private List<AlbumsClass> listaAlbums;
    private int layout;

    public class TodoViewHolder extends RecyclerView.ViewHolder {
        public View viewAlbums;
        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewAlbums = itemView;
        }
    }
    public AlbumsAdapter(List<AlbumsClass> albums, int layout) {
        this.listaAlbums = albums;
        this.layout = layout;
        if (this.layout == 0) {
            this.layout =  R.layout.layout_user;
        }
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(this.layout, parent, false);
        return new TodoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        if (this.listaAlbums.get(position) instanceof  AlbumsClass) {
            AlbumsClass obj = (AlbumsClass) this.listaAlbums.get(position);
            TextView tv;
            tv = holder.viewAlbums.findViewById(R.id.tvUserId);
            tv.setText(obj.getUserId()+"");
           // tv = holder.viewAlbums.findViewById(R.id.tvId);
           // tv.setText(obj.getId()+"");
            tv = holder.viewAlbums.findViewById(R.id.tvTitle);
            tv.setText(obj.getTitle()+"");


            if (layout == R.layout.layout_user) {
                tv = holder.viewAlbums.findViewById(R.id.tvUserId);
                tv = holder.viewAlbums.findViewById(R.id.tvId);
                tv = holder.viewAlbums.findViewById(R.id.tvTitle);
                CardView bt = holder.viewAlbums.findViewById(R.id.cardUser);
                bt.setTag(obj);
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CardView btn = (CardView) v;
                        AlbumsClass albums = (AlbumsClass) btn.getTag();

                        Intent intent = new Intent(holder.viewAlbums.getContext(), DetalheAlbumsActivity.class);

                        // adicional para incluir dados para a proxima activity
                        intent.putExtra("objAlbums", obj);
                        // lança intent para o SO chamar a activity
                        holder.viewAlbums.getContext().startActivity(intent);
                    }
                });
            }
        }


    }



    @Override
    public int getItemCount() {
        return this.listaAlbums.size();
    }
}
