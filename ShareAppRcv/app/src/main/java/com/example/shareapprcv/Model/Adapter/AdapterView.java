package com.example.shareapprcv.Model.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shareapprcv.Model.DataModel;
import com.example.shareapprcv.R;

import java.util.List;

public class AdapterView extends RecyclerView.Adapter<AdapterView.AdapterViewHolder> {

    private List<DataModel> list;
    private Context mContext;

    public AdapterView(Context mContext, List<DataModel> list) {
        this.list = list;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public AdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.itemview, parent, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewHolder holder, int position) {
        if (list.isEmpty()){
            Log.d("Adapter Exception","No data fount database table");
        } else {
            DataModel dataModel= list.get(position);
            holder.email.setText(dataModel.getEmail());
            holder.time.setText(dataModel.getCurrentTime());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        TextView email, time;

        public AdapterViewHolder(@NonNull View itemView) {
            super(itemView);

            email= itemView.findViewById(R.id.showEmail);
            time= itemView.findViewById(R.id.showTime);
        }
    }
}
