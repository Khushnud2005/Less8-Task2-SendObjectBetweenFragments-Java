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

public class FirstFragment extends Fragment {
    FirstListener listener;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment, container, false);
        initViews(view);
        return view;
    }

    void initViews(View view){
        textView = view.findViewById(R.id.tv_firstFrag);
        UserModel user = new UserModel("Xushnud","abc@def.com",911234567);
        Button btn_first = view.findViewById(R.id.btn_firstFrag);
        btn_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.sendFirst(user);
            }
        });

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof FirstListener){
            listener = (FirstListener) context;
        }else {
            throw new RuntimeException(context.toString() +" You mast init listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
    public void updateFirstText(UserModel user){
        textView.setText(user.toString());
    }


   public interface FirstListener{
       void sendFirst(UserModel user);
    }
}