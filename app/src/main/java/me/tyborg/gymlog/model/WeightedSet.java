package me.tyborg.gymlog.model;

/**
 * Created by Tyler Berry on 8/13/2015.
 */
public class WeightedSet extends RepSet {
    // Always stored as pounds
    private Float weight;

    public WeightedSet(Integer reps, Float weight) {
        super(reps);
        setWeight(weight);
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Float getMass() {
        return convertToKilograms(weight);
    }

    public void setMass(Float mass) {
        this.weight = convertToPounds(mass);
    }

    private Float convertToKilograms(Float weight) {
        return weight * 0.453592f;
    }

    private Float convertToPounds(Float mass) {
        return mass * 2.20462f;
    }

    @Override
    public String toString() {
        return super.toString() + " of " + getWeight() + " lbs";
    }
}
