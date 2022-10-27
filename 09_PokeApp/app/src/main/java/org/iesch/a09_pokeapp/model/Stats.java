package org.iesch.a09_pokeapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Stats implements Parcelable {
    private String hp;
    private String attack;
    private String defence;
    private String speed;

    public Stats(String hp, String attack, String defence, String speed) {
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
    }

    protected Stats(Parcel in) {
        hp = in.readString();
        attack = in.readString();
        defence = in.readString();
        speed = in.readString();
    }

    public static final Creator<Stats> CREATOR = new Creator<Stats>() {
        @Override
        public Stats createFromParcel(Parcel in) {
            return new Stats(in);
        }

        @Override
        public Stats[] newArray(int size) {
            return new Stats[size];
        }
    };

    public String getHp() {
        return hp;
    }

    public String getAttack() {
        return attack;
    }

    public String getDefence() {
        return defence;
    }

    public String getSpeed() {
        return speed;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(hp);
        dest.writeString(attack);
        dest.writeString(defence);
        dest.writeString(speed);
    }
}
