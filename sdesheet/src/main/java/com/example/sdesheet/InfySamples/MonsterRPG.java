package com.example.sdesheet.InfySamples;

import java.util.*;

class MonsterRPG {
    public static void main(String[] args) {
        // System.out.println("Hello world!");
        int n = 3;
        int exp = 100;
        int[] power = { 101, 100, 304 };
        int[] bonus = { 100, 1, 524 };

        System.out.println(maxMonsDef(n, exp, power, bonus));
    }

    public static int maxMonsDef(int n, int exp, int power[], int bonus[]) {
        int count = 0;
        ArrayList<Monster> monster = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            monster.add(new Monster(power[i], bonus[i]));
        }

        Collections.sort(monster, (m1, m2) -> (m1.power - m2.power));

        for (int i = 0; i < n; i++) {
            if (monster.get(i).power <= exp)
                count++;
            else
                break;
            exp += monster.get(i).bonus;

        }

        return count;
    }
}

class Monster {
    int power;
    int bonus;

    Monster(int power, int bonus) {
        this.power = power;
        this.bonus = bonus;
    }

}