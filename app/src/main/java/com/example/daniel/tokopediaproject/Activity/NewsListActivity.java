package com.example.daniel.tokopediaproject.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.example.daniel.tokopediaproject.Adapter.NewsListAdapter;
import com.example.daniel.tokopediaproject.Contract.NewsListContract;
import com.example.daniel.tokopediaproject.Interface.RecyclerViewInterface;
import com.example.daniel.tokopediaproject.Model.Articles;
import com.example.daniel.tokopediaproject.Model.MainResponse;
import com.example.daniel.tokopediaproject.Presenter.NewsListPresenter;
import com.example.daniel.tokopediaproject.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsListActivity extends AppCompatActivity implements NewsListContract.View, RecyclerViewInterface {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    private Bundle bundle;
    private String newsValue;
    private NewsListPresenter presenter;
    private List<Articles> newsList = new ArrayList<>();
    private RecyclerViewInterface recyclerViewInterface = this;
    private MainResponse mainResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        ButterKnife.bind(this);
        presenter = new NewsListPresenter(this);
        getBundle();
        validationCallAPI();
    }

    private void getBundle() {
        bundle = getIntent().getExtras();
        if (bundle != null) {
            newsValue = bundle.getString("news");
        }
    }

    private void validationCallAPI() {
        presenter.validationNewsValue(newsValue);
    }

    @Override
    public void onSuccessGetBusinessDataView(MainResponse mainResponse) {
        this.mainResponse = mainResponse;
        newsList = mainResponse.getArticlesList();
        initRecyclerView();
    }

    @Override
    public void onSuccessGetWallstreetDataView(MainResponse mainResponse) {
        this.mainResponse = mainResponse;
        newsList = mainResponse.getArticlesList();
        initRecyclerView();
    }

    @Override
    public void onSuccessGetAppleDataView(MainResponse mainResponse) {
        this.mainResponse = mainResponse;
        newsList = mainResponse.getArticlesList();
        initRecyclerView();
    }

    @Override
    public void onSuccessGetTechcrunchDataView(MainResponse mainResponse) {
        this.mainResponse = mainResponse;
        newsList = mainResponse.getArticlesList();
        initRecyclerView();
    }

    @Override
    public void onSuccessGetBitcoinDataView(MainResponse mainResponse) {
        this.mainResponse = mainResponse;
        newsList = mainResponse.getArticlesList();
        initRecyclerView();
    }

    @Override
    public void showProgressbar() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void dismissProgressbar() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        NewsListAdapter newsListAdapter = new NewsListAdapter(this, newsList, recyclerViewInterface);
        recyclerView.setAdapter(newsListAdapter);
    }

    @Override
    public void onRecyclerViewClicked(int position) {
        System.out.println("url news : "+mainResponse.getArticlesList().get(position).getUrl());
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra("url",mainResponse.getArticlesList().get(position).getUrl());
        startActivity(intent);
    }
}
