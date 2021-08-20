package com.example.notesappoffline.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import com.example.notesappoffline.R;
import com.example.notesappoffline.adater.CustomAdapter;
import com.example.notesappoffline.model.Chapter;
import com.example.notesappoffline.model.Topic;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    CustomAdapter customAdapter;
    List<Chapter>chapterList;
    List<Topic>topicList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        expandableListView=(ExpandableListView)findViewById(R.id.expandableListView);



        addData();
        sendData();



    }
    void addData()
    {


        // single time
        chapterList = new ArrayList<>();
        //multiple time
        topicList =new ArrayList<>();

        //chapter 1

        topicList.add(new Topic("Python Basic Interview Questions","p1"));

        chapterList.add(new Chapter("Python interview questions",topicList));

        topicList =new ArrayList<>();

        topicList.add(new Topic("TCS Digital Interview Questions","tcs1"));
        topicList.add(new Topic("TCS Ninja Aptitude Questions","tcs2"));

        chapterList.add(new Chapter("TCS interview questions",topicList));


        //chapter 2
        topicList =new ArrayList<>();

        topicList.add(new Topic("Basic of Java","j1"));

        chapterList.add(new Chapter("Java interview questions",topicList));

        //Book For Aptitude
        topicList =new ArrayList<>();

        topicList.add(new Topic(" Vol I)Quantitative Aptitude for Campus Interview By Dinesh Khattar ","ap1"));

        topicList.add(new Topic(" Vol II)Quantitative Aptitude for Campus Interview By Dinesh Khattar ","ap2"));

        topicList.add(new Topic(" Campus Recruitment Book ","ap3"));



        chapterList.add(new Chapter("Book For Aptitude",topicList));


        //Aptitude Questions and Answers






    }



    void sendData()
    {
        customAdapter = new CustomAdapter(chapterList,MainActivity.this);
        expandableListView.setAdapter(customAdapter);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

       switch (item.getItemId())
       {
           case R.id.privacy:
               startActivity(new Intent(MainActivity.this,Privacy.class));
               break;
           case R.id.about:
               startActivity(new Intent(MainActivity.this,About.class));

               break;
       }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
        finishAndRemoveTask();
        finish();
    }
}