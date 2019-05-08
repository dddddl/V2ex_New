package com.ddddl.v2ex.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableList
import androidx.lifecycle.MutableLiveData
import com.ddddl.v2ex.base.BaseViewModel
import com.ddddl.v2ex.data.bean.TopicStartInfo
import com.ddddl.v2ex.data.http.V2exApiHelper
import com.ddddl.v2ex.navigator.TopicsNavigator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import me.ghui.fruit.Fruit
import timber.log.Timber

class TopicsViewModel : BaseViewModel<TopicsNavigator>() {

    private val v2exApi: V2exApiHelper = V2exApiHelper()

    val topicsObservableArrayList = ObservableArrayList<TopicStartInfo.Item>()

    private val isLoading = ObservableBoolean(false)

    val topicListLiveData: MutableLiveData<List<TopicStartInfo.Item>> = MutableLiveData()

    init {
        Timber.e("TopicsViewModel : create")
        fetchData()
    }

    private fun fetchData() {
        setIsLoading(true)
        compositeDisposable.add(v2exApi
            .getTopicsByNode("all")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ data ->
                val topicStartInfo = Fruit().fromHtml(data, TopicStartInfo::class.java)
                val list = topicStartInfo.items
                if (list != null) {
                    topicListLiveData.setValue(list)
                } else {
                    if (topicListLiveData.value == null) {
                        navigator.showEmpty()
                    }
                }
                setIsLoading(false)
            }, { throwable ->
                setIsLoading(false)
                navigator.handleError(throwable)
            })
        )
    }

    fun addDataToList(topics: List<TopicStartInfo.Item>) {
        topicsObservableArrayList.addAll(topics)
    }

    private fun setIsLoading(isLoading: Boolean) {
        this.isLoading.set(isLoading)
    }
}
