package master;

/**
 * Class representing a Sith character.
 */
public class Sith extends Master implements ForceUser {
    private int cpt;

    /**
     * Constructor for the Sith class.
     * @param name The name of the Sith.
     * @param hp The current health points of the Sith.
     * @param maxHp The maximum health points of the Sith.
     * @param damage The damage the Sith can inflict.
     */
    public Sith(String name, int hp, int maxHp, int damage) {
        super(name, hp, maxHp, damage);
    }

    /**
     * Uses a Force ability on the target master.
     * @param target The target master.
     */
    @Override
    public void useForce(Master target) {
        if (this.cpt % 6 == 0) {
            lighting(target);
            System.out.println(this.getName() + " used lighting on " + target.getName());
        } else if (this.cpt % 2 == 0) {
            stroke(target);
            System.out.println(this.getName() + " used stroke on " + target.getName());
        }
    }

    /**
     * Inflicts stroke damage on the target master.
     * @param target The target master.
     */
    private void stroke(Master target) {
        target.setHp(target.getHp() - (int) (this.getDamage() * 0.5));
    }

    /**
     * Inflicts lighting damage on the target master.
     * @param target The target master.
     */
    private void lighting(Master target) {
        target.setHp(target.getHp() - (int) (this.getDamage() * 1.5));
    }

    /**
     * Attacks the target master and uses a Force ability.
     * @param target The target master.
     */
    @Override
    public void attack(Master target) {
        target.setHp(target.getHp() - this.getDamage());
        cpt++;
        System.out.println(this.getName() + " attacked " + target.getName());
        useForce(target);
    }
}