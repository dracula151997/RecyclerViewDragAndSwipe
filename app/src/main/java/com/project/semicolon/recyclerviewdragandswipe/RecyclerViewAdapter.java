package com.project.semicolon.recyclerviewdragandswipe;

import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.semicolon.recyclerviewdragandswipe.databinding.ListItemBinding;

import java.util.Collections;
import java.util.List;

public class RecyclerViewAdapter extends
        RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>
        implements ItemTouchHelperAdapter {
    private List<Contact> item;
    private OnStartDragListener onStartDragListener;

    public void setItem(List<Contact> item) {
        this.item = item;
        notifyDataSetChanged();
    }

    public void setOnStartDragListener(OnStartDragListener onStartDragListener) {
        this.onStartDragListener = onStartDragListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemBinding binding = ListItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.binding.setContact(item.get(position));
        holder.binding.handle.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    onStartDragListener.onStartDrag(holder);
                }
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    @Override
    public boolean onItemMoved(int from, int to) {
        if (from < to) {
            for (int i = from; i < to; i++) {
                Collections.swap(item, i, i + 1);
            }
        } else {
            for (int i = from; i > to; i--) {
                Collections.swap(item, i, i - 1);
            }
        }

        notifyItemMoved(from, to);
        return true;
    }

    //When the user swipe recyclerView item, remove that item from list and notify the adapter.
    @Override
    public void onItemDismiss(int position) {
        item.remove(position);
        notifyItemRemoved(position);

    }

    public class ViewHolder extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {
        private ListItemBinding binding;

        public ViewHolder(@NonNull ListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onItemSelected() {
            itemView.setBackgroundColor(Color.LTGRAY);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                itemView.setElevation(3.0f);
            }
        }

        @Override
        public void onItemClear() {
            itemView.setBackgroundColor(0);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                itemView.setElevation(0.0f);
            }

        }
    }


    public interface OnStartDragListener {
        void onStartDrag(RecyclerView.ViewHolder viewHolder);
    }
}
