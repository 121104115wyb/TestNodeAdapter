package com.example.testnodeadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.node.BaseExpandNode;
import com.chad.library.adapter.base.entity.node.BaseNode;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView nodeRev = findViewById(R.id.nodeRev);
        myAdapter = new MyAdapter(getEntity());
        nodeRev.setLayoutManager(new LinearLayoutManager(this));

        myAdapter.addFullSpanNodeProvider(new RootProvider());
        myAdapter.addNodeProvider(new ItemProvider());
        myAdapter.addChildClickViewIds(R.id.delete, R.id.edit);
        myAdapter.setAnimationFirstOnly(false);
        myAdapter.setAnimationEnable(true);
        myAdapter.setAnimationWithDefault(BaseQuickAdapter.AnimationType.AlphaIn);
        nodeRev.setAdapter(myAdapter);
//        myAdapter.setOnItemClickListener((adapter, view, position) -> {
////            BaseExpandNode baseExpandNode =(BaseExpandNode) myAdapter.getItem(position);
////            if (baseExpandNode.isExpanded()){
////                myAdapter.collapse(position,true,true,100);
////            }else {
////                myAdapter.expand(position,true,true,100);
////
////            }
////            Objects.requireNonNull(myAdapter).expandOrCollapse(position,false,false);
//            Toast.makeText(this, "item点击了：" + position, Toast.LENGTH_SHORT).show();
//        });

        myAdapter.setOnItemChildClickListener((adapter, view, position) -> {
            String msg = "";
            if (view.getId() == R.id.delete) {
                msg = "点击了delete";
            } else if (view.getId() == R.id.edit) {
                msg = "edit";
            }
            Toast.makeText(this, "child点击了：" + msg + "--position:" + position, Toast.LENGTH_SHORT).show();
        });

        Button testBtn = findViewById(R.id.testBtn);
        testBtn.setOnClickListener(v -> {
            HashMap<Integer, BaseNode> item = (HashMap<Integer, BaseNode>) get("test1");
            if (item != null) {
                int position = (int) item.keySet().toArray()[0];
                FirstNode firstNode = (FirstNode) item.get(position);
                if (firstNode != null) {
                    firstNode.setTitle("add note （" + firstNode.getChildNode().size() + ")");
                    myAdapter.nodeAddData(firstNode, new SecondNode("Second Node Test"));
                    myAdapter.notifyItemChanged(position);
                }
            }
//            firstNode.getChildNode().add(new SecondNode("Second Node Test1"));

//            myAdapter.nodeAddData(firstNode, new SecondNode("Second Node Test"));
//            for (BaseNode node : myAdapter.getData()) {
//                if (node instanceof FirstNode) {
//                    String name = ((FirstNode) node).getName();
//                    String title = ((FirstNode) node).getTitle();
//                    if (TextUtils.isEmpty(name)) {
//                        Log.d("tag", "FirstNode！name is empty " + title);
//                    } else {
//                        int size = node.getChildNode().size();
//                        ((FirstNode) node).setTitle(title + size);
//                        Log.d("tag", "FirstNode！name :" + name + "size:" + size);
//                    }
//                } else if (node instanceof SecondNode) {
//                    Log.d("tag", "SecondNode！" + ((SecondNode) node).getTitle());
//                } else {
//                    Log.d("tag", "类型错误！");
//                }
//            }
        });

    }

    public HashMap<Integer, BaseNode> get(String name) {
        if (TextUtils.isEmpty(name)) return null;
        for (int index = 0; index < myAdapter.getData().size(); index++) {
            BaseNode baseNode = myAdapter.getItem(index);
            if (baseNode instanceof FirstNode) {
                if (name.equals(((FirstNode) baseNode).getName())) {
                    HashMap<Integer, BaseNode> item = new HashMap<>();
                    item.put(index, baseNode);
                    return item;
                }
            }
        }
        return null;
    }


    private List<BaseNode> getEntity() {
        //总的 list，里面放的是 FirstNode
        List<BaseNode> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {

            if (i == 0 || i == 1) {
                //SecondNode 的 list
                List<BaseNode> secondNodeList = new ArrayList<>();
                for (int n = 0; n <= 5; n++) {
                    SecondNode seNode = new SecondNode("Second Node " + n);
                    secondNodeList.add(seNode);
                }
                FirstNode entity = new FirstNode(secondNodeList, "First Node " + i);
                entity.setExpanded(false);
                entity.setName("test" + i);
                list.add(entity);
            } else {
                FirstNode entity = new FirstNode(null, "First Node " + i);
                entity.setExpanded(false);
                list.add(entity);
            }
        }
        return list;
    }
}