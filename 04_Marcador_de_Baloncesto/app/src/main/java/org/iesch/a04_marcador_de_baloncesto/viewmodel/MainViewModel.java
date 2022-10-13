package org.iesch.a04_marcador_de_baloncesto.viewmodel;

import androidx.lifecycle.ViewModel;

// MVVM 2 - hemos de extender de ViewModel
public class MainViewModel extends ViewModel {

    // MVVM 3 - Corto y pego estas variables
    private int localScore = 0;
    private int visitorScore = 0;

    public int getLocalScore() {
        return localScore;
    }

    public int getVisitorScore() {
        return visitorScore;
    }

    // MVVM 4 -  Me traigo los métodos resetScores, addToPoints, pero no debo tocar NADA de los Views
    public void resetScores() {
        localScore = 0;
        visitorScore = 0;
    }
    public void addPointsToScore(int points, boolean isLocal) {
        if ( isLocal) {
            localScore += points;
        } else  {
            visitorScore += points;
        }
    }
    // MVVM 5 - ME creo los métodos para decrementar el local y el visitante
    public void decreaseLocal() {
        if (localScore > 0 ){
            localScore--;
        }
    }
    public void decreaseVisitor() {
        if (visitorScore > 0 ){
            visitorScore--;
        }
    }
}























