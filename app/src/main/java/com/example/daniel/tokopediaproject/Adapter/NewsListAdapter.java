package com.example.daniel.tokopediaproject.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.daniel.tokopediaproject.Interface.RecyclerViewInterface;
import com.example.daniel.tokopediaproject.Model.Articles;
import com.example.daniel.tokopediaproject.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Articles> newsList;
    private RecyclerViewInterface recyclerViewInterface;

    public NewsListAdapter(Context context, List<Articles> newsList, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.newsList = newsList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news_list, parent, false);
        return new NewsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        NewsListViewHolder newsListViewHolder = (NewsListViewHolder) holder;
        newsListViewHolder.setView(position);
        newsListViewHolder.setCardViewOnClick(position);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    public class NewsListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.news_cardview)
        CardView newsCardview;
        @BindView(R.id.news_image)
        ImageView newsImage;
        @BindView(R.id.news_title)
        TextView newsTitle;
        @BindView(R.id.news_description)
        TextView newsDescription;
        @BindView(R.id.news_author)
        TextView newsAuthor;

        public NewsListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setView(int position) {
            Glide.with(context).load(newsList.get(position).getUrlToImage()).placeholder(R.drawable.news_placeholder).into(newsImage); //TAMBAHIN PLACEHOLDER
            newsTitle.setText(newsList.get(position).getTitle());
            newsDescription.setText(newsList.get(position).getDescription());
            newsAuthor.setText(newsList.get(position).getAuthor());
        }

        public void setCardViewOnClick(int position) {

        }
    }
}
