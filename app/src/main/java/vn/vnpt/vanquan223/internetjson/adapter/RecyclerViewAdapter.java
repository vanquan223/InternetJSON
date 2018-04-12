package vn.vnpt.vanquan223.internetjson.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.vnpt.vanquan223.internetjson.R;
import vn.vnpt.vanquan223.internetjson.newsmodel.ListNewsModel;

public class RecyclerViewAdapter extends RecyclerView.Adapter {
    private Activity activity;
    private List<ListNewsModel> listNewsModels;

    public RecyclerViewAdapter(Activity activity, List<ListNewsModel> listNewsModels) {
        this.activity = activity;
        this.listNewsModels = listNewsModels;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.item_view, parent, false);
        NewHolder newHolder = new NewHolder(view);
        return newHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NewHolder newHolder = (NewHolder) holder;
        ListNewsModel model = listNewsModels.get(position);
        newHolder.tvDate.setText(model.getDate());
        if (model.getTitle() != null)
            newHolder.tvTitle.setText(Html.fromHtml(model.getTitle().getRendered()));
        if (model.getExcerpt() != null)
            newHolder.tvContent.setText(Html.fromHtml(model.getExcerpt().getRendered()));
        if (model.getBetter_featured_image() != null)
            Glide.with(activity).load(model.getBetter_featured_image().getSource_url()).into(newHolder.ivImage);
    }

    @Override
    public int getItemCount() {
        return listNewsModels.size();
    }

    private static class NewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvDate;
        ImageView ivImage;
        TextView tvContent;

        public NewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDate = itemView.findViewById(R.id.tvDate);
            ivImage = itemView.findViewById(R.id.ivImage);
            tvContent = itemView.findViewById(R.id.tvContent);
        }
    }
}
