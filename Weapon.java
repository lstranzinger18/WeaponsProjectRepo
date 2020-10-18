/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3b.lstranzinger.WeaponsProjectRepo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author lukas
 */
public class Weapon {

    String name;
    CombatType combatType;
    DamageType damageType;
    int damage;
    int speed;
    int strength;
    int value;

    public Weapon() {
    }

    public Weapon(String name, CombatType combatType, DamageType damageType, int damage, int speed, int strength, int value) {
        this.name = name;
        this.combatType = combatType;
        this.damageType = damageType;
        this.damage = damage;
        this.speed = speed;
        this.strength = strength;
        this.value = value;

    }
    
    public interface Printable
    {
    void print(List<Weapon> weapons);
    
    }     
            
            
    public List<Weapon> ReadFile(String filepath) throws FileNotFoundException {

        File file = new File(filepath);
        List<Weapon> weapons = new ArrayList<>();

        Scanner sc = new Scanner(file);
        sc.nextLine();
        while (sc.hasNext()) {
            String[] attributes = sc.nextLine().split(";");
            Weapon weapon = new Weapon(attributes[0], CombatType.valueOf(attributes[1].toUpperCase()), DamageType.valueOf(attributes[2].toUpperCase()), Integer.parseInt(attributes[3]), Integer.parseInt(attributes[4]), Integer.parseInt(attributes[5]), Integer.parseInt(attributes[6]));
            weapons.add(weapon);

            System.out.println(weapon.toString());

        }

        return weapons;
    }

    public String getName() {
        return this.name;
    }

    public CombatType getCombatType() {
        return this.combatType;
    }

    public DamageType getDamageType() {
        return this.damageType;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getMinStrength() {
        return this.strength;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.name);
        hash = 11 * hash + Objects.hashCode(this.combatType);
        hash = 11 * hash + Objects.hashCode(this.damageType);
        hash = 11 * hash + this.damage;
        hash = 11 * hash + this.speed;
        hash = 11 * hash + this.strength;
        hash = 11 * hash + this.value;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Weapon other = (Weapon) obj;
        if (this.damage != other.damage) {
            return false;
        }
        if (this.speed != other.speed) {
            return false;
        }
        if (this.strength != other.strength) {
            return false;
        }
        if (this.value != other.value) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (this.combatType != other.combatType) {
            return false;
        }
        if (this.damageType != other.damageType) {
            return false;
        }
        return true;
    }

    public List<Weapon> sortList(List<Weapon> weapons) {
        weapons.sort((e1, e2) -> e1.getDamage() - e2.getDamage());
        Collections.reverse(weapons);
        return weapons;

    }

    public List<Weapon> sortListAlph(List<Weapon> weapons) {

        weapons.sort((Weapon e1, Weapon e2) -> {

            if (e1.getCombatType().toString().equals(e2.getCombatType().toString()) != true) {

                return e1.getCombatType().toString().compareTo(e2.getCombatType().toString());

            } else if (e1.getDamageType().toString().equals(e2.getDamageType().toString()) != true) {

                return e1.getDamageType().toString().compareTo(e2.getDamageType().toString());

            } else if (e1.getName().equals(e2.getName()) != true) {

                return e1.getName().compareTo(e2.getName());

            }

           return 0;

        });

        return weapons;
    }

    @Override
    public String toString() {
        return "Weapon{" + "name=" + name + ", combatType=" + combatType + ", damageType=" + damageType + ", damage=" + damage + ", speed=" + speed + ", minStrength=" + strength + ", value=" + value + '}';
    }

}
