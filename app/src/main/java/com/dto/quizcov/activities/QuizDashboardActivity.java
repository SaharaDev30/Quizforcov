package com.dto.quizcov.activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.dto.quizcov.MainActivity;
import com.dto.quizcov.R;
import com.dto.quizcov.models.QuestionHolder;

import java.util.ArrayList;
import java.util.HashMap;

public class QuizDashboardActivity extends AppCompatActivity {
    private Context mContext;
    private TextView mTvQuestionNo, mTvQuestion;
    private Button mBtnOptionA, mBtnOptionB, mBtnOptionC, mBtnOptionD, mBtnOptionE, mBtnOptionF;
    private ArrayList<QuestionHolder> questionHolderArrayList;
    private int questionTracker;
    private Button which;
    private boolean isCorrect = false;
    private HashMap<String,Button> optionsMapping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_dashboard);
        int PERMISSION_ALL = 1;
        String[] PERMISSIONS = {
                Manifest.permission.CALL_PHONE,
                Manifest.permission.INTERNET
        };

        if (!hasPermissions(this, PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_ALL);
        }
        initialize();
      //  addQuestions();
        loadQuestions();
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questionTracker==4){
                    int res=0;
if(questionHolderArrayList.get(3).getOptionB().equals("true") || questionHolderArrayList.get(3).getOptionC().equals("true")){
    if(questionHolderArrayList.get(0).getOptionA().equals("true"))res+=2;
    if(questionHolderArrayList.get(0).getOptionB().equals("true"))res+=2;
    if(questionHolderArrayList.get(0).getOptionC().equals("true"))res+=2;
    if(questionHolderArrayList.get(0).getOptionD().equals("true"))res+=1;
    if(questionHolderArrayList.get(0).getOptionE().equals("true"))res+=1;
    if(questionHolderArrayList.get(0).getOptionF().equals("true"))res+=2;

         if(questionHolderArrayList.get(1).getOptionA().equals("true")||
            questionHolderArrayList.get(1).getOptionB().equals("true")||
            questionHolderArrayList.get(1).getOptionC().equals("true")||
            questionHolderArrayList.get(1).getOptionD().equals("true"))res++;

    if(questionHolderArrayList.get(2).getOptionA().equals("true"))res++;
    else if(questionHolderArrayList.get(2).getOptionB().equals("true"))res+=2;
    else if(questionHolderArrayList.get(2).getOptionC().equals("true"))res+=3;

    if(questionHolderArrayList.get(3).getOptionA().equals("true"))res+=5;
}else{
    if(questionHolderArrayList.get(0).getOptionA().equals("true"))res+=1;
    if(questionHolderArrayList.get(0).getOptionB().equals("true"))res+=2;
    if(questionHolderArrayList.get(0).getOptionC().equals("true"))res+=2;
    if(questionHolderArrayList.get(0).getOptionF().equals("true"))res+=2;

    if(questionHolderArrayList.get(3).getOptionA().equals("true"))res+=5;
}
System.out.println(res);
                    Intent intent=new Intent(QuizDashboardActivity.this, MainActivity.class);
                    intent.putExtra("res",res);
                    startActivity(intent);
                    finish();
                }else loadQuestions();

            }
        });
    }
    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
    private void initialize() {
        mContext = QuizDashboardActivity.this;
        mTvQuestion = findViewById(R.id.tv_question);
        mTvQuestionNo = findViewById(R.id.tv_question_no);
        mBtnOptionA = findViewById(R.id.a);
        mBtnOptionB = findViewById(R.id.b);
        mBtnOptionC = findViewById(R.id.c);
        mBtnOptionD = findViewById(R.id.d);
        mBtnOptionE = findViewById(R.id.e);
        mBtnOptionF = findViewById(R.id.f);
        questionTracker = 0;
        questionHolderArrayList = new ArrayList<>();
        optionsMapping = new HashMap<>();
        optionsMapping.put("a",mBtnOptionA);
        optionsMapping.put("b",mBtnOptionB);
        optionsMapping.put("c",mBtnOptionC);
        optionsMapping.put("d",mBtnOptionD);
        optionsMapping.put("e",mBtnOptionE);
        optionsMapping.put("f",mBtnOptionF);
    }

    private void loadQuestions() {
        mTvQuestionNo.setText(String.valueOf(questionTracker+1));
        questionHolderArrayList.add(new QuestionHolder("","","","","","",""));
        if(questionTracker==0){
           // getResources().getString(R.string.q1_a)
            mTvQuestion.setText(getResources().getString(R.string.q1));
            mBtnOptionA.setText(getResources().getString(R.string.q1_a));
            mBtnOptionB.setText(getResources().getString(R.string.q1_b));
            mBtnOptionC.setText(getResources().getString(R.string.q1_c));
            mBtnOptionD.setText(getResources().getString(R.string.q1_d));
            mBtnOptionE.setText(getResources().getString(R.string.q1_e));
            mBtnOptionF.setText(getResources().getString(R.string.q1_f));
        }else if(questionTracker==1){
            // getResources().getString(R.string.q1_a)
            mTvQuestion.setText(getResources().getString(R.string.q2));
            mBtnOptionA.setText(getResources().getString(R.string.q2_a));
            mBtnOptionB.setText(getResources().getString(R.string.q2_b));
            mBtnOptionC.setText(getResources().getString(R.string.q2_c));
            mBtnOptionD.setText(getResources().getString(R.string.q2_d));
            mBtnOptionE.setText(getResources().getString(R.string.q2_e));
            findViewById(R.id.cf).setVisibility(View.GONE);
           // mBtnOptionF.setText(getResources().getString(R.string.q1_f));
        }else if(questionTracker==2){
            // getResources().getString(R.string.q1_a)
            mTvQuestion.setText(getResources().getString(R.string.q3));
            mBtnOptionA.setText(getResources().getString(R.string.q3_a));
            mBtnOptionB.setText(getResources().getString(R.string.q3_b));
            mBtnOptionC.setText(getResources().getString(R.string.q3_c));
            findViewById(R.id.cd).setVisibility(View.GONE);
            findViewById(R.id.ce).setVisibility(View.GONE);
            findViewById(R.id.cf).setVisibility(View.GONE);
            // mBtnOptionF.setText(getResources().getString(R.string.q1_f));
        }else if(questionTracker==3){
            // getResources().getString(R.string.q1_a)
            mTvQuestion.setText(getResources().getString(R.string.q4));
            mBtnOptionA.setText(getResources().getString(R.string.q4_a));
            mBtnOptionB.setText(getResources().getString(R.string.q4_b));
            mBtnOptionC.setText(getResources().getString(R.string.q4_c));
            findViewById(R.id.cd).setVisibility(View.GONE);
            findViewById(R.id.ce).setVisibility(View.GONE);
            findViewById(R.id.cf).setVisibility(View.GONE);
            findViewById(R.id.tv_a).setVisibility(View.GONE);
            findViewById(R.id.tv_b).setVisibility(View.GONE);
            findViewById(R.id.tv_c).setVisibility(View.GONE);
            // mBtnOptionF.setText(getResources().getString(R.string.q1_f));
        }

        dcheckallQuestion();
        questionTracker++;
    }

    private void checkQuestion(final String options) {
        optionsMapping.get(options).setBackground(getResources().getDrawable(R.drawable.custom_button_correct));

    }
    private void dcheckQuestion(final String options) {
        optionsMapping.get(options).setBackground(getResources().getDrawable(R.drawable.custom_button));

    }
    private void dcheckallQuestion() {
        dcheckQuestion("a");
        dcheckQuestion("b");
        dcheckQuestion("c");
        dcheckQuestion("d");
        dcheckQuestion("e");
        dcheckQuestion("f");


    }
    private void vidall() {
        questionHolderArrayList.get(questionTracker-1).setOptionA("");
        questionHolderArrayList.get(questionTracker-1).setOptionB("");
        questionHolderArrayList.get(questionTracker-1).setOptionC("");
        questionHolderArrayList.get(questionTracker-1).setOptionD("");
        questionHolderArrayList.get(questionTracker-1).setOptionE("");
        questionHolderArrayList.get(questionTracker-1).setOptionF("");
    }
    public void optionAClicked(View view) {
        if(questionTracker==3 || questionTracker==4)
        { dcheckallQuestion();
        vidall();
        }
        if(questionHolderArrayList.get(questionTracker-1).getOptionA().equals("")){
            checkQuestion("a");
            questionHolderArrayList.get(questionTracker-1).setOptionA("true");
        }
        else {
            dcheckQuestion("a");
            questionHolderArrayList.get(questionTracker-1).setOptionA("");
        }

    }



    public void optionBClicked(View view) {
        if(questionTracker==3 || questionTracker==4)
        { dcheckallQuestion();
            vidall();
        }
        if(questionHolderArrayList.get(questionTracker-1).getOptionB().equals("")){
            checkQuestion("b");
            questionHolderArrayList.get(questionTracker-1).setOptionB("true");
        }
        else {
            dcheckQuestion("b");
            questionHolderArrayList.get(questionTracker-1).setOptionB("");
        }
    }

    public void optionCClicked(View view) {
        if(questionTracker==3 || questionTracker==4)
        { dcheckallQuestion();
            vidall();
        }
        if(questionHolderArrayList.get(questionTracker-1).getOptionC().equals("")){
            checkQuestion("c");
            questionHolderArrayList.get(questionTracker-1).setOptionC("true");
        }
        else {
            dcheckQuestion("c");
            questionHolderArrayList.get(questionTracker-1).setOptionC("");
        }
    }

    public void optionDClicked(View view) {
        if(questionTracker==3 || questionTracker==4)
        { dcheckallQuestion();
            vidall();
        }
        if(questionHolderArrayList.get(questionTracker-1).getOptionD().equals("")){
            checkQuestion("d");
            questionHolderArrayList.get(questionTracker-1).setOptionD("true");
        }
        else {
            dcheckQuestion("d");
            questionHolderArrayList.get(questionTracker-1).setOptionD("");
        }
    }

    public void optionEClicked(View view) {
        if(questionTracker==3 || questionTracker==4)
        { dcheckallQuestion();
            vidall();
        }
        if(questionHolderArrayList.get(questionTracker-1).getOptionE().equals("")){
            checkQuestion("e");
            questionHolderArrayList.get(questionTracker-1).setOptionE("true");
        }
        else {
            dcheckQuestion("e");
            questionHolderArrayList.get(questionTracker-1).setOptionE("");
        }
    }

    public void optionFClicked(View view) {
        if(questionTracker==3 || questionTracker==4)
        { dcheckallQuestion();
            vidall();
        }
        if(questionHolderArrayList.get(questionTracker-1).getOptionF().equals("")){
            checkQuestion("f");
            questionHolderArrayList.get(questionTracker-1).setOptionF("true");
        }
        else {
            dcheckQuestion("f");
            questionHolderArrayList.get(questionTracker-1).setOptionF("");
        }
    }
}
