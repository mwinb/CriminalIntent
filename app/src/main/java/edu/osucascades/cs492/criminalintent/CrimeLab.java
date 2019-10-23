package edu.osucascades.cs492.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab sCrimeLab;

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    private List<Crime> mCrimes;
    private HashMap<UUID, Crime> mCrimeMap;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null)
            sCrimeLab = new CrimeLab(context);

        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
        mCrimeMap = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0); // Every other one
            mCrimes.add(crime);
            mCrimeMap.put(crime.getId(), crime);
        }

    }

    public Crime getCrime(UUID id) {
        Crime crime = mCrimeMap.get(id);
        return crime;
    }


}
