package com.example.bookingcar.activities.enter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
//        TextView pageHeader=(TextView)result.findViewById(R.id.displayText);
//        String header = String.format("Фрагмент %d", pageNumber+1);
//        pageHeader.setText(header);
        return result;
    }
}
