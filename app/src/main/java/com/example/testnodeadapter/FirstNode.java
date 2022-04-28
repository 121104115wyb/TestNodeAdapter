package com.example.testnodeadapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;

import java.util.List;

/**
 * 第一个节点FirstNode，里面放子节点SecondNode
 */
public class FirstNode extends BaseExpandNode {

    private List<BaseNode> childNode;
    private String title;
    private String name = "";

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public FirstNode(List<BaseNode> childNode, String title) {
        this.childNode = childNode;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 重写此方法，返回子节点
     */
    @Nullable
    @Override
    public List<BaseNode> getChildNode() {
        return childNode;
    }

}