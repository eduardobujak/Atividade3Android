package com.example.atividade03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.atividade03.adapter.AlbumsAdapter;
import com.example.atividade03.adapter.CommentsAdapter;
import com.example.atividade03.adapter.PostsAdapter;
import com.example.atividade03.model.CommentsClass;
import com.example.atividade03.model.PostsClass;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ActivityComments extends AppCompatActivity
        implements Response.Listener<JSONArray>,
        Response.ErrorListener{

    List<CommentsClass> comments =  new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);
        TextView tv = (TextView) findViewById(R.id.textoSegunda);
        Intent it = getIntent();


// Volley
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://jsonplaceholder.typicode.com/comments";

        // Request de JsonArray da URL.

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                this, this);


        // Add the request to the RequestQueue.
        queue.add(jsonArrayRequest);
        //Toast.makeText(this,"qtd:"+posts.size(),Toast.LENGTH_LONG).show();


    }
    // Volley
    @Override
    public void onResponse(JSONArray response) {
        try {

            for(int i = 0; i < response.length(); i++) {
                JSONObject json = response.getJSONObject(i);
                CommentsClass obj = new CommentsClass(json.getInt("postId"),
                        json.getInt("id"),
                        json.getString("name"),
                        json.getString("email"),
                        json.getString("body"));
                comments.add(obj);

            }
            Toast.makeText(this,"qtd:"+comments.size(),Toast.LENGTH_LONG).show();

            RecyclerView rv = findViewById(R.id.rvTodos);

            LinearLayoutManager llm = new LinearLayoutManager(this);

            //  LinearLayoutManager llhm2 = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
            //  GridLayoutManager glm = new GridLayoutManager(this,3);
            //  StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
            rv.setLayoutManager(llm);
            CommentsAdapter commentsAdapter = new CommentsAdapter(comments,0);
            rv.setAdapter(commentsAdapter);


        } catch (JSONException e) {
            Log.e("erro",e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        String msg = error.getMessage();
        Toast.makeText(this.getApplicationContext(),"deu erro: "+msg,Toast.LENGTH_LONG).show();
    }



}