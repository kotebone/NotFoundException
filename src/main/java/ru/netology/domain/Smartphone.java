package ru.netology.domain;

import java.util.Objects;

public class Smartphone extends Product{
    private String producer;

    public Smartphone() {
    }

    public Smartphone(int id, String name, int price, String producer) {
        super(id, name, price);
        this.producer = producer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Smartphone)) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(getProducer(), that.getProducer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getProducer());
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "producer='" + producer + '\'' +
                '}';
    }
}