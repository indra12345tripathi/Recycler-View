package com.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Model.BookModel;
import com.example.rc_view.R;
import com.interfaces.ListListener;

import java.util.ArrayList;


public class BookAdapter  extends RecyclerView.Adapter<BookAdapter.viewHolder>{

      ArrayList<BookModel>list;
      Context context;
      ListListener listListener;

    public BookAdapter(ArrayList<BookModel> list, Context context, ListListener listListener) {
        this.list = list;
        this.context = context;
        this.listListener = listListener;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sampal_rc_view,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder,  int position) {
        BookModel model=list.get(position);
        holder.imageView.setImageResource(model.getPic());
        holder.textView.setText(model.getText());
        holder.text.setText(model.getText2());
        holder.postition_tv.setText(""+position);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"image one is clicked",Toast.LENGTH_SHORT).show();

            }
        });



        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,model.getText(),Toast.LENGTH_SHORT).show();

            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(context,model.getText(),Toast.LENGTH_SHORT).show();
                listListener.onItemClick(holder.getAdapterPosition(),model.getPic(),model.getText(), model.getText2()  );

            }
        });
     /* switch (position){
           case 0:
               holder.imageView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Toast.makeText(context,"image one is clicked",Toast.LENGTH_SHORT).show();

                   }
               });
               holder.textView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Toast.makeText(context,"image one wow",Toast.LENGTH_SHORT).show();

                   }
               });
               break;

           case 1:
               holder.imageView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Toast.makeText(context,"image two is clicked",Toast.LENGTH_SHORT).show();

                   }
               });
               holder.textView.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Toast.makeText(context,"suraj  wow",Toast.LENGTH_SHORT).show();

                   }
               });
               break;

           default:

       }*/

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView, text, postition_tv;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageView =itemView.findViewById(R.id.imageView);
            textView =itemView.findViewById(R.id.textView);
            text =itemView.findViewById(R.id.textView3);
            postition_tv =itemView.findViewById(R.id.postition_tv);
        }
    }
}
