package com.ddddl.v2ex.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.databinding.ObservableList
import com.ddddl.v2ex.adapter.NodeListAdapter
import com.ddddl.v2ex.base.BaseViewModel
import com.ddddl.v2ex.data.bean.NodesInfo
import com.ddddl.v2ex.navigator.NavItemNavigator

class NavItemViewModel(
    private var listener: NodeListItemViewModelListener,
    item: NodesInfo.Item.NodeItem
) : BaseViewModel<NavItemNavigator>() {

    var category: ObservableField<String> = ObservableField(item.category)
    var name: ObservableField<String> = ObservableField(item.name)
//    var nodeArrayList: ObservableList<NodesInfo.Item.NodeItem> =
//        ObservableArrayList<NodesInfo.Item.NodeItem>()
//
//    init {
//        nodeArrayList.clear()
//        nodeArrayList.addAll(item.nodes)
//    }


    fun onItemClick() {
        listener.onItemClick(0)
    }

    interface NodeListItemViewModelListener {
        fun onItemClick(nodeId: Int)
    }

}