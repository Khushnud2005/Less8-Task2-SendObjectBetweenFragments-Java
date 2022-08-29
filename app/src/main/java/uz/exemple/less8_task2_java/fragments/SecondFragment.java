package uz.exemple.less8_task2_java.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import uz.exemple.less8_task2_java.R;
import uz.exemple.less8_task2_java.models.UserModel;


public class SecondFragment extends Fragment {
    SecondListener listener;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment, container, false);
        initViews(view);
        return view;
    }
    void initViews(View view){
        textView = view.findViewById(R.id.tv_second_frag);
        Button btn_second = view.findViewById(R.id.btn_second_frag);
        UserModel user = new UserModel("Abdul","xyz@tuw.com",961234578);
        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.sendSecond(user);
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof SecondListener){
            listener = (SecondListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public void updateSecondText(UserModel user){
        textView.setText(user.toString());
    }

   public interface SecondListener{
        void sendSecond(UserModel user);
    }
}