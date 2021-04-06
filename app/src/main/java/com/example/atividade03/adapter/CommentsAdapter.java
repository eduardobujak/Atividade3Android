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
import com.example.atividade03.DetalheCommentsActivity;
import com.example.atividade03.DetalhePostsActivity;
import com.example.atividade03.R;
import com.example.atividade03.model.CommentsClass;
import com.example.atividade03.model.PostsClass;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.TodoViewHolder> {
    private List<CommentsClass> listaComments;
    private int layout;

    public class TodoViewHolder extends RecyclerView.ViewHolder {
        public View viewComments;
        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);
            this.viewComments = itemView;
        }
    }
    public CommentsAdapter(List<CommentsClass> comments, int layout) {
        this.listaComments = comments;
        this.layout = layout;
        if (this.layout == 0) {
            this.layout =  R.layout.layout_user;
        }
    }

    @NonNull
    @Override
    public CommentsAdapter.TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(this.layout, parent, false);
        return new TodoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsAdapter.TodoViewHolder holder, int position) {
        if (this.listaComments.get(position) instanceof  CommentsClass) {
            CommentsClass obj = (CommentsClass) this.listaComments.get(position);
            TextView tv;
            tv = holder.viewComments.findViewById(R.id.tvUserId);
            tv.setText(obj.getPostId()+"");
           // tv = holder.viewComments.findViewById(R.id.tvId);
           // tv.setText(obj.getId()+"");
            tv = holder.viewComments.findViewById(R.id.tvTitle);
            tv.setText(obj.getName()+"");
           // tv = holder.viewComments.findViewById(R.id.tvEmail);
          // tv.setText(obj.getEmail()+"");
           // tv = holder.viewComments.findViewById(R.id.tvBody);
         //  tv.setText(obj.getBody()+"");


            if (layout == R.layout.layout_user) {
                tv = holder.viewComments.findViewById(R.id.tvPostId);
                  tv = holder.viewComments.findViewById(R.id.tvId);
                tv = holder.viewComments.findViewById(R.id.tvTitle);
                tv = holder.viewComments.findViewById(R.id.tvEmail);
                 tv = holder.viewComments.findViewById(R.id.tvBody);
                CardView bt = holder.viewComments.findViewById(R.id.cardUser);
                bt.setTag(obj);
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        CardView btn = (CardView) v;
                        CommentsClass comments = (CommentsClass) btn.getTag();

                        Intent intent = new Intent(holder.viewComments.getContext(), DetalheCommentsActivity.class);

                        // adicional para incluir dados para a proxima activity
                        intent.putExtra("objComments", obj);
                        // lança intent para o SO chamar a activity
                        holder.viewComments.getContext().startActivity(intent);
                    }
                });
            }
        }


    }



    @Override
    public int getItemCount() {
        return this.listaComments.size();
    }
}

