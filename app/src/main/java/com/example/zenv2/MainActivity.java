package com.example.zenv2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.ramotion.foldingcell.FoldingCell;
import com.varunest.sparkbutton.SparkButton;
import com.varunest.sparkbutton.SparkEventListener;

import org.json.JSONException;
import org.json.JSONObject;

import ticker.views.com.ticker.widgets.circular.timer.callbacks.CircularViewCallback;
import ticker.views.com.ticker.widgets.circular.timer.view.CircularView;


public class MainActivity extends AppCompatActivity {

    private String name = "You";
    private Bundle a;
    private MediaPlayer theCraft;
    private MediaPlayer theCraft2;
    private MediaPlayer theCraft3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        a = savedInstanceState;
        playMusic();

        //https://github.com/varunest/SparkButton
        final SparkButton start = findViewById(R.id.spark_button);
        start.setEventListener(new SparkEventListener(){
            @Override
            public void onEvent(ImageView button, boolean buttonState) {
                if (buttonState) {
                    new CountDownTimer(820, 1000) {
                        public void onFinish() {
                            enterNameMenu();
                        }
                        public void onTick(long millisUntilFinished) {
                        }
                    }.start();
                } else {
                }
            }
            @Override
            public void onEventAnimationEnd(ImageView button, boolean buttonState) {
            }
            @Override
            public void onEventAnimationStart(ImageView button, boolean buttonState) {
            }
        });
    }
    public void enterNameMenu() {
        setContentView(R.layout.enter_name);
        SparkButton secondStart = findViewById(R.id.spark_button2);
        secondStart.setEventListener(new SparkEventListener(){
            @Override
            public void onEvent(ImageView button, boolean buttonState) {
                if (buttonState) {
                    EditText nameGetter = findViewById(R.id.enterName);
                    if (!nameGetter.getText().toString().equals("")) {
                        name = nameGetter.getText().toString();
                    }
                    new CountDownTimer(820, 1000) {
                        public void onFinish() {
                            enterTabbedMenu();
                        }
                        public void onTick(long millisUntilFinished) {
                        }
                    }.start();
                } else {
                }
            }
            @Override
            public void onEventAnimationEnd(ImageView button, boolean buttonState) {
            }
            @Override
            public void onEventAnimationStart(ImageView button, boolean buttonState) {
            }
        });
    }

    public void enterTabbedMenu() {
        setContentView(R.layout.foldingtabs);
        TextView tabTitle = findViewById(R.id.tabTitle);
        tabTitle.setText(name + ", open your mind");

        //https://github.com/Ramotion/folding-cell-android
        final FoldingCell fc = (FoldingCell) findViewById(R.id.folding_cell);
        fc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc.toggle(false);
            }
        });

        final FoldingCell fc2 = (FoldingCell) findViewById(R.id.folding_cell2);
        fc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc2.toggle(false);
            }
        });

        final FoldingCell fc3 = (FoldingCell) findViewById(R.id.folding_cell3);
        fc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fc3.toggle(false);
            }
        });



        final SparkButton three = findViewById(R.id.spark_button3);
        three.setEventListener(new SparkEventListener(){
            @Override
            public void onEvent(ImageView button, boolean buttonState) {
                if (buttonState) {
                    new CountDownTimer(820, 1000) {
                        public void onFinish() {
                            enterMenuBeforeTimer();
                        }
                        public void onTick(long millisUntilFinished) {
                        }
                    }.start();
                } else {
                }
            }
            @Override
            public void onEventAnimationEnd(ImageView button, boolean buttonState) {
            }
            @Override
            public void onEventAnimationStart(ImageView button, boolean buttonState) {
            }
        });

    }
    public void enterMenuBeforeTimer() {
        setContentView(R.layout.beforetimer);
        final SparkButton four = findViewById(R.id.spark_button4);
        four.setEventListener(new SparkEventListener(){
            @Override
            public void onEvent(ImageView button, boolean buttonState) {
                if (buttonState) {
                    new CountDownTimer(820, 1000) {
                        public void onFinish() {
                            enterTimer();
                        }
                        public void onTick(long millisUntilFinished) {
                        }
                    }.start();
                } else {
                }
            }
            @Override
            public void onEventAnimationEnd(ImageView button, boolean buttonState) {
            }
            @Override
            public void onEventAnimationStart(ImageView button, boolean buttonState) {
            }
        });

    }
    public void enterTimer() {
        setContentView(R.layout.activity_main);
        final SparkButton donzo = findViewById(R.id.spark_button5);
        donzo.setVisibility(View.GONE);
        //https://github.com/rehmanmuradali/ticker
        final CircularView circularViewWithTimer = findViewById(R.id.timer);
        circularViewWithTimer.startTimer();
        CircularView.OptionsBuilder builderWithTimer =
                new CircularView.OptionsBuilder()
                        .shouldDisplayText(true)
                        .setCounterInSeconds(60)
                        .setCircularViewCallback(new CircularViewCallback() {
                            @Override
                            public void onTimerFinish() {
                                donzo.setVisibility(View.VISIBLE);
                                stopMusic2();
                                playMusic3();
                                Toast.makeText(MainActivity.this, "Congratulations: Meditation Finished ", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onTimerCancelled() {
                                Toast.makeText(MainActivity.this, "CircularCallback: Timer Cancelled ", Toast.LENGTH_SHORT).show();
                            }
                        });
        circularViewWithTimer.setOptions(builderWithTimer);
        circularViewWithTimer.setVisibility(View.GONE);
        stopMusic();
        playMusic2();
        new CountDownTimer(1200, 1000) {
            public void onFinish() {
                circularViewWithTimer.setVisibility(View.VISIBLE);
            }
            public void onTick(long millisUntilFinished) {
            }
        }.start();
        donzo.setEventListener(new SparkEventListener(){
            @Override
            public void onEvent(ImageView button, boolean buttonState) {
                if (buttonState) {
                    new CountDownTimer(820, 1000) {
                        public void onFinish() {
                            finish();
                        }
                        public void onTick(long millisUntilFinished) {
                        }
                    }.start();
                } else {
                }
            }
            @Override
            public void onEventAnimationEnd(ImageView button, boolean buttonState) {
            }
            @Override
            public void onEventAnimationStart(ImageView button, boolean buttonState) {
            }
        });
    }
    public void finish() {
        setContentView(R.layout.finishedmeditation);
        final TextView quoteHolder = findViewById(R.id.quote);


        //https://github.com/lukePeavey/quotable
        String URL = "https://api.quotable.io/random";

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest objectRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("rest response", response.toString());
                        try {
                            String quote = response.get("content").toString();
                            String author = response.get("author").toString();
                            quoteHolder.setText(quote + " ~ " + author);
                        } catch (JSONException e) {
                            Log.e("MYAPP", "unexpected JSON exception", e);
                            // Do something to recover ... or kill the app.
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("rest response", error.toString());
                    }
                }
        );

        requestQueue.add(objectRequest);











        SparkButton six = findViewById(R.id.spark_button6);
        six.setEventListener(new SparkEventListener(){
            @Override
            public void onEvent(ImageView button, boolean buttonState) {
                if (buttonState) {
                    // Button is active
                    new CountDownTimer(820, 1000) {
                        public void onFinish() {
                            // When timer is finished
                            // Execute your code here
                            stopMusic3();
                            restart();
                        }
                        public void onTick(long millisUntilFinished) {
                            // millisUntilFinished    The amount of time until finished.
                        }
                    }.start();
                } else {
                    // Button is inactive
                }
            }
            @Override
            public void onEventAnimationEnd(ImageView button, boolean buttonState) {
            }
            @Override
            public void onEventAnimationStart(ImageView button, boolean buttonState) {
            }
        });
    }
    public void restart() {
        setContentView(R.layout.main_menu);
        playMusic();
        name = "You";
        final SparkButton start = findViewById(R.id.spark_button);
        start.setEventListener(new SparkEventListener(){
            @Override
            public void onEvent(ImageView button, boolean buttonState) {
                if (buttonState) {
                    // Button is active
                    new CountDownTimer(820, 1000) {
                        public void onFinish() {
                            // When timer is finished
                            // Execute your code here
                            enterNameMenu();
                        }
                        public void onTick(long millisUntilFinished) {
                            // millisUntilFinished    The amount of time until finished.
                        }
                    }.start();
                } else {
                    // Button is inactive
                }
            }
            @Override
            public void onEventAnimationEnd(ImageView button, boolean buttonState) {
            }
            @Override
            public void onEventAnimationStart(ImageView button, boolean buttonState) {
            }
        });
    }
    public void playMusic() {
        theCraft = MediaPlayer.create(getApplicationContext(), R.raw.subwoofer);
        theCraft.setLooping(true);
        theCraft.start();
    }
    public void stopMusic() {
        theCraft.stop();
    }
    public void playMusic2() {
        theCraft2 = MediaPlayer.create(getApplicationContext(), R.raw.haggstrom);
        theCraft2.setLooping(true);
        theCraft2.start();
    }
    public void stopMusic2() {
        theCraft2.stop();
    }
    public void playMusic3() {
        theCraft3 = MediaPlayer.create(getApplicationContext(), R.raw.minecraft);
        theCraft3.setLooping(true);
        theCraft3.start();
    }
    public void stopMusic3() {
        theCraft3.stop();
    }
}
