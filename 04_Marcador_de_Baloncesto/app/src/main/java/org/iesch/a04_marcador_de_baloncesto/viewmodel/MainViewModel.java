package org.iesch.a04_marcador_de_baloncesto.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    // LIVEDATA 1 - Cambio el tipo de variable
    private MutableLiveData<Integer> localScore = new MutableLiveData<>();
    private MutableLiveData<Integer> visitorScore = new MutableLiveData<>();

    // LIVEDATA 4 - Como se crean a nulo las meto en el constructor para asegurarme de que no sean nulos
    public MainViewModel() {
        resetScores();
    }

    // LIVEDATA 2 - Ahora tengo que leer de esta manera
    public MutableLiveData<Integer> getLocalScore() {
        return localScore;
    }

    public MutableLiveData<Integer> getVisitorScore() {
        return visitorScore;
    }

    // LIVEDATA 3 - He de cambiar la manera de establecer los valores
    public void resetScores() {
        localScore.setValue(0);
        visitorScore.setValue(0);
    }
    public void addPointsToScore(int points, boolean isLocal) {
        if ( isLocal) {
            localScore.setValue(localScore.getValue() + points);
        } else  {
            visitorScore.setValue(visitorScore.getValue() + points);
        }
    }

    public void decreaseLocal() {
        if (localScore.getValue() > 0 ){
            localScore.setValue(localScore.getValue() - 1);
        }
    }
    public void decreaseVisitor() {
        if (visitorScore.getValue() > 0 ){
            visitorScore.setValue(visitorScore.getValue() - 1);
        }
    }
}























