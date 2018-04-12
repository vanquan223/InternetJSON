package vn.vnpt.vanquan223.internetjson.adapter;

import android.app.Activity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import vn.vnpt.vanquan223.internetjson.R;
import vn.vnpt.vanquan223.internetjson.newsmodel.ListNewsModel;

public class ListNewsAdapter extends BaseAdapter {
    List<ListNewsModel> listNewsModels;
    Activity activity;

    public ListNewsAdapter(List<ListNewsModel> listNewsModels, Activity activity) {
        this.listNewsModels = listNewsModels;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return listNewsModels.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_view, parent, false);

            Hold hold = new Hold();
            hold.tvTitle = convertView.findViewById(R.id.tvTitle);
            hold.tvDate = convertView.findViewById(R.id.tvDate);
            hold.tvContent = convertView.findViewById(R.id.tvContent);
            hold.ivImage = convertView.findViewById(R.id.ivImage);
            convertView.setTag(hold);
        }

        Hold hold = (Hold) convertView.getTag();
        ListNewsModel listNewsModel = listNewsModels.get(position);
        if (listNewsModel.getTitle() != null)
            hold.tvTitle.setText(Html.fromHtml(listNewsModel.getTitle().getRendered()));

        hold.tvDate.setText(listNewsModel.getDate());

        if (listNewsModel.getExcerpt() != null)
            hold.tvContent.setText(Html.fromHtml(listNewsModel.getExcerpt().getRendered()));

        if (listNewsModel.getBetter_featured_image() != null)
            Glide.with(activity).load(listNewsModel.getBetter_featured_image().getSource_url()).into(hold.ivImage);

        return convertView;
    }

    private static class Hold {
        TextView tvTitle;
        TextView tvDate;
        ImageView ivImage;
        TextView tvContent;
    }
}
