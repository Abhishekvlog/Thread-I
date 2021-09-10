package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button task1;
    private Button task2;
    private WorkerThread thread;
    private Runnable taskOne = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    private Runnable tasktwo = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thread = new WorkerThread();
        thread.start();
        task1 = findViewById(R.id.tvData);
        task2 = findViewById(R.id.tvTask2);
        task1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thread.addTaskToMessageQueue(taskOne);
            }
        });
        task2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thread.addTaskToMessageQueue(tasktwo);
            }
        });

    }

}