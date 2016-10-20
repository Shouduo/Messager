package com.shouduo.messager;

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

        initMsg();
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
                    if ("苟利国家生死以".equals(content)) {
                        Msg msgReply = new Msg("岂因祸福避趋之~", Msg.TYPE_RECEIVED, R.drawable.kevin);
                        msgList.add(msgReply);
                        adapter.notifyDataSetChanged();
                        msgListView.setSelection(msgList.size());
                    }
                }
            }
        });
    }

    private void initMsg() {
        Msg msg1 = new Msg("Hello?", Msg.TYPE_RECEIVED, R.drawable.kevin);
        msgList.add(msg1);
        Msg msg2 = new Msg("Excited. Who is that", Msg.TYPE_SENT, R.drawable.nickyoung);
        msgList.add(msg2);
        Msg msg3 = new Msg("This is Wallace. Nice talking to you.", Msg.TYPE_RECEIVED, R.drawable.kevin);
        msgList.add(msg3);
        Msg msg4 = new Msg("          ;;;\n" +
                "❐..❐- ∂  \n" +
                "  '～' }  /\n" +
                "   ︶ ", Msg.TYPE_SENT, R.drawable.nickyoung);
        msgList.add(msg4);
    }
}