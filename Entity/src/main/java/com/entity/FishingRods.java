package com.entity;



import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Roman on 04.07.2017.
 */

@Entity
@Table(name = "FishingRods")
public class FishingRods {

    public long fishingRodsId;
    public String type;
    public String manufacturer;
    public String name;
    public int casting;
    public double length;
    public int weight;
    public String material;
    public String design;
    public int price;
    public String specializationOfFishingRods;

    public FishingRods() {
    }


//    public FishingRods(String fishingRodsId, String type, String manufacturer, String name, int casting, long length, int weight, String material, String design, int price, String specializationOfFishingRods) {
//        this.fishingRodsId = fishingRodsId;
//        this.type = type;
//        this.manufacturer = manufacturer;
//        this.name = name;
//        this.casting = casting;
//        this.length = length;
//        this.weight = weight;
//        this.material = material;
//        this.design = design;
//        this.price = price;
//        this.specializationOfFishingRods = specializationOfFishingRods;
//    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "fishingRodsId")
    public long getFishingRodsId() {
        return fishingRodsId;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    @Column(name = "manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "casting")
    public int getCasting() {
        return casting;
    }

    @Column(name = "length")
    public double getLength() {
        return length;
    }

    @Column(name = "weight")
    public int getWeight() {
        return weight;
    }

    @Column(name = "material")
    public String getMaterial() {
        return material;
    }

    @Column(name = "design")
    public String getDesign() {
        return design;
    }

    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    @Column(name = "specializationOfFishingRods")
    public String getSpecializationOfFishingRods() {
        return specializationOfFishingRods;
    }

    public void setFishingRodsId(long fishingRodsId) {
        this.fishingRodsId = fishingRodsId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCasting(int casting) {
        this.casting = casting;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSpecializationOfFishingRods(String specializationOfFishingRods) {
        this.specializationOfFishingRods = specializationOfFishingRods;
    }


    public String toString() {
        return "FishingRods{" +
                "fishingRodsId=" + fishingRodsId +
                ", type='" + type + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", name='" + name + '\'' +
                ", casting=" + casting +
                ", length=" + length +
                ", weight=" + weight +
                ", material='" + material + '\'' +
                ", design='" + design + '\'' +
                ", price=" + price +
                ", specializationOfFishingRods='" + specializationOfFishingRods + '\'' +
                '}';
    }
}
