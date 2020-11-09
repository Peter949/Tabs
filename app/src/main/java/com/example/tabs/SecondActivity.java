package com.example.tabs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondActivity extends Fragment implements View.OnClickListener
{
    private Button bgButton;
    public RelativeLayout relativeLayout;
    Context context;
    MainActivity mainActivity = new MainActivity();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.second_main, container, false);
        bgButton = (Button) view.findViewById(R.id.background_button);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.relativelayout);

        context = mainActivity.getBaseContext();
        bgButton.setOnClickListener(this);
        return view;
    }
    public void onClick (View v){

        final CharSequence[] items =
                {
                        getText(R.string.red), getText(R.string.yellow), getText(R.string.green)
                };
        AlertDialog.Builder builder = new AlertDialog.Builder(mainActivity.getBaseContext());
        builder.setTitle(R.string.message);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                switch (item) {
                    case 0: {
                        relativeLayout.setBackgroundResource(R.color.redColor);
                        Toast.makeText(context, R.string.red, Toast.LENGTH_LONG).show();
                        break;
                    }
                    case 1: {
                        relativeLayout.setBackgroundResource(R.color.yellowColor);
                        Toast.makeText(context, R.string.yellow, Toast.LENGTH_LONG).show();
                        break;
                    }
                    case 2: {
                        relativeLayout.setBackgroundResource(R.color.greenColor);
                        Toast.makeText(context, R.string.green, Toast.LENGTH_LONG).show();
                        break;
                    }
                }
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
