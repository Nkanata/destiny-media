package com.dullio.destinyconnectionsmediaapplication;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.textfield.TextInputEditText;

public class AuthDialogFragment extends BottomSheetDialogFragment {

   private TextView dialogTitleTextView, dialogDescriptionTextView;
   private String dialogTitle,dialogDescription;
   private BottomSheetListener mBottomSheetListener;
   private ProgressBar dialogProgressBar;
   private int dialogProgressValue = 0, dialogErrorValue=0;
   private static int RESULT_OK = 18;

    // empty constructor required
    public AuthDialogFragment(){

    }

    @Override
    public int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.authentication_dialog_layout, container, false);


        dialogTitleTextView = root.findViewById(R.id.auth_dialog_title);
        dialogDescriptionTextView = root.findViewById(R.id.auth_dialog_tip);
        dialogProgressBar = root.findViewById(R.id.auth_dialog_progress);


        dialogTitleTextView.setText(dialogTitle);
        dialogDescriptionTextView.setText(dialogDescription);

        if (dialogProgressValue > 0){
            dialogProgressBar.setIndeterminate(false);
            dialogProgressBar.setProgress(dialogProgressValue);
        }


        return root;
    }


    public String getDialogTitle() {
        return dialogTitle;
    }

    public void setDialogTitle(String dialogTitle) {
        this.dialogTitle = dialogTitle;
    }

    public String getDialogDescription() {
        return dialogDescription;
    }

    public void setDialogDescription(String dialogDescription) {
        this.dialogDescription = dialogDescription;
    }

    public int getDialogProgressValue() {
        return dialogProgressValue;
    }

    public void setDialogProgressValue(int dialogProgressValue) {
        this.dialogProgressValue = dialogProgressValue;
    }




    public void validateEditTextDetails(TextInputEditText editText, String key,String code){

                switch (key){

                    case "name":
                        setDialogTitle("Validating Username");
                //Validate here
                if (!editText.getText().toString().isEmpty()){
                    dialogProgressValue = dialogProgressValue+20;
                }
                else {
                    editText.setError("Enter your name");
                    dialogErrorValue = dialogErrorValue+1;
                }

                break;

            case "email":
                setDialogTitle("Validating Email");
                if (!editText.getText().toString().isEmpty() &&editText.getText().toString().contains("@")){
                    dialogProgressValue = dialogProgressValue+20;
                }
                else {
                    editText.setError("Enter a valid email address");
                    dialogErrorValue = dialogErrorValue+1;
                }
                break;

            case "id":
                setDialogTitle("Validating ID");
                if (!editText.getText().toString().isEmpty() && editText.getText().toString().trim().length() > 7 ){
                    dialogProgressValue = dialogProgressValue+20;
                }
                else{
                    editText.setError(" ID must be 8 characters");
                    dialogErrorValue = dialogErrorValue+1;
                }
                break;

            case "phone":
                setDialogTitle("Validating Phone");
                if (!editText.getText().toString().isEmpty() && editText.getText().toString().trim().length() > 9  ){

                    dialogProgressValue = dialogProgressValue+20;
                }else {
                    editText.setError("Enter a valid phone number");
                    dialogErrorValue = dialogErrorValue+1;
                }
                break;

            case "pass":
                setDialogTitle("Validating Password");
                if (!editText.getText().toString().isEmpty() && editText.getText().toString().trim().length() > 5 ){

                    dialogProgressValue = dialogProgressValue+20;

                }
                else {
                    editText.setError("Password must be > 5 characters");
                    dialogErrorValue = dialogErrorValue+1;
                }

                break;

                default:
        }

        if(dialogErrorValue == 0){

            if (code.equals("signIn")){
                mBottomSheetListener.onDialogDetach(false,RESULT_OK);
                dismiss();
            }
            else {

                submitDetails();
            }

        }else{

            registerError();
        }

    }





    public interface BottomSheetListener{
        void onDialogDetach(boolean detach,int success);

    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mBottomSheetListener = (BottomSheetListener) context;
        }
        catch (ClassCastException e){
            //  throw new ClassCastException(context.toString());
        }
    }



    @Override
    public void onDetach() {
        super.onDetach();
        mBottomSheetListener.onDialogDetach(true,dialogErrorValue);
        mBottomSheetListener = null;
        dialogErrorValue = 0;
        dialogTitle = "";
        dialogDescription = "";

    }

    private void submitDetails(){
        dialogProgressValue = 0;
        setDialogTitle("Submitting Data");
        setDialogDescription("This will only take a few minutes..");
    }


    private void registerError(){
        setDialogTitle("Errors found");
        setDialogDescription("You have "+dialogErrorValue+" error(s), resolve them to proceed.");
    }



}
