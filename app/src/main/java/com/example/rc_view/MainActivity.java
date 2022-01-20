 package com.example.rc_view;

import static android.widget.LinearLayout.VERTICAL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.GridLayout;

import com.Adapter.BookAdapter;
import com.Model.BookModel;
import com.interfaces.ListListener;

import java.util.ArrayList;

 public class MainActivity extends AppCompatActivity implements ListListener  {
    RecyclerView recyclerView;
     ArrayList<BookModel>list =new ArrayList<>();
     BookAdapter adapter;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        list.add(new BookModel(R.drawable.example,"kv,","me"));
        list.add(new BookModel(R.drawable.fingerprint,"av","mw"));
        list.add(new BookModel(R.drawable.gradient,"jv","zeo"));
        list.add(new BookModel(R.drawable.quiz,"tv","you"));
        list.add(new BookModel(R.drawable.person,"yv","meee"));
        list.add(new BookModel(R.drawable.share,"lv","bhee"));
        list.add(new BookModel(R.drawable.speaker,"hv","ji"));
        list.add(new BookModel(R.drawable.tips,"vi","see"));
        list.add(new BookModel(R.drawable.title,"vv","he"));
        //list.set(7,new BookModel(R.drawable.book,"geeta", "fgh"));

         adapter =new BookAdapter(list,this,MainActivity.this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

       // StaggeredGridLayoutManager staggered = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL);
       // recyclerView.setLayoutManager(staggered);

        //GridLayoutManager gridLayoutManager =new GridLayoutManager(this,2);
       // recyclerView.setLayoutManager(gridLayoutManager);




    }


     @Override
     public void onItemClick(int position, int pic, String t1, String t2) {
         // list.add(position,new BookModel(R.drawable.book,"geeta", "fgh"));

         BookModel model=new BookModel();
         model.setPic(R.drawable.quiz);
         model.setText("XYZ");
         model.setText2("New");

         list.add(0, model);
         adapter.notifyDataSetChanged();
     }
 }