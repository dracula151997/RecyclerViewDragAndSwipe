package com.project.semicolon.recyclerviewdragandswipe;

public interface ItemTouchHelperViewHolder {
    /**
     * Called when the {@link androidx.recyclerview.widget.ItemTouchHelper} first registers
     * an item as being moved or swiped.
     * Implementation should update the item view to indicate it's active state.
     */
    void onItemSelected();

    /**
     * Called when the {@link androidx.recyclerview.widget.ItemTouchHelper} has complete the move
     * or swipe, and active item state should be cleared.
     */
    void onItemClear();
}
