/**
* Program that creates an archer object.
* @author Jordan Collins
* @version 1.0
*/
public class Archer extends Adventurer {
    private int arrows = 10;

    /** A constructor that takes in name, health, and attack values.
    * @param n The name of the archer.
    * @param h The health attribute of the archer.
    * @param a The atack attribute of the archer.
    */
    public Archer(String n, int h, int a) {
        super(n, h, a);
    }

    /** A constructor that takes in a name.
    * @param n The name of the adventerur.
    */
    public Archer(String n) {
        super(n, 75, 40);
    }

    /** A method to get the arrow attribute of an archer.
    * @return Returns an int holding the arrows held by the archer.
    */
    public int getArrows() {
        return arrows;
    }

    /** A method to get the arrow attribute of an archer.
    * @param a The arrow attribute of the archer.
    */
    public void setArrows(int a) {
        arrows = a;
    }

    @Override
    public void attack(Adventurer a) {
        if (a != null) {
            if (this.arrows >= 1) {
                if (this.getHealth() > 0) {
                    a.setHealth(a.getHealth() - this.getAttack());
                    this.setArrows(this.arrows - 1);
                    if (a.getHealth() < 0) {
                        a.setHealth(0);
                    }
                }
            }
        }
    }

    // @Override
    // public boolean equals(Archer a) {
    //     return super.equals(a) && this.arrows == a.arrows;
    // }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Archer)) {
            return false;
        } else {
            Archer a = (Archer) o;
            return super.equals(a) && this.arrows == a.arrows;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Arrows: " + this.arrows;
    }
}