package com.ddddl.v2ex.viewmodel


import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.ddddl.v2ex.data.bean.TopicStartInfo

/**
 * Created by liang.liu on 2018/3/15.
 */

class TopicItemViewModel(var mListener: TopicItemViewModelListener, private val mTopic: TopicStartInfo.Item) :
    ViewModel() {

    var author: ObservableField<String>

    var title: ObservableField<String>

    var date: ObservableField<String>

    var comment: ObservableField<String>

    var typeTitle: ObservableField<String>

    var imageUrl: ObservableField<String>

    init {

        imageUrl = ObservableField(mTopic.avatar)
        author = ObservableField(mTopic.userName)
        date = ObservableField(mTopic.time)
        comment = ObservableField("评论" + mTopic.commentNum)
        typeTitle = ObservableField(mTopic.tag)
        title = ObservableField(mTopic.title)
    }

    fun onItemClick() {
        mListener.onItemClick(0)
    }

    interface TopicItemViewModelListener {
        fun onItemClick(topicId: Int)
    }
}
