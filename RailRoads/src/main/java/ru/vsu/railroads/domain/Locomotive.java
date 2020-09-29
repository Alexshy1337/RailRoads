package ru.vsu.railroads.domain;

import java.util.Objects;

public class Locomotive {
    private Long power, id, trainId;

    public Locomotive(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public Locomotive(Long id) {
        this.id = id;
    }

    public Locomotive(Long id, Long power) {
        this.id = id; this.power = power;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locomotive item = (Locomotive) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public String toString() {

        return "Locomotive, id=" + id;
    }
}
