package com.practicum.tambovgurman;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class CoursePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);

        ConstraintLayout courseBg = findViewById(R.id.coursePageBg);
        ImageView courseImage = findViewById(R.id.coursePageImage);
        TextView courseTitle = findViewById(R.id.coursePageTitle);
        TextView coursePlace = findViewById(R.id.coursePagePlace);
        TextView courseRating = findViewById(R.id.coursePageRating);
        TextView courseText = findViewById(R.id.coursePageText);
        ImageButton mapButton = findViewById(R.id.mapButton);
        ImageButton ratingButton = findViewById(R.id.ratingButton);

        String mapUrl = getIntent().getStringExtra("mapButton");
        String ratingUrl = getIntent().getStringExtra("ratingButton");

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mapUrl != null && !mapUrl.isEmpty()) {
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mapUrl));
                    startActivity(mapIntent);
                }
            }
        });

        mapButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mapButton.setColorFilter(getResources().getColor(android.R.color.holo_blue_dark));
                } else if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
                    mapButton.clearColorFilter();
                }
                return false;
            }
        });


        ratingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ratingUrl != null && !ratingUrl.isEmpty()) {
                    Intent ratingIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ratingUrl));
                    startActivity(ratingIntent);
                }
            }
        });

        ratingButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    ratingButton.setColorFilter(getResources().getColor(android.R.color.holo_blue_dark));
                } else if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL) {
                    ratingButton.clearColorFilter();
                }
                return false;
            }
        });


        courseBg.setBackgroundColor(getIntent().getIntExtra("courseBg", 0));
        courseImage.setImageResource(getIntent().getIntExtra("courseImage", 0));
        courseTitle.setText(getIntent().getStringExtra("courseTitle"));
        coursePlace.setText(getIntent().getStringExtra("coursePlace"));
        courseRating.setText(getIntent().getStringExtra("courseRating"));
        courseText.setText(getIntent().getStringExtra("courseText"));


    }
}