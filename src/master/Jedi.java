package master;

public class Jedi extends Master implements ForceUser {
    private final int force;
    private int cpt;

    public Jedi(String name, int hp, int maxHp, int def, int damage, int force) {
        super(name, hp, maxHp, def, damage);
        this.force = force;
    }

    @Override
    public void useForce(Master target) {
        if (this.cpt % 5 == 0) {
            push(target);
            target.setHp(target.getHp() - force);
        }
    }

    private void push(Master target) {
        target.setStatus("pushed", 2);
    }

    @Override
    public void attack(Master target) {
        target.setHp(target.getHp() - this.getDamage());
        cpt++;
        useForce(target);
    }
}
