package uz.exemple.less8_task2_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import uz.exemple.less8_task2_java.fragments.FirstFragment;
import uz.exemple.less8_task2_java.fragments.SecondFragment;
import uz.exemple.less8_task2_java.models.UserModel;

public class MainActivity extends AppCompatActivity implements FirstFragment.FirstListener, SecondFragment.SecondListener {
    FirstFragment firstFragment;
    SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    void initViews(){
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.firstFrame,firstFragment)
                .replace(R.id.secondFrame,secondFragment)
                .commit();
    }

    @Override
    public void sendFirst(UserModel user) {
        secondFragment.updateSecondText(user);
    }

    @Override
    public void sendSecond(UserModel user) {
        firstFragment.updateFirstText(user);
    }
}