package com.ddddl.v2ex.bingUtils

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ddddl.v2ex.adapter.NodeAdapter
import com.ddddl.v2ex.adapter.NodeListAdapter
import com.ddddl.v2ex.adapter.TopicsAdapter
import com.ddddl.v2ex.data.bean.NodesInfo
import com.ddddl.v2ex.data.bean.TopicStartInfo

object RecyclerUtils {

    @BindingAdapter("topicStartInfo")
    @JvmStatic
    fun addTopicStartInfo(recyclerView: RecyclerView, topics: List<TopicStartInfo.Item>) {

        val adapter = recyclerView.adapter as TopicsAdapter?
        if (adapter != null) {
            adapter.clearItems()
            adapter.addItems(topics)
        }
    }

    @BindingAdapter("nodesInfo")
    @JvmStatic
    fun addNodesInfo(recyclerView: RecyclerView, nodesInfo: List<NodesInfo.Item>) {

        val nodeList = ArrayList<NodesInfo.Item.NodeItem>()

        for (i in nodesInfo.indices) {
            val nodeItem = NodesInfo.Item.NodeItem()
            nodeItem.isCategory = true
            nodeItem.category = nodesInfo[i].category
            nodeList.add(nodeItem)
            nodeList.addAll(nodesInfo[i].nodes)
        }

        (recyclerView.adapter as NodeListAdapter?)?.apply {
            clearItems()
            addItems(nodeList)
        }
    }

    @BindingAdapter("nodeItem")
    @JvmStatic
    fun addNodeItem(recyclerView: RecyclerView, nodesInfo: List<NodesInfo.Item.NodeItem>) {
        (recyclerView.adapter as NodeAdapter?)?.apply {
            clearItems()
            addItems(nodesInfo)
        }
    }
}
