package com.example.falhafez;

public class post {

    private String name;
    private String birthYearInLHijri;
    private String deathYearInLHijri;
    private String birthPlace;

    public post(String name, String birthPlace, String birthYearInLHijri, String deathYearInLHijri) {
        this.name = name;
        this.birthPlace = birthPlace;
        this.birthYearInLHijri = birthYearInLHijri;
        this.deathYearInLHijri = deathYearInLHijri;
    }

    public String getName() {
        return name;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getBirthYearInLHijri() {
        final String birthYearInLHijri = this.birthYearInLHijri;
        return birthYearInLHijri;
    }

    public String getDeathYearInLHijri() {
        String deathYearInLHijri = this.deathYearInLHijri;
        return deathYearInLHijri;
    }
}
