package com.happy.rvdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.happy.rvdemo.R;
import com.happy.rvdemo.domain.Message;

import java.util.List;

/**
 * Created by zhonglongquan on 2017/4/6.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private Context mContext;
    private List<Message> messageList;

    public MessageAdapter(Context context, List<Message> messageList) {
        this.mContext = context;
        this.messageList = messageList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.view_item_message, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Message message = messageList.get(position);
        if (message.getType() == Message.TYPE_RECEIVED) {
            holder.rlReceiveParent.setVisibility(View.VISIBLE);
            holder.rlSendParent.setVisibility(View.GONE);
            holder.tvReceiveContent.setText(">" + message.getContent());
        } else {
            holder.rlReceiveParent.setVisibility(View.GONE);
            holder.rlSendParent.setVisibility(View.VISIBLE);
            holder.tvSendContent.setText(">" + message.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout rlSendParent;
        RelativeLayout rlReceiveParent;
        TextView tvSendContent;
        TextView tvReceiveContent;
        EditText etContent;
        Button btnSend;

        public ViewHolder(View itemView) {
            super(itemView);
            rlSendParent = (RelativeLayout) itemView.findViewById(R.id.rl_send_parent);
            rlReceiveParent = (RelativeLayout) itemView.findViewById(R.id.rl_receive_parent);
            tvSendContent = (TextView) itemView.findViewById(R.id.tv_send);
            tvReceiveContent = (TextView) itemView.findViewById(R.id.tv_receive);
            etContent = (EditText) itemView.findViewById(R.id.et_content);
            btnSend = (Button) itemView.findViewById(R.id.bt_send);
        }

    }

}
