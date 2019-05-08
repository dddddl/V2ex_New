package com.ddddl.v2ex.base;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by liang.liu on 2018/3/14.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder{
    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void onBind(int position);
}
