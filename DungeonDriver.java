// I worked on the homework assignment alone, using only course materials.

public class DungeonDriver {
    public static void main(String[] args) {
        
        Knight galahad = new Knight("Galahad", 7, 6, true);
        Knight lancelot = new Knight("Lancelot", 30, 5, false);
        Archer archie = new Archer("Archie", 10, 2);
        Archer a1 = new Archer("Archie", 10, 2);
        Knight a2 = new Knight("Lancelot", 30, 5, false);

        System.out.println(galahad.equals(a2)); // false
        System.out.println(lancelot.equals(a2)); // true
        System.out.println(a2.equals(lancelot)); // true
        System.out.println(a1.equals(archie)); // true
        System.out.println(a2.equals(a2)); // false

        archie.attack(lancelot);
        System.out.println(archie);
        System.out.println(lancelot);

        galahad.attack(archie);
        System.out.println(galahad);
        System.out.println(archie);

        archie.attack(galahad);
        System.out.println(galahad);
        System.out.println(archie);

        lancelot.attack(galahad);
        System.out.println(galahad);
        System.out.println(lancelot);

        lancelot.challenge(galahad);
        System.out.println(galahad);
        System.out.println(lancelot);

        lancelot.healthPotion();
        System.out.println(lancelot);
    }
}