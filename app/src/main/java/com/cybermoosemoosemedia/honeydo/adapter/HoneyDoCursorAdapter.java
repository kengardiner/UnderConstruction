package com.cybermoosemoosemedia.honeydo.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.cybermoosemoosemedia.honeydo.R;

public class HoneyDoCursorAdapter extends SimpleCursorAdapter {
    public HoneyDoCursorAdapter(Context context, int layout, Cursor c, String[]
            from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
    }
    //to use a viewholder, you must override the following two methods and define a ViewHolder class
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return super.newView(context, cursor, parent);
    }
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        super.bindView(view, context, cursor);
        ViewHolder holder = (ViewHolder) view.getTag();
        if (holder == null) {
            holder = new ViewHolder();
            holder.colImp = cursor.getColumnIndexOrThrow(HoneyDoRemindersDbAdapter.COL_IMPORTANT);
            holder.listTab = view.findViewById(R.id.row_tab);
            view.setTag(holder);
        }if (cursor.getInt(holder.colImp) > 0) {
            holder.listTab.setBackgroundResource(R.drawable.red_circle);
        } else {
            holder.listTab.setBackgroundResource(R.drawable.green_circle);
        }
    }
    static class ViewHolder {
        //store the column index
        int colImp;
        //store the view
        View listTab;
    }
}