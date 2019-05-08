package com.ddddl.v2ex.navigator

interface TopicsNavigator {

    fun showEmpty()

    fun showLoading()

    fun noNetWork()

    fun handleError(throwable: Throwable)

    fun loadMore()

}