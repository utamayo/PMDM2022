package org.iesch.a02_registro_de_superheroes.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SuperHero implements Parcelable {

    private String name;
    private String alterEgo;
    private String bio;
    private float power;

    public SuperHero(String name, String alterEgo, String bio, float power) {
        this.name = name;
        this.alterEgo = alterEgo;
        this.bio = bio;
        this.power = power;
    }

    protected SuperHero(Parcel in) {
        name = in.readString();
        alterEgo = in.readString();
        bio = in.readString();
        power = in.readFloat();
    }

    public static final Creator<SuperHero> CREATOR = new Creator<SuperHero>() {
        @Override
        public SuperHero createFromParcel(Parcel in) {
            return new SuperHero(in);
        }

        @Override
        public SuperHero[] newArray(int size) {
            return new SuperHero[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getAlterEgo() {
        return alterEgo;
    }

    public String getBio() {
        return bio;
    }

    public float getPower() {
        return power;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(alterEgo);
        dest.writeString(bio);
        dest.writeFloat(power);
    }
}
