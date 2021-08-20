package com.example.notesappoffline.adater;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import com.example.notesappoffline.R;
import com.example.notesappoffline.activity.FullView;
import com.example.notesappoffline.model.Chapter;

import java.util.List;

public class CustomAdapter extends BaseExpandableListAdapter {

    List<Chapter> chapterList;
    Context context;

    public CustomAdapter(List<Chapter> chapterList, Context context) {
        this.chapterList = chapterList;
        this.context = context;
    }

    // parent size count




    @Override
    public int getGroupCount() {
        return chapterList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return chapterList.get(i).getTopicList().size();
    }

    //position set
    @Override
    public Object getGroup(int i) {
        return chapterList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return chapterList.get(i).getTopicList().get(i1);

    }
    //Id

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        view= LayoutInflater.from(context).inflate(R.layout.chapter_item,viewGroup,false);

        TextView chapterName =(TextView)view.findViewById(R.id.chapterTitle);
        chapterName.setText(chapterList.get(i).getChapterName());

        ImageView imageView =(ImageView)view.findViewById(R.id.arrow);
        if(b==true)
        {
            imageView.setRotation(90);
        }

        else if (b==false)
        {
            imageView.setRotation(0);
        }

        return view;
    }

    @Override
    public View getChildView( int i, int i1, boolean b, View view, ViewGroup viewGroup) {

        view= LayoutInflater.from(context).inflate(R.layout.topic_item,viewGroup,false);
        TextView topicName =(TextView)view.findViewById(R.id.topicTitle);
        topicName.setText(chapterList.get(i).getTopicList().get(i1).getTopicName());

        CardView cardView =(CardView)view.findViewById(R.id.topicClick);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {

                Intent intent = (new Intent(context, FullView.class));
                intent.putExtra("fileName", chapterList.get(i).getTopicList().get(i1).getFileName());
                context.startActivity(intent);






            }
        });


        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}