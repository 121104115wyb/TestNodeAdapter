package com.example.testnodeadapter;

import com.chad.library.adapter.base.BaseNodeAdapter;
import com.chad.library.adapter.base.entity.node.BaseNode;

import java.util.List;

public class MyAdapter extends BaseNodeAdapter {

    public MyAdapter(List<BaseNode> nodeList) {
        super(nodeList);
    }

    @Override
    protected int getItemType(List<? extends BaseNode> list, int i) {
        BaseNode node = list.get(i);
        if (node instanceof FirstNode) {
            return 0;
        } else if (node instanceof SecondNode) {
            return 1;
        } else {
            return -1;
        }
    }
}
