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
        String name = intent.getStringExtra("name");

        setTitle(name);
        switch (name) {
            case "Kevin":
                MockKevinMsg();
                break;
            case "Elder":
                MockElderMsg();
                break;
            default:
                break;
        }

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

    private void MockKevinMsg() {
        Msg msg1 = new Msg("Hello?", Msg.TYPE_RECEIVED, R.drawable.kevin);
        msgList.add(msg1);
        Msg msg2 = new Msg("Excited. Who is that", Msg.TYPE_SENT, R.drawable.nickyoung);
        msgList.add(msg2);
        Msg msg3 = new Msg("在下骚文，有何贵干", Msg.TYPE_RECEIVED, R.drawable.kevin);
        msgList.add(msg3);
        Msg msg4 = new Msg("他强任他强，劳资尼克杨", Msg.TYPE_SENT, R.drawable.nickyoung);
        msgList.add(msg4);
    }

    private void MockElderMsg() {
        Msg msg1 = new Msg("西方记者?", Msg.TYPE_RECEIVED, R.drawable.elder);
        msgList.add(msg1);
        Msg msg2 = new Msg("蛤？", Msg.TYPE_SENT, R.drawable.nickyoung);
        msgList.add(msg2);
        Msg msg3 = new Msg("当时我就说了两句诗", Msg.TYPE_RECEIVED, R.drawable.elder);
        msgList.add(msg3);
        Msg msg4 = new Msg("???", Msg.TYPE_SENT, R.drawable.nickyoung);
        msgList.add(msg4);
        Msg msg5 = new Msg("苟利国家生死以……", Msg.TYPE_RECEIVED, R.drawable.elder);
        msgList.add(msg5);
    }
}
