package com.rathana.alaterdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rathana.alaterdialog.utils.CustomAlterDialog;
import com.rathana.alaterdialog.utils.CustomDialogFragment;

public class MainActivity extends AppCompatActivity {

    CustomAlterDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog=new CustomAlterDialog(this);

    }

    public void onMessageDialogClicked(View v){
        dialog.createMessageDialog("Deposit","you have deposit from " +
                "ATM ID 000987, amount 5000$");
    }

    public void onSingleChoiceDialogClicked(View v){
        dialog.createSingleListDialog("Choose colors");
    }

    public void onSingleRadioListClicked(View v){
        dialog.createRadioButtonListDialog("Radio List");
    }

    public  void onMultileChoiceClicked(View view){
        dialog.createMultipleChoice("Multiple choice");
    }

    public void onCustomAlertDialogClicked(View v){
        dialog.createCustomAlertDialog("Please login!");
    }

    public void onDialogFragmentClicked(View v){
      new CustomDialogFragment().show(getSupportFragmentManager(),"dialog");
    }
}
