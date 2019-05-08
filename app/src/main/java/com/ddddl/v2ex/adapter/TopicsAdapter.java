package com.ddddl.v2ex.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ddddl.v2ex.base.BaseViewHolder;
import com.ddddl.v2ex.data.bean.TopicStartInfo;
import com.ddddl.v2ex.databinding.ItemTopicViewBinding;
import com.ddddl.v2ex.viewmodel.TopicItemViewModel;
import timber.log.Timber;

import java.util.List;

public class TopicsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<TopicStartInfo.Item> mTopicList;

    public TopicsAdapter(List<TopicStartInfo.Item> topicList) {
        mTopicList = topicList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTopicViewBinding topicViewBinding = ItemTopicViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);

        return new TopicViewHolder(topicViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((TopicViewHolder) holder).onBind(position);
    }

    @Override
    public int getItemCount() {
        if (mTopicList != null && mTopicList.size() > 0)
            return mTopicList.size();
        else
            return 0;
    }

    public void addItems(List<TopicStartInfo.Item> list) {
        mTopicList.addAll(list);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mTopicList.clear();
    }

    private class TopicViewHolder extends BaseViewHolder implements TopicItemViewModel.TopicItemViewModelListener {


        private final ItemTopicViewBinding mBinding;
        private TopicItemViewModel topicItemViewModel;

        public TopicViewHolder(ItemTopicViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            TopicStartInfo.Item item = mTopicList.get(position);
            topicItemViewModel = new TopicItemViewModel(this, item);
            mBinding.setViewModel(topicItemViewModel);
            mBinding.executePendingBindings();
        }

        @Override
        public void onItemClick(int topicId) {
            if (topicId != 0) {
                try {
//                    Intent intent = new Intent();
//                    intent.setAction(Intent.ACTION_VIEW);
//                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
//                    itemView.getContext().startActivity(intent);
                } catch (Exception e) {
                    Timber.d("url error");
                }
            }
        }
    }
}
