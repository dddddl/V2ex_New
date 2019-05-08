package com.ddddl.v2ex.viewmodel

import androidx.databinding.ObservableField
import com.ddddl.v2ex.base.BaseViewModel
import com.ddddl.v2ex.data.bean.NodesInfo
import com.ddddl.v2ex.navigator.NavItemNavigator

class NodeItemViewModel(
    private var listener: NodeItemViewModelListener,
    item: NodesInfo.Item.NodeItem
) : BaseViewModel<NavItemNavigator>() {

    var node: ObservableField<String> = ObservableField(item.name)
    var link: ObservableField<String> = ObservableField(item.link)

    fun onItemClick() {
        listener.onItemClick(0)
    }

    interface NodeItemViewModelListener {
        fun onItemClick(nodeId: Int)
    }

}