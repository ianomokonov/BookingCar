package com.example.bookingcar.activities.enter;

import android.content.Context;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.bookingcar.R;

public class EnterPageFragment extends Fragment {

    private int pageNumber;

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
        View result=inflater.inflate(R.layout.page_enter, container, false);
        EditText name = result.findViewById(R.id.name);
        EditText phone = result.findViewById(R.id.phone);
        if(pageNumber == 0){
            name.setVisibility(View.GONE);
            phone.setVisibility(View.GONE);
        } else {
            name.setVisibility(View.VISIBLE);
            phone.setVisibility(View.VISIBLE);
        }

        return result;
    }
}
