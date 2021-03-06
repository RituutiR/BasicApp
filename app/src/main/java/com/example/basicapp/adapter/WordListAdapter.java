package com.example.basicapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.basicapp.R;
import com.example.basicapp.data.Subjects;
import com.example.basicapp.ui.ChapterListActivity;
import com.example.basicapp.ui.WebViewActivity;

import de.hdodenhof.circleimageview.CircleImageView;
import java.util.List;


public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.ViewHolder> {

    private Context mContext;
    List<String> subjectList;

    public WordListAdapter(Context context, List<String> subjectList) {
        mContext = context;
        this.subjectList = subjectList;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override public void onBindViewHolder(ViewHolder holder, final int position) {

        String subject = subjectList.get(position);

        // do not show full path
        holder.imageName.setText(subject.substring(subject.lastIndexOf("/") + 1));
        holder.image.setVisibility(View.GONE);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                //Intent intent = new Intent(mContext, WordListActivity.class);
                Intent intent = new Intent(mContext, WebViewActivity.class);
                intent.putExtra("url", subjectList.get(position));
                mContext.startActivity(intent);
            }
        });
    }


    @Override public int getItemCount() {
        return subjectList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView imageName;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            imageName = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}