package com.ddddl.v2ex.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ddddl.v2ex.BR
import com.ddddl.v2ex.R
import com.ddddl.v2ex.adapter.TopicsAdapter
import com.ddddl.v2ex.base.BaseFragment
import com.ddddl.v2ex.data.bean.TopicStartInfo
import com.ddddl.v2ex.databinding.FragmentTopicsBinding
import com.ddddl.v2ex.navigator.TopicsNavigator
import com.ddddl.v2ex.view.LinearLayoutColorDivider
import com.ddddl.v2ex.viewmodel.TopicsViewModel
import java.util.ArrayList

class TopicsFragment : BaseFragment<FragmentTopicsBinding, TopicsViewModel>(),
    TopicsNavigator {

    companion object {
        fun newInstance(): TopicsFragment {
            val args = Bundle()
            val fragment = TopicsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var mTopicsViewModel: TopicsViewModel
    private lateinit var mFragmentTopicsBinding: FragmentTopicsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mTopicsViewModel.navigator = this
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFragmentTopicsBinding = viewDataBinding
        setUp()
        showLoading()
        mTopicsViewModel.topicListLiveData.observe(this,
            Observer<List<TopicStartInfo.Item>> {
                mTopicsViewModel.addDataToList(it)
            })
    }

    private fun setUp() {
        val topicsAdapter = TopicsAdapter(ArrayList<TopicStartInfo.Item>())
//        val valueAnimator = ValueAnimator.ofInt(100, 0)
        mFragmentTopicsBinding.rcvTopics.apply {
            layoutManager = LinearLayoutManager(context).apply {
                orientation = RecyclerView.VERTICAL
            }

            addItemDecoration(
                LinearLayoutColorDivider(
                    resources,
                    R.color.node_nav_color,
                    R.dimen.item_divider,
                    LinearLayoutManager.VERTICAL
                )
            )
            adapter = topicsAdapter
//            var oldY = 0
//            setOnTouchListener { v, event ->
//                when (event.actionMasked) {
//                    MotionEvent.ACTION_DOWN -> {
//                        oldY = event.y.toInt()
//                    }
//                    MotionEvent.ACTION_MOVE -> {
//                        var newY = event.y.toInt()
//                        if (newY - oldY > 3) {
//                            val lp: ConstraintLayout.LayoutParams = layoutParams as ConstraintLayout.LayoutParams
//
//                            lp.topMargin += newY - oldY
//                            layoutParams = lp
//                            requestLayout()
//                            oldY = newY
//                        }
//                    }
//                    MotionEvent.ACTION_UP -> {
//                        val lp: ConstraintLayout.LayoutParams = layoutParams as ConstraintLayout.LayoutParams
//                        valueAnimator.addUpdateListener {
//                            val evaluator = IntEvaluator()
//                            lp.topMargin = evaluator.evaluate(it.animatedFraction, lp.topMargin, 0)
//                            layoutParams = lp
//                            requestLayout()
//                        }
//                        valueAnimator.start()
//                    }
//                }
//
//                return@setOnTouchListener false
//            }

        }


    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_topics
    }

    override fun getViewModel(): TopicsViewModel {
        mTopicsViewModel = ViewModelProviders.of(this).get(TopicsViewModel::class.java)
        return mTopicsViewModel
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun showLoading() {

    }

    override fun noNetWork() {

    }

    override fun handleError(throwable: Throwable) {

    }

    override fun loadMore() {

    }

    override fun showEmpty() {

    }
}