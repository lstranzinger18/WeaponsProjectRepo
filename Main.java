/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3b.lstranzinger.WeaponsProjectRepo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import net.htlgrieskirchen.pos3b.lstranzinger.WeaponsProjectRepo.Weapon.Printable;

/**
 *
 * @author lukas
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Weapon wp = new Weapon();

       // List<Weapon> weapony = wp.ReadFile("weapons.csv");

        Printable printer = (List<Weapon> weapons) -> {
            for (Weapon weapon : weapons) {
                System.out.println(weapon.toString());
            }
        };

        //weapony = wp.sortList(weapony);
       // System.out.println("PRINTABLE INTERFACE");
       // printer.print(weapony);

        //1.6
        //???
        
        
        try (Stream<String> readinStream = Files.lines(Paths.get("weapons.csv")).skip(1)) {
            List<Weapon> weaponary = new ArrayList<>();
            readinStream.forEach((line) -> {

                String[] attributes = line.split(";");
                Weapon weapon = new Weapon(attributes[0], CombatType.valueOf(attributes[1].toUpperCase()), DamageType.valueOf(attributes[2].toUpperCase()), Integer.parseInt(attributes[3]), Integer.parseInt(attributes[4]), Integer.parseInt(attributes[5]), Integer.parseInt(attributes[6]));
                weaponary.add(weapon);
                System.out.println(weapon.toString());

            });

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        {

        }

    }

}
