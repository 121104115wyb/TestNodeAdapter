package com.example.testnodeadapter;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.entity.node.BaseNode;
import com.chad.library.adapter.base.provider.BaseNodeProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;

public class ItemProvider extends BaseNodeProvider {

    @Override
    public int getItemViewType() {
        return 1;
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_provider_item_view;
    }

    @Override
    public void convert(BaseViewHolder baseViewHolder, BaseNode baseNode) {

        SecondNode secondNode = (SecondNode) baseNode;
        baseViewHolder.setText(R.id.rootTitle, secondNode.getTitle());
    }

//    @Override
//    public void onClick(@NonNull BaseViewHolder helper, @NonNull View view, BaseNode data, int position) {
//        super.onClick(helper, view, data, position);
//        SecondNode secondNode = (SecondNode) data;
//        String msg = "onClick\ntitle:" + secondNode.getTitle() + "position:" + position;
//        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
//        Log.d("ItemProvider", "onClick点击了" + msg);
//    }
//
//
//    @Override
//    public void onChildClick(@NonNull BaseViewHolder helper, @NonNull View view, BaseNode data, int position) {
//        super.onChildClick(helper, view, data, position);
//        SecondNode secondNode = (SecondNode) data;
//        String msg = "onChildClick\ntitle:" + secondNode.getTitle() + "position:" + position;
//        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
//        Log.d("ItemProvider", "onChildClick点击了" + msg);
//
//    }
}
