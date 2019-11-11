package edu.osucascades.cs492.criminalintent.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.Date;
import java.util.UUID;

import edu.osucascades.cs492.criminalintent.database.CrimeDbSchema.CrimeTable;

import edu.osucascades.cs492.criminalintent.Crime;

public class CrimeCursorWrapper extends CursorWrapper {

    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Crime getCrime() {
        String uuidString = getString(getColumnIndex(CrimeTable.Cols.UUID));
        String title = getString(getColumnIndex(CrimeTable.Cols.TITLE));
        String suspect = getString(getColumnIndex(CrimeTable.Cols.SUSPECT));
        String suspectNumber = getString(getColumnIndex(CrimeTable.Cols.SUSPECT_NUMBER));
        long date = getLong(getColumnIndex(CrimeTable.Cols.DATE));
        int isSolved = getInt(getColumnIndex(CrimeTable.Cols.SOLVED));

        Crime crime = new Crime(UUID.fromString(uuidString));
        crime.setTitle(title);
        crime.setDate(new Date(date));
        crime.setSolved(isSolved != 0);
        crime.setSuspect(suspect);
        crime.setSuspectNumber(suspectNumber);
        return crime;
    }
}
