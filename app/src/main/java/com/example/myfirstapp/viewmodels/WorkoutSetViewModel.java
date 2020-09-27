package com.example.myfirstapp.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myfirstapp.models.workoutSet.WorkoutSet;

public class WorkoutSetViewModel extends ViewModel {
    public WorkoutSet workoutSet;
    MutableLiveData<Integer> weight;
    MutableLiveData<Integer> repetitions;

    public MutableLiveData<Integer> getWeight() {
        if (weight == null) {
            weight = new MutableLiveData<>();
        }
        return weight;
    }

    public void setWeight(int value) {
        getWeight().postValue(value);
    }

    public MutableLiveData<Integer> getRepetitions() {
        if (repetitions == null) {
            repetitions = new MutableLiveData<>();
        }
        return repetitions;
    }

    public void setRepetitions(int value) {
        getRepetitions().postValue(value);
    }
}
