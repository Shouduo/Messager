package com.shouduo.messager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends BaseActivity {

    private ListView msgListView;
    private EditText inputText;
    private Button send;
    private MsgAdapter adapter;

    private List<Msg> msgList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent intent = getIntent();
        People people = (People) intent.getSerializableExtra("people");

        setTitle(people.getName());
        msgList = people.getMsgList();

        adapter = new MsgAdapter(this, R.layout.msg_item, msgList);
        inputText = (EditText) findViewById(R.id.input_text);
        send = (Button) findViewById(R.id.send);
        msgListView = (ListView) findViewById(R.id.msg_list_view);
        msgListView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.TYPE_SENT, R.drawable.nickyoung);
                    msgList.add(msg);
                    adapter.notifyDataSetChanged();
                    msgListView.setSelection(msgList.size());
                    inputText.setText("");
                    if ("岂因祸福避趋之".equals(content)) {
                        Msg msgReply = new Msg("只做了一点微小的工作，hin惭愧", Msg.TYPE_RECEIVED, R.drawable.elder);
                        msgList.add(msgReply);
                        adapter.notifyDataSetChanged();
                        msgListView.setSelection(msgList.size());
                    }
                }
            }
        });
    }
}
