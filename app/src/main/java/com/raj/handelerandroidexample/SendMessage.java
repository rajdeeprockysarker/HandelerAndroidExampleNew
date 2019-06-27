package com.raj.handelerandroidexample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SendMessage extends AppCompatActivity {

    Handler handler;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
        progressBar=(ProgressBar)findViewById(R.id.test1);


        Thread t=new MyThread();
        t.start();



        handler=new Handler() {

            @Override
            public void handleMessage(Message msg) {
                //TODO: Handle different types of messages
                Bundle b = msg.getData();
                Integer value = b.getInt("KEY");
                Log.v("tag",""+value);
                progressBar.setProgress(value);

            }

            @Override
            public String getMessageName(Message message) {
                return super.getMessageName(message);
            }
        };




    }


    class MyThread extends Thread{
        @Override
        public void run() {
            super.run();

           // Message message=Message.obtain();
            for(int i=0;i<100;i++){
                try {
                    Thread.sleep(100);

                    final Message msg = new Message();
                    final Bundle b = new Bundle();
                    Integer value = i;
                    b.putInt("KEY", value);
                    msg.setData(b);

                    handler.sendMessage(msg);
                }
                catch (Exception e){

                }

            }

        }
    }
}
