package com.example.bookingcar.activities.enter;

import android.content.Context;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.bookingcar.R;
import com.example.bookingcar.models.user.LogInUser;
import com.example.bookingcar.models.user.SignInUser;
import com.example.bookingcar.models.user.User;
import com.example.bookingcar.models.user.UserResponse;
import com.example.bookingcar.requests.user.LogInRequest;
import com.example.bookingcar.requests.user.SignInRequest;

public class EnterPageFragment extends Fragment implements View.OnClickListener {

    private int pageNumber;
    private  View view;

    public static EnterPageFragment newInstance(int page) {
        EnterPageFragment fragment = new EnterPageFragment();
        Bundle args=new Bundle();
        args.putInt("num", page);
        fragment.setArguments(args);
        return fragment;
    }

    static String getTitle(Context context, int position) {
        return position == 0 ? "Вход" : "Регистрация";
    }

    public EnterPageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments() != null ? getArguments().getInt("num") : 1;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.page_enter, container, false);
        EditText name = view.findViewById(R.id.name);
        EditText phone = view.findViewById(R.id.phone);
        if(pageNumber == 0){
            name.setVisibility(View.GONE);
            phone.setVisibility(View.GONE);
        } else {
            name.setVisibility(View.VISIBLE);
            phone.setVisibility(View.VISIBLE);
        }

        view.findViewById(R.id.enter_btn).setOnClickListener(this);

        return view;
    }

    public void onClick(View v) {
        EditText emailView = view.findViewById(R.id.email);
        EditText passwordView = view.findViewById(R.id.password);
        if(pageNumber == 0){
            LogInUser user = new LogInUser();
            user.email = emailView.getText().toString();
            user.password = passwordView.getText().toString();
            LogInRequest request = new LogInRequest();
            request.execute(user);
            try{
                UserResponse userResult = request.get();
                Toast.makeText(getActivity(), userResult.message, Toast.LENGTH_LONG).show();
            } catch (Exception e){
                e.printStackTrace();
                Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_LONG).show();
            }
            return;
        }
        EditText nameView = view.findViewById(R.id.name);
        EditText phoneView = view.findViewById(R.id.phone);
        SignInUser user = new SignInUser();
        user.name = nameView.getText().toString();
        user.email = emailView.getText().toString();
        user.phone = phoneView.getText().toString();
        user.password = passwordView.getText().toString();
        SignInRequest request = new SignInRequest();
        request.execute(user);
        try{
            UserResponse userResult = request.get();
            Toast.makeText(getActivity(), userResult.message, Toast.LENGTH_LONG).show();
        } catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getActivity(),e.getMessage(),Toast.LENGTH_LONG).show();
        }


    }
}
