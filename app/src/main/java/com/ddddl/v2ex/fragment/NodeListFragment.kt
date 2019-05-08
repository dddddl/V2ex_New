package com.ddddl.v2ex.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ddddl.v2ex.BR
import com.ddddl.v2ex.R
import com.ddddl.v2ex.adapter.NodeListAdapter
import com.ddddl.v2ex.base.BaseFragment
import com.ddddl.v2ex.data.bean.NodesInfo
import com.ddddl.v2ex.databinding.FragmentNodelistBinding
import com.ddddl.v2ex.navigator.NodeListNavigator
import com.ddddl.v2ex.viewmodel.NodeListViewModel
import com.google.android.flexbox.*
import timber.log.Timber

class NodeListFragment : BaseFragment<FragmentNodelistBinding, NodeListViewModel>(), NodeListNavigator {

    private lateinit var nodeListViewModel: NodeListViewModel
    private lateinit var nodeListDataBinding: FragmentNodelistBinding

    companion object {
        fun newInstance(): NodeListFragment {
            val args = Bundle()
            val fragment = NodeListFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_nodelist
    }


    override fun getViewModel(): NodeListViewModel {
        nodeListViewModel = ViewModelProviders.of(this).get(NodeListViewModel::class.java)
        return nodeListViewModel
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate")
        nodeListViewModel.navigator = this
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nodeListDataBinding = viewDataBinding
        setUp()
        nodeListViewModel.nodeListLiveData.observe(this,
            Observer<List<NodesInfo.Item>> {
                nodeListViewModel.addDataToList(it)
            })

    }

    private fun setUp() {
        nodeListDataBinding.rcvNodes.apply {

            adapter = NodeListAdapter()

            layoutManager = FlexboxLayoutManager(context).apply {
                flexWrap = FlexWrap.WRAP
                flexDirection = FlexDirection.ROW
                alignItems = AlignItems.STRETCH
                justifyContent = JustifyContent.FLEX_START
            }
//            layoutManager = LinearLayoutManager(context).apply {
//                orientation = RecyclerView.VERTICAL
//            }
        }
    }

    override fun showEmpty() {

    }

    override fun showLoading() {

    }

    override fun noNetWork() {

    }

    override fun handleError(throwable: Throwable) {

    }
}