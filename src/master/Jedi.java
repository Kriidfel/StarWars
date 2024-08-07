package master;

/**
 * Class representing a Jedi character.
 */
public class Jedi extends Master implements ForceUser {
    private final int force;
    private int cpt;

    /**
     * Constructor for the Jedi class.
     * @param name The name of the Jedi.
     * @param hp The current health points of the Jedi.
     * @param maxHp The maximum health points of the Jedi.
     * @param damage The damage the Jedi can inflict.
     * @param force The force power of the Jedi.
     */
    public Jedi(String name, int hp, int maxHp, int damage, int force) {
        super(name, hp, maxHp, damage);
        this.force = force;
    }

    /**
     * Uses a Force ability on the target master.
     * @param target The target master.
     */
    @Override
    public void useForce(Master target) {
        if (this.cpt % 5 == 0) {
            push(target);
            target.setHp(target.getHp() - force);
            System.out.println(this.getName() + " pushed " + target.getName());
        }
    }

    /**
     * Inflicts a push status effect on the target master.
     * @param target The target master.
     */
    private void push(Master target) {
        target.setStatus("pushed", 2);
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