package com.raj.handelerandroidexample;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;

public class HandelerPost extends AppCompatActivity {

    Handler handler;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
        progressBar=(ProgressBar)findViewById(R.id.test1);


        Thread t=new MyThread();
        t.start();



        handler=new Handler();




    }


    class MyThread extends Thread{
        int porgress=0;

        @Override
        public void run() {
            super.run();

           // Message message=Message.obtain();
            for(int i=0;i<100;i++){
                try {
                    Thread.sleep(100);

                    porgress=i;

                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(porgress);
                        }
                    });
                }
                catch (Exception e){

                }

            }

        }
    }
}
