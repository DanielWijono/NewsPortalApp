package com.example.daniel.tokopediaproject.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.daniel.tokopediaproject.Adapter.HomeCategoryAdapter;
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

    private Bundle bundle;
    private String newsValue;
    private NewsListPresenter presenter;
    private List<Articles> newsList = new ArrayList<>();
    private RecyclerViewInterface recyclerViewInterface = this;

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
        newsList = mainResponse.getArticlesList();
        initRecyclerView();
    }

    @Override
    public void onSuccessGetWallstreetDataView(MainResponse mainResponse) {
        newsList = mainResponse.getArticlesList();
        initRecyclerView();
    }

    @Override
    public void onSuccessGetAppleDataView(MainResponse mainResponse) {
        newsList = mainResponse.getArticlesList();
        initRecyclerView();
    }

    @Override
    public void onSuccessGetTechcrunchDataView(MainResponse mainResponse) {
        newsList = mainResponse.getArticlesList();
        initRecyclerView();
    }

    @Override
    public void onSuccessGetBitcoinDataView(MainResponse mainResponse) {
        newsList = mainResponse.getArticlesList();
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        NewsListAdapter newsListAdapter = new NewsListAdapter(this, newsList, recyclerViewInterface);
        recyclerView.setAdapter(newsListAdapter);
    }

    @Override
    public void onRecyclerViewClicked(int position) {

    }
}
