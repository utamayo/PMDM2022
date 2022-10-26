package org.iesch.a09_pokeapp.model;

// 1 - Me creo el objeto Pokemon con sus campos, su constructor y sus getters
public class Pokemon {

    private String id;
    private String name;
    private Type type;
    // le pongo un entero porque contiene el id de la imagen
    private int imageId;
    private int soundId;


    public enum Type {
        FIRE, WATER, PLANT, ELECTRIC
    }

    public Pokemon(String id, String name, Type type, int soundId, int imageId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.soundId = soundId;
        this.imageId = imageId;

    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getImageId() {
        return imageId;
    }

    public int getSoundId() {
        return soundId;
    }
}















