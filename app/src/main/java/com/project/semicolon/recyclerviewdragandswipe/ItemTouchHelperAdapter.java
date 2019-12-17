package com.project.semicolon.recyclerviewdragandswipe;

public interface ItemTouchHelperAdapter {
    boolean onItemMoved(int from, int to);
    void onItemDismiss(int position);
}
