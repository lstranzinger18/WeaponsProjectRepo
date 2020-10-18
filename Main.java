/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3b.lstranzinger.WeaponsProjectRepo;

import java.io.FileNotFoundException;
import java.util.List;
import net.htlgrieskirchen.pos3b.lstranzinger.WeaponsProjectRepo.Weapon.Printable;

/**
 *
 * @author lukas
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Weapon wp = new Weapon();
        
        List<Weapon> weapony = wp.ReadFile("weapons.csv");

        Printable printer = (List<Weapon> weapons) -> {
            for (Weapon weapon : weapons) {
                System.out.println(weapon.toString());
            }
        };
        System.out.println("PRINTABLE INTERFACE");
        printer.print(weapony);
        
    }

}
