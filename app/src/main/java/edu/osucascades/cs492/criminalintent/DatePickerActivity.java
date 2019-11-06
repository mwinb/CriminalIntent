package edu.osucascades.cs492.criminalintent;

import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import java.util.Date;

public class DatePickerActivity extends SingleFragmentActivity {
    private static final String EXTRA_CRIME_DATE =
            "edu.osucascades.cs492.criminalintent.crime_date";

    public static Intent newIntent(Context context, Date date) {
        Intent intent = new Intent(context, DatePickerActivity.class);
        intent.putExtra(EXTRA_CRIME_DATE, date);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        Date date = (Date) getIntent().getSerializableExtra(EXTRA_CRIME_DATE);
        return DatePickerFragment.newInstance(date);
    }
}
