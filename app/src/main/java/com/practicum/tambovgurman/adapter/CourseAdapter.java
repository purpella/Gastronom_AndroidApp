package com.practicum.tambovgurman.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.practicum.tambovgurman.CoursePage;
import com.practicum.tambovgurman.R;
import com.practicum.tambovgurman.model.Course;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    Context context;
    List<Course> courses;

    public CourseAdapter(Context context, List<Course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View courseItems = LayoutInflater.from(context).inflate(R.layout.course_item, parent, false);
        return new CourseAdapter.CourseViewHolder(courseItems);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {



        holder.courseBg.setCardBackgroundColor(Color.parseColor(courses.get(position).getColor()));

        int imageID = context.getResources().getIdentifier(courses.get(position).getImg(), "drawable", context.getPackageName());
        holder.courseImage.setImageResource(imageID);

        holder.courseTitle.setText(courses.get(position).getTitle());
        holder.coursePlace.setText(courses.get(position).getPlace());
        holder.courseRating.setText(courses.get(position).getRating());
        holder.courseCheck.setText(courses.get(position).getCheck());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CoursePage.class);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        (Activity) context,
                        new Pair<View, String>(holder.courseImage, "courseImage")
                        );

                intent.putExtra("courseBg", Color.parseColor(courses.get(position).getColor()));
                intent.putExtra("courseImage", imageID);
                intent.putExtra("courseTitle", courses.get(position).getTitle());
                intent.putExtra("coursePlace", courses.get(position).getPlace());
                intent.putExtra("courseRating", courses.get(position).getRating());
                intent.putExtra("courseCheck", courses.get(position).getCheck());
                intent.putExtra("courseText", courses.get(position).getText());
                intent.putExtra("courseText", courses.get(position).getText());
                intent.putExtra("ratingButton", courses.get(position).getRatingUrl());
                intent.putExtra("mapButton", courses.get(position).getMapUrl());
                intent.putExtra("mapButton", courses.get(position).getMapUrl());
                intent.putExtra("ratingButton", courses.get(position).getRatingUrl());

                context.startActivity(intent, options.toBundle());
            }
        });

    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public static final class CourseViewHolder extends RecyclerView.ViewHolder {

        CardView courseBg;
        ImageView courseImage;
        TextView courseTitle, coursePlace, courseRating, courseCheck;
        ImageButton mapButton, ratingButton;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);

            courseBg = itemView.findViewById(R.id.courseBg);
            courseImage = itemView.findViewById(R.id.courseImage);
            courseTitle = itemView.findViewById(R.id.courseTitle);
            coursePlace = itemView.findViewById(R.id.coursePlace);
            courseRating = itemView.findViewById(R.id.courseRating);
            courseCheck = itemView.findViewById(R.id.courseCheck);
            ratingButton = itemView.findViewById(R.id.ratingButton);
            mapButton = itemView.findViewById(R.id.mapButton);
            ratingButton = itemView.findViewById(R.id.ratingButton);



        }
    }
}
