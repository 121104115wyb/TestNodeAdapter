package com.example.testnodeadapter;

import android.view.View;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

import java.util.Objects;

public class RootProvider extends BaseNodeProvider {

    @Override
    public int getItemViewType() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_provider_item_view;
    }

    @Override
    public void convert(BaseViewHolder baseViewHolder, BaseNode baseNode) {
        FirstNode firstNode = (FirstNode) baseNode;
        baseViewHolder.setText(R.id.rootTitle, firstNode.getTitle());

    }

    @Override
    public void onClick(@NonNull BaseViewHolder helper, @NonNull View view, BaseNode data, int position) {
        getAdapter().expandOrCollapse(position,true,true,100);
    }
}
