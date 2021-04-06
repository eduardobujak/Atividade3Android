package com.example.atividade03.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.atividade03.DetalheAlbumsActivity;
import com.example.atividade03.DetalhePostsActivity;
import com.example.atividade03.R;
import com.example.atividade03.model.PostsClass;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.TodoViewHolder> {
    private List<PostsClass> listaPosts;
    private int layout;

    public class TodoViewHolder extends RecyclerView.ViewHolder {
        public View viewPosts;
        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewPosts = itemView;
        }
    }
    public PostsAdapter(List<PostsClass> posts, int layout) {
        this.listaPosts = posts;
        this.layout = layout;
        if (this.layout == 0) {
            this.layout =  R.layout.layout_user;
        }
    }

    @NonNull
    @Override
    public PostsAdapter.TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(this.layout, parent, false);
        return new TodoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapter.TodoViewHolder holder, int position) {
        if (this.listaPosts.get(position) instanceof  PostsClass) {
            PostsClass obj = (PostsClass) this.listaPosts.get(position);
            TextView tv;
            tv = holder.viewPosts.findViewById(R.id.tvUserId);
            tv.setText(obj.getUserId()+"");
           // tv = holder.viewPosts.findViewById(R.id.tvId);
            //tv.setText(obj.getId()+"");
            tv = holder.viewPosts.findViewById(R.id.tvTitle);
            tv.setText(obj.getTitle()+"");
           // tv = holder.viewPosts.findViewById(R.id.tvBody);
           // tv.setText(obj.getTitle()+"");


            if (layout == R.layout.layout_user) {
                tv = holder.viewPosts.findViewById(R.id.tvUserId);
               tv = holder.viewPosts.findViewById(R.id.tvId);
                tv = holder.viewPosts.findViewById(R.id.tvTitle);
               tv = holder.viewPosts.findViewById(R.id.tvBody);
                CardView bt = holder.viewPosts.findViewById(R.id.cardUser);
                bt.setTag(obj);
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CardView btn = (CardView) v;
                        PostsClass posts = (PostsClass) btn.getTag();

                        Intent intent = new Intent(holder.viewPosts.getContext(), DetalhePostsActivity.class);

                        // adicional para incluir dados para a proxima activity
                        intent.putExtra("objPosts", obj);
                        // lança intent para o SO chamar a activity
                        holder.viewPosts.getContext().startActivity(intent);
                    }
                });
            }
        }


    }



    @Override
    public int getItemCount() {
        return this.listaPosts.size();
    }
}

