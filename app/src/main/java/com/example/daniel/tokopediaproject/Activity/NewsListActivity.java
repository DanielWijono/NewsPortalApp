package com.example.daniel.tokopediaproject.Activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
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
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.et_search)
    EditText etSearch;

    private Bundle bundle;
    private String newsValue;
    private NewsListPresenter presenter;
    private List<Articles> newsList = new ArrayList<>();
    private RecyclerViewInterface recyclerViewInterface = this;
    private MainResponse mainResponse;
    private NewsListAdapter newsListAdapter;

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            presenter.onQueryTextChanged(etSearch.getText().toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        ButterKnife.bind(this);
        presenter = new NewsListPresenter(this);
        etSearch.addTextChangedListener(textWatcher);
        getBundle();
        validationCallAPI();
    }

    private void getBundle() {
        bundle = getIntent().getExtras();
        if (bundle != null) {
            newsValue = bundle.getString("news");
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(newsValue);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.color_orange)));
            toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onBackPressed();
                }
            });
        }
    }

    private void validationCallAPI() {
        presenter.validationNewsValue(newsValue);
    }

    @Override
    public void showProgressbar() {
        etSearch.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void dismissProgressbar() {
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showSearchNewsResult(List<Articles> filteredArticleList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        newsListAdapter = new NewsListAdapter(this, filteredArticleList, recyclerViewInterface);
        newsListAdapter.setSearch(filteredArticleList);
        recyclerView.setAdapter(newsListAdapter);
    }

    @Override
    public void onSuccessGetDataView(MainResponse mainResponse) {
        etSearch.setVisibility(View.VISIBLE);
        this.mainResponse = mainResponse;
        newsList = mainResponse.getArticlesList();
        initRecyclerView();
    }

    @Override
    public void showDataBeforeFiltered() {
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        newsListAdapter = new NewsListAdapter(this, newsList, recyclerViewInterface);
        recyclerView.setAdapter(newsListAdapter);
    }

    @Override
    public void onRecyclerViewClicked(int position) {
        Intent intent = new Intent(this, WebViewActivity.class);
        intent.putExtra("url", mainResponse.getArticlesList().get(position).getUrl());
        startActivity(intent);
    }
}
