package com.simrs.qt.simrs.model;

public class daymodel {

    String name;
    String spesialis;
    String jam;
    String feature;

    public daymodel(String name, String spesialis, String jam, String feature ) {
        this.name=name;
        this.spesialis=spesialis;
        this.jam=jam;
        this.feature=feature;

    }

    public String getName() {
        return name;
    }

    public String getspesialis() {
        return spesialis;
    }

    public String getJam() {
        return jam;
    }

    public String getFeature() {
        return feature;
    }
}
