package edu.osucascades.cs492.criminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.fragment.app.DialogFragment;

public class CrimePhotoFragment extends DialogFragment {
    private static final String CRIME_PHOTO_PATH = "crime_photo_path";

    public static CrimePhotoFragment newInstance(String crimePhotoPath) {
        Bundle args = new Bundle();
        args.putString(CRIME_PHOTO_PATH, crimePhotoPath);

        CrimePhotoFragment crimePhotoFragment = new CrimePhotoFragment();
        crimePhotoFragment.setArguments(args);
        return crimePhotoFragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle bundle) {
        String crimePhotoPath = getArguments().getString(CRIME_PHOTO_PATH);

        View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_crime_photo, null);
        Bitmap bitmap = PictureUtils.getScaledBitmap(crimePhotoPath, getActivity());
        ImageView imageView = v.findViewById(R.id.crime_photo_dialog);
        imageView.setImageBitmap(bitmap);
        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.crime_photo_dialog_title)
                .create();
    }
}
