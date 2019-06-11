package com.rathana.alaterdialog.utils;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class CustomDialogFragment extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder b=new AlertDialog.Builder(getActivity());
        b.setTitle("Dialog Fragment");
        b.setMessage("This is a dialog fragment");

        return b.create();
    }
}
