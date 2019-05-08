package com.ddddl.v2ex.viewmodel

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import com.ddddl.v2ex.base.BaseViewModel
import com.ddddl.v2ex.data.bean.NodesInfo
import com.ddddl.v2ex.data.bean.TopicStartInfo
import com.ddddl.v2ex.data.http.V2exApiHelper
import com.ddddl.v2ex.navigator.NodeListNavigator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.ghui.fruit.Fruit

class NodeListViewModel : BaseViewModel<NodeListNavigator>() {

    var nodeList = ObservableArrayList<NodesInfo.Item>()

    var isLoading = ObservableBoolean(false)

    val nodeListLiveData: MutableLiveData<List<NodesInfo.Item>> = MutableLiveData()

    private var v2exApi: V2exApiHelper = V2exApiHelper()

    init {
        fetchData()
    }

    private fun fetchData() {
        isLoading.set(true)
        compositeDisposable.add(
            v2exApi
                .nodes
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ html: String ->
                    isLoading.set(false)
                    val nodesInfo = Fruit().fromHtml<NodesInfo>(html, NodesInfo::class.java)
                    if (nodesInfo != null) {
                        nodeListLiveData.value = nodesInfo.items
                    } else {
                        if (nodeListLiveData.value == null) {
                            navigator.showEmpty()
                        }
                    }
                }, {
                    isLoading.set(false)
                    navigator.handleError(it)
                })
        )
    }

    fun addDataToList(items: List<NodesInfo.Item>) {
        nodeList.addAll(items)
    }


}
