package com.example.daniel.tokopediaproject.Activity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.daniel.tokopediaproject.Adapter.HomeCategoryAdapter;
import com.example.daniel.tokopediaproject.Constants;
import com.example.daniel.tokopediaproject.Contract.HomeContract;
import com.example.daniel.tokopediaproject.Interface.RecyclerViewInterface;
import com.example.daniel.tokopediaproject.Presenter.HomePresenter;
import com.example.daniel.tokopediaproject.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements RecyclerViewInterface, HomeContract.View {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private List<String> listCategory = new ArrayList<>();
    private RecyclerViewInterface recyclerViewInterface = this;
    private HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        addListCategory();
        initRecyclerView();
        presenter = new HomePresenter(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.color_orange)));
    }

    private void addListCategory() {
        listCategory.add("BUSINESS");
        listCategory.add("BITCOIN");
        listCategory.add("TECH CRUNCH");
        listCategory.add("APPLE");
        listCategory.add("WALL STREET");
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        HomeCategoryAdapter homeCategoryAdapter = new HomeCategoryAdapter(this, listCategory, recyclerViewInterface);
        recyclerView.setAdapter(homeCategoryAdapter);
    }

    @Override
    public void onRecyclerViewClicked(int position) {
        presenter.validatePositionClick(position);
    }

    @Override
    public void intentToBusinessNews() {
        Intent intent = new Intent(this, NewsListActivity.class);
        intent.putExtra("news", Constants.NEWS_TYPE.BUSINESS_NEWS);
        startActivity(intent);
    }

    @Override
    public void intentToBitcoinNews() {
        Intent intent = new Intent(this, NewsListActivity.class);
        intent.putExtra("news", Constants.NEWS_TYPE.BITCOIN_NEWS);
        startActivity(intent);
    }

    @Override
    public void intentToTechCrunchNews() {
        Intent intent = new Intent(this, NewsListActivity.class);
        intent.putExtra("news", Constants.NEWS_TYPE.TECHCRUNCH_NEWS);
        startActivity(intent);
    }

    @Override
    public void intentToAppleNews() {
        Intent intent = new Intent(this, NewsListActivity.class);
        intent.putExtra("news", Constants.NEWS_TYPE.APPLE_NEWS);
        startActivity(intent);
    }

    @Override
    public void intentToWallStreetNews() {
        Intent intent = new Intent(this, NewsListActivity.class);
        intent.putExtra("news", Constants.NEWS_TYPE.WALLSTREET_NEWS);
        startActivity(intent);
    }
}
