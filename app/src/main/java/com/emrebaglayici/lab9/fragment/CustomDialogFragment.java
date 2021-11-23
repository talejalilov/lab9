package com.emrebaglayici.lab9.fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.emrebaglayici.lab9.R;
import com.emrebaglayici.lab9.databinding.FragmentDialogBinding;

import java.util.Objects;

public class CustomDialogFragment extends DialogFragment  {

    FragmentDialogBinding binding;
    CallBack callBack;

    CharSequence name ;
    CharSequence des ;
    CharSequence qua ;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        binding = FragmentDialogBinding.inflate(getLayoutInflater(), null, false);
        View view = binding.getRoot();
        //build the alert dialog child of this fragment
        AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
        //restore the background_color and layout_gravity that Android strips
        b.getContext().getTheme().applyStyle(R.style.MyAlertDialog, true);
        b.setView(view);

        EditText Name = view.findViewById(R.id.nameEdit);
        EditText Des = view.findViewById(R.id.descriptionEdit);
        EditText Qua =  view.findViewById(R.id.quantityEdit);

        Log.d("TAG", "onClick: closing dialog");
        name = Name.getText().toString();
        des = Des.getText().toString();
        qua = Qua.getText().toString();

        binding.okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TAG", "onClick: closing dialogOK");

                    callBack.onActionClick(name, des, qua);
                    Objects.requireNonNull(getDialog()).dismiss();
            }
        });
        return b.create();

    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    public interface CallBack{
         void onActionClick (CharSequence name, CharSequence des, CharSequence qua);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try{
            callBack = (CallBack) getActivity();
        }catch (ClassCastException e){
           e.getMessage();
        }
    }
}
