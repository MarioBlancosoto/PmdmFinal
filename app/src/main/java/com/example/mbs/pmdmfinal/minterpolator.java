package com.example.mbs.pmdmfinal;

/**
 * Created by mbs on 3/3/18.
 */

public class minterpolator implements android.view.animation.Interpolator{
 //Creado interpolator propio con sus propios métodos y variables

    private double mAmplitude = 1;
    private double mFrequency = 10;

    minterpolator(double amplitude, double frequency) {
        mAmplitude = amplitude;
        mFrequency = frequency;
    }

    public float getInterpolation(float time) {
        return (float) (-1 * Math.pow(Math.E, -time/ mAmplitude) *
                Math.cos(mFrequency * time) + 1);
    }
}
