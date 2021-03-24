/**
* Program that creates an adventurer object.
* @author Jordan Collins
* @version 1.0
*/
public abstract class Adventurer {
    private String name;
    private final int attack;
    private int health;

    /** A constructor that takes in name, health, and attack values.
    * @param n The name of the adventerur.
    * @param h The health attribute of the adventerur.
    * @param a The atack attribute of the adventerur.
    */
    public Adventurer(String n, int h, int a) {
        name = n;
        health = h;
        attack = a;
    }

    /** An abstract attack method for adventurers.
    * @param a An instance of the adventurer class.
    */
    public abstract void attack(Adventurer a);

    /** A method that adds a set amount of health to the adventerur. */
    public void healthPotion() {
        health += 15;
    }

    // @Override
    // public boolean equals(Adventurer a) {
    //     return this.health == a.health && this.attack == a.attack && this.name == a.name;
    // }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Adventurer)) {
            return false;
        } else {
            Adventurer a = (Adventurer) o;
            return this.health == a.health && this.attack == a.attack && this.name == a.name;
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Health: " + health + ", Attack: " + attack;
    }

    /** A method to get the health attribute of an adventerur.
    * @return Returns an int holding the health of the adventerur.
    */
    public int getHealth() {
        return health;
    }

    /** A method to set the health attribute of an adventerur.
    * @param h The health attribute of the adventerur.
    */
    public void setHealth(int h) {
        health = h;
    }

    /** A method to get the attack attribute of an adventerur.
    * @return Returns an int holding the attack of the adventerur.
    */
    public int getAttack() {
        return attack;
    }
}