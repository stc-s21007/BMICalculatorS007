package jp.suntech.s21007.bmicalculators007;
import androidx.fragment.app.DialogFragment;
import androidx.appcompat.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

public class OnAlertDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dl_AlertMin16);
        builder.setMessage("すべての欄に入力してください。");
        builder.setPositiveButton(R.string.dl_Alertok,new DialogButtonClickListener());
        AlertDialog dialog=builder.create();
        return dialog;
    }

    private class DialogButtonClickListener implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case DialogInterface.BUTTON_POSITIVE:
                    break;
            }
        }
    }
}
