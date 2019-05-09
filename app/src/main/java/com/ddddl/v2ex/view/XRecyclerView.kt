package com.ddddl.v2ex.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView
import timber.log.Timber

class XRecyclerView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0) :
    RecyclerView(context, attrs, defStyle) {

    private var mLastY = 0f
    private var mLastX = 0f

    override fun onTouchEvent(e: MotionEvent): Boolean {
        val action = e.action
        when (action) {
            MotionEvent.ACTION_DOWN -> {
                mLastY = e.y
                mLastX = e.x
                parent.requestDisallowInterceptTouchEvent(true)
            }
            MotionEvent.ACTION_MOVE -> {
                val moveY = e.y
                val moveX = e.x
                if (isIntercept(moveX, moveY)) {
                    parent.requestDisallowInterceptTouchEvent(true)
                } else {
                    parent.requestDisallowInterceptTouchEvent(false)
                }
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL ->
                parent.requestDisallowInterceptTouchEvent(false)
        }

        return super.onTouchEvent(e)
    }

    private fun isIntercept(moveX: Float, moveY: Float): Boolean {
        return Math.abs(moveY - mLastY) - Math.abs(moveX - mLastX) > 8

    }
}
