package com.ddddl.v2ex.navigator

interface NodeListNavigator {

    fun showEmpty()

    fun showLoading()

    fun noNetWork()

    fun handleError(throwable: Throwable)

}