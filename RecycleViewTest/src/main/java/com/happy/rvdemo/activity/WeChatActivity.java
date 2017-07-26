package com.happy.rvdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.happy.rvdemo.R;
import com.happy.rvdemo.adapter.MessageAdapter;
import com.happy.rvdemo.domain.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeChatActivity extends AppCompatActivity {

    private static final String[] replyList = {"干你", "你瞎说啥呢", "我给你讲个笑话吧", "就问你服不服"};

    private RecyclerView recyclerView;

    private Button btnSendView;

    private EditText etContentView;

    private MessageAdapter messageAdapter;

    private ArrayList<Message> messageList = new ArrayList<>();

    private Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_we_chat);

        recyclerView = (RecyclerView) findViewById(R.id.rv_list);
        btnSendView = (Button) findViewById(R.id.bt_send);
        etContentView = (EditText) findViewById(R.id.et_content);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        messageAdapter = new MessageAdapter(this, initData());
        recyclerView.setAdapter(messageAdapter);

        btnSendView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = etContentView.getText().toString().trim();
                if (!TextUtils.isEmpty(content)) {
                    Message message = new Message(content, Message.TYPE_SEND);
                    addMessage(message);
                    int position = random.nextInt(replyList.length);
                    Message replyMessage = new Message(replyList[position], Message.TYPE_RECEIVED);
                    addMessage(replyMessage);
                    etContentView.setText("");
                }
            }
        });
    }

    private void addMessage(Message message) {
        messageList.add(message);
        messageAdapter.notifyItemInserted(messageList.size() - 1);
        recyclerView.scrollToPosition(messageList.size() - 1);
    }

    private List<Message> initData() {

        Message message01 = new Message("哈咯，你好，在吗", Message.TYPE_RECEIVED);
        Message message02 = new Message("废话，有事说事", Message.TYPE_SEND);

        messageList.add(message01);
        messageList.add(message02);

        return messageList;
    }
}
