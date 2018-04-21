package xyz.przedszkole.eprzedszkole.View.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.przedszkole.eprzedszkole.Model.ChildModel;
import xyz.przedszkole.eprzedszkole.R;

/**
 * Created by Marcin on 19.03.2018.
 */

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildListViewHolder>{

    private Context context;
    private List<ChildModel> childList = new ArrayList<>();
    public ChildAdapter(List<ChildModel> childList){
        this.childList = childList;
    }
    @Override
    public ChildListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_child_recyclerview_row,parent,false);
        ChildListViewHolder childeListViewHolder = new ChildListViewHolder(view);
        return childeListViewHolder;
    }

    @Override
    public void onBindViewHolder(ChildAdapter.ChildListViewHolder holder, int position) {
        ChildModel childModel = childList.get(position);
        String fullName = childModel.getImie() + " "+ childModel.getNazwisko();
        holder.tvChildFullName.setText(fullName);

    }

    @Override
    public int getItemCount() {
        return childList.size();
    }

    public class ChildListViewHolder extends RecyclerView.ViewHolder {

//        @BindView(R.id.child_card_view)
//        CardView childCardView;
//
//        @BindView(R.id.child_photo)
//        ImageView ivChildPhoto;
//
//        @BindView(R.id.child_fullname)
        TextView tvChildFullName;

        public ChildListViewHolder(View itemView) {
            super(itemView);
            tvChildFullName = (TextView) itemView.findViewById(R.id.child_fullname);
           // ButterKnife.bind(itemView);
        }
    }
}

