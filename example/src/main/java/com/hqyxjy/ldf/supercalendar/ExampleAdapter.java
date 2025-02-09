package com.hqyxjy.ldf.supercalendar;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by ldf on 17/6/14.
 */

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private final Context context;
    private String[] titles;

    public ExampleAdapter(Context context) {
        titles = context.getResources().getStringArray(R.array.titles);
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ExampleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(titles[position]);
    }

    @Override
    public int getItemCount() {
        return titles == null ? 0 : titles.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.text_view);
            view.setOnClickListener(v -> Log.d("ViewHolder", "onClick--> position = " + getPosition()));
        }
    }
}
