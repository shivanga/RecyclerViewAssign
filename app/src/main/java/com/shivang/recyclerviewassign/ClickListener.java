package com.shivang.recyclerviewassign;

import android.view.View;

/**
 * Created by sa on 3/27/2017.
 */
public interface ClickListener {
    void onClick(View view, int position);

    void onLongClick(View view, int position);
}
