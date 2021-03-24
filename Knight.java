/**
* Program that creates a knight object.
* @author Jordan Collins
* @version 1.0
*/
public class Knight extends Adventurer {
    private boolean hasSquire;

    /** A constructor that takes in name, health, and attack values.
    * @param n The name of the knight.
    * @param h The health attribute of the knight.
    * @param a The atack attribute of the knight.
    * @param b The boolean squire value for the knight.
    */
    public Knight(String n, int a, int h, boolean b) {
        super(n, a, h);
        hasSquire = b;
    }

    /** A constructor that takes in name, health, and attack values.
    * @param n The name of the knight.
    */
    public Knight(String n) {
        super(n, 100, 15);
        hasSquire = true;
    }

    /** A method to see if an archer has a squire.
    * @return Returns a boolean holding the squire value of the archer.
    */
    public boolean getSquire() {
        return hasSquire;
    }

    /** A method to set if an archer has a squire.
    * @param s A boolean squire value for the knight
    */
    public void setSquire(boolean s) {
        hasSquire = s;
    }

    @Override
    public void attack(Adventurer a) {
        if (a != null) {
            if (this.getHealth() == 0) {
                a.setHealth(a.getHealth() - 0);
            } else if (!hasSquire) {
                a.setHealth(a.getHealth() - this.getAttack());
                if (a.getHealth() < 0) {
                    a.setHealth(0);
                }
            } else {
                a.setHealth(a.getHealth() - (this.getAttack() * 2));
                if (a.getHealth() < 0) {
                    a.setHealth(0);
                }
            }
        }
    }

    /** A method that allows knight to challenge other knights and steal a squire.
    * @param k An instance of the knight class.
    */
    public void challenge(Knight k) {
        if (k != null) {
            if (this.getHealth() > 0) {
                if (!this.hasSquire) {
                    if (k.hasSquire) {
                        this.attack(k);
                        if (k.getHealth() == 0) {
                            k.hasSquire = false;
                            this.hasSquire = true;
                        } else {
                            k.attack(this);
                        }
                    }
                }
            }
        }
    }

    // @Override
    // public boolean equals(Knight k) {
    //     return super.equals(k) && this.hasSquire == k.hasSquire;
    // }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Knight)) {
            return false;
        } else {
            Knight a = (Knight) o;
            return super.equals(a) && this.hasSquire == a.hasSquire;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Squire: " + this.hasSquire;
    }
}