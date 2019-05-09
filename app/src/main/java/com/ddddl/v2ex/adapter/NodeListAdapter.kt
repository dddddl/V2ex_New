package com.ddddl.v2ex.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ddddl.v2ex.base.BaseViewHolder
import com.ddddl.v2ex.data.bean.NodesInfo
import com.ddddl.v2ex.databinding.ItemNodenavViewCategoryBinding
import com.ddddl.v2ex.databinding.ItemNodenavViewNodeBinding
import com.ddddl.v2ex.utils.JsonUtil
import com.ddddl.v2ex.viewmodel.NavItemViewModel
import com.google.android.flexbox.*
import timber.log.Timber

class NodeListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var nodeList = ArrayList<NodesInfo.Item.NodeItem>()
    private val TYPE_CATEGORY = 1
    private val TYPEE_NODE = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == TYPEE_NODE) {
            val itemNodenavViewNodeBinding =
                ItemNodenavViewNodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            NodesViewHolder(itemNodenavViewNodeBinding)
        } else {
            val itemNodenavViewCategoryBinding =
                ItemNodenavViewCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            CategoryViewHolder(itemNodenavViewCategoryBinding)
        }
    }

    override fun getItemCount(): Int {
        return nodeList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (nodeList[position].isCategory) {
            TYPE_CATEGORY
        } else {
            TYPEE_NODE
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is CategoryViewHolder) {
            (holder as CategoryViewHolder).onBind(position)
        } else {
            (holder as NodesViewHolder).onBind(position)
        }
    }

    private inner class NodesViewHolder(private val mBinding: ItemNodenavViewNodeBinding) :
        BaseViewHolder(mBinding.root), NavItemViewModel.NodeListItemViewModelListener {

        private var navItemViewModel: NavItemViewModel? = null

        override fun onBind(position: Int) {
            val item = nodeList[position]
            navItemViewModel = NavItemViewModel(this, item)

            mBinding.viewModel = navItemViewModel
            mBinding.executePendingBindings()
        }

        override fun onItemClick(nodeId: Int) {

        }

    }

    private inner class CategoryViewHolder(private val mBinding: ItemNodenavViewCategoryBinding) :
        BaseViewHolder(mBinding.root), NavItemViewModel.NodeListItemViewModelListener {

        private var navItemViewModel: NavItemViewModel? = null

        override fun onBind(position: Int) {
            val item = nodeList[position]
            navItemViewModel = NavItemViewModel(this, item)
            mBinding.viewModel = navItemViewModel
            mBinding.executePendingBindings()
        }

        override fun onItemClick(nodeId: Int) {

        }

    }

    fun clearItems() {
        nodeList.clear()
    }

    fun addItems(nodesInfo: List<NodesInfo.Item.NodeItem>) {
        nodeList.addAll(nodesInfo)
        notifyDataSetChanged()
    }
}