package com.learnera.app.data;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.learnera.app.R;

import java.util.List;

/**
 * Created by Shankar on 24-06-2017.
 */

public class MarksAdapter extends RecyclerView.Adapter<MarksAdapter.ViewHolder>{
    private List<Marks> marksList;

    public MarksAdapter(List<Marks> marksSet) {
        marksList = marksSet;
    }

    @Override
    public MarksAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_marks, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MarksAdapter.ViewHolder holder, int position) {
        Marks marks = marksList.get(position);
        holder.subjectLetterTextView.setText(marks.getmSubLetter());
        holder.subjectCodeTextView.setText(marks.getmSubCode());
        holder.subjectNameTextView.setText(marks.getmSubName().trim());
        holder.subjectMaxMarksTextView.setText(marks.getmOutOf());
        holder.subjectMarksTextView.setText(marks.getmSubMarks());
    }

    @Override
    public int getItemCount() {
        return marksList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView subjectLetterTextView;
        public TextView subjectCodeTextView;
        public TextView subjectNameTextView;
        public TextView subjectMaxMarksTextView;
        public TextView subjectMarksTextView;


        public ViewHolder(View v) {
            super(v);
            subjectLetterTextView = (TextView) v.findViewById(R.id.subject_letter_text_view);
            subjectCodeTextView = (TextView) v.findViewById(R.id.subject_code_text_view);
            subjectNameTextView = (TextView) v.findViewById(R.id.subject_name_text_view);
            subjectMaxMarksTextView = (TextView) v.findViewById(R.id.max_marks_text_view);
            subjectMarksTextView = (TextView) v.findViewById(R.id.obtained_marks_text_view);
        }
    }
}

