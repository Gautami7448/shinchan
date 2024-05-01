package com.example.openurl;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHolder> {

    private List<TableRow> tableRows;
    private Context context;

    public TableAdapter(List<TableRow> tableRows, Context context) {
        this.tableRows = tableRows;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final TableRow row = tableRows.get(position);
        holder.languageTextView.setText(row.getLanguage());
        holder.creatorTextView.setText(row.getCreator());
//        holder.referenceTextView.setText(row.getReference());

        holder.referenceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the URL in a browser when clicked
                String url = row.getReference();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tableRows.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView languageTextView;
        TextView creatorTextView;
        Button referenceButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            languageTextView = itemView.findViewById(R.id.languageTextView);
            creatorTextView = itemView.findViewById(R.id.creatorTextView);
            referenceButton = itemView.findViewById(R.id.referenceButton);
        }
    }
}

