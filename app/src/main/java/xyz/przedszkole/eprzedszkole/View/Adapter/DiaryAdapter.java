package xyz.przedszkole.eprzedszkole.View.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import xyz.przedszkole.eprzedszkole.Model.ChildModel;
import xyz.przedszkole.eprzedszkole.Model.ClassesModel;
import xyz.przedszkole.eprzedszkole.R;

/**
 * Created by Marcin on 16.04.2018.
 */

public class DiaryAdapter  extends RecyclerView.Adapter<DiaryAdapter.DiaryListViewHolder>{

    private Context context;
    private List<ClassesModel> diaryList = new ArrayList<>();
    public DiaryAdapter(List<ClassesModel> diaryList){
        this.diaryList = diaryList;
    }
    @Override
    public DiaryAdapter.DiaryListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_diary_recyclerview_row,parent,false);
        DiaryAdapter.DiaryListViewHolder diaryListViewHolder = new DiaryAdapter.DiaryListViewHolder(view);
        return diaryListViewHolder;
    }

    @Override
    public void onBindViewHolder(DiaryAdapter.DiaryListViewHolder holder, int position) {
        ClassesModel classesModel = diaryList.get(position);
        holder.tvDiaryDescription.setText(classesModel.getOpis());
        holder.tvDiaryTopic.setText(classesModel.getTytul());
        holder.tvDiaryDate.setText(classesModel.getDataZa());
    }

    @Override
    public int getItemCount() {
        return diaryList.size();
    }

    public class DiaryListViewHolder extends RecyclerView.ViewHolder {


        TextView tvDiaryTopic;
        TextView tvDiaryDate;
        TextView tvDiaryDescription;


        public DiaryListViewHolder(View itemView) {
            super(itemView);
            tvDiaryDate = (TextView) itemView.findViewById(R.id.diaryDateTextView);
            tvDiaryTopic = (TextView) itemView.findViewById(R.id.diaryTopicTextView);
            tvDiaryDescription = (TextView) itemView.findViewById(R.id.diaryDescriptionTextView);

        }
    }
}
