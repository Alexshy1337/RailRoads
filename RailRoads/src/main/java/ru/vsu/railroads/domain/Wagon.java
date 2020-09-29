package ru.vsu.railroads.domain;

import java.util.Objects;

public class Wagon {

    private Long id, trainId;
    public Wagon() {}
    public Wagon(Long id) {
        this.id = id;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wagon item = (Wagon) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public String toString() {

        return "wagon, id=" + id;
    }
}
