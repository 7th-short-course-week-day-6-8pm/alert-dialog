package com.rathana.alaterdialog.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.rathana.alaterdialog.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAlterDialog {

    private Context context;

    public CustomAlterDialog(Context context){
        this.context=context;
    }

    public void createMessageDialog(String title, String message){

        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setIcon(R.drawable.ic_attach_money_black_24dp);
        builder.setPositiveButton("Okay", new DialogInterface.
                OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setNeutralButton("Do later!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builder.setCancelable(false);
        builder.create().show();

    }


    CharSequence[] items= {"black","pink","white","blue","yellow"};
    public void createSingleListDialog(String title){
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setIcon(R.drawable.ic_attach_money_black_24dp)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, ""+items[which],
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .create()
                .show();
    }

    private static int choose=-1;
    public void createRadioButtonListDialog(String title){
        AlertDialog.Builder b=new AlertDialog.Builder(context);
        b.setTitle(title)
                .setSingleChoiceItems(
                    items,
                    choose,
                    new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        choose=which;
                        Toast.makeText(context, ""+items[which],
                                Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }

    static boolean[] choices={true,false,false,false,false};
    List<CharSequence> itemList=new ArrayList<>();
    public void createMultipleChoice(String title){
        AlertDialog.Builder b=new AlertDialog.Builder(context);
        b.setTitle(title)
                .setMultiChoiceItems(
                        items,
                        choices,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which, boolean isChecked) {
                                if(isChecked){
                                    itemList.add(items[which]);
                                    choices[which]=true;
                                } else{
                                    itemList.remove(items[which]);
                                    choices[which]=false;
                                }

                            }
                        })
                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, ""+itemList, Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .create()
                .show();
    }


    public void createCustomAlertDialog(String title){
        AlertDialog.Builder b=new AlertDialog.Builder(context);

        View view = LayoutInflater.from(context).inflate(
                R.layout.custom_alert_dialog_layout,
                null);
        b.setTitle(title);
        b.setView(view);

        final EditText username;
        final EditText password;
        username=view.findViewById(R.id.username);
        password=view.findViewById(R.id.password);

         b.setPositiveButton("Login", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 final String name = username.getText().toString();
                 final String pass = password.getText().toString();
                 Toast.makeText(context, "name =" +name +" password = "+pass,
                         Toast.LENGTH_SHORT).show();
                 dialog.dismiss();
             }
         });

        b.create().show();
    }







}
