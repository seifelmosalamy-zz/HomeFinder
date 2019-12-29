package com.example.homefinder.ui.saves;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SavesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SavesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is saves fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}