package com.example.daniel.tokopediaproject.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daniel.tokopediaproject.Interface.RecyclerViewInterface;
import com.example.daniel.tokopediaproject.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeCategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<String> categoryList;
    private RecyclerViewInterface recyclerViewInterface;

    public HomeCategoryAdapter(Context context, List<String> categoryList, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.categoryList = categoryList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category_list, parent, false);
        return new HomeCategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeCategoryViewHolder homeCategoryViewHolder = (HomeCategoryViewHolder) holder;
        homeCategoryViewHolder.setViewCategory(position);
        homeCategoryViewHolder.setCardViewOnClick(position);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class HomeCategoryViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_category_text)
        TextView tvCategoryText;
        @BindView(R.id.category_card_view)
        CardView categoryCardView;

        public HomeCategoryViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, itemView);
        }

        public void setViewCategory(int position) {
            tvCategoryText.setText(categoryList.get(position));
        }

        public void setCardViewOnClick(final int position) {
            categoryCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerViewInterface.onRecyclerViewClicked(position);
                }
            });
        }
    }
}
