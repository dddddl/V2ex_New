package com.ddddl.v2ex.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ddddl.v2ex.base.BaseViewHolder;
import com.ddddl.v2ex.data.bean.NodesInfo;
import com.ddddl.v2ex.databinding.ItemNodeViewBinding;
import com.ddddl.v2ex.databinding.ItemTopicViewBinding;
import com.ddddl.v2ex.viewmodel.NodeItemViewModel;
import com.ddddl.v2ex.viewmodel.TopicItemViewModel;
import timber.log.Timber;

import java.util.ArrayList;
import java.util.List;

public class NodeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NodesInfo.Item.NodeItem> nodeItemList = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemNodeViewBinding itemNodeViewBinding = ItemNodeViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new NodeViewHolder(itemNodeViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((NodeViewHolder) holder).onBind(position);
    }

    @Override
    public int getItemCount() {
        if (nodeItemList != null && nodeItemList.size() > 0)
            return nodeItemList.size();
        else
            return 0;
    }

    public void addItems(List<NodesInfo.Item.NodeItem> list) {
        nodeItemList.addAll(list);
        notifyDataSetChanged();
    }

    public void clearItems() {
        nodeItemList.clear();
    }

    private class NodeViewHolder extends BaseViewHolder implements NodeItemViewModel.NodeItemViewModelListener {


        private final ItemNodeViewBinding mBinding;

        public NodeViewHolder(ItemNodeViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            NodesInfo.Item.NodeItem item = nodeItemList.get(position);
            NodeItemViewModel nodeItemViewModel = new NodeItemViewModel(this, item);
            mBinding.setViewModel(nodeItemViewModel);
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
                    Timber.e("click node");
                } catch (Exception e) {
                    Timber.d("url error");
                }
            }
        }
    }
}
