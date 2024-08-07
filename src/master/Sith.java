package master;

public class Sith extends Master implements ForceUser {
    private int cpt;

    public Sith(String name, int hp, int maxHp, int def, int damage) {
        super(name, hp, maxHp, def, damage);
    }

    @Override
    public void useForce(Master target) {
        if (this.cpt % 6 == 0) {
            lighting(target);
        } else if (this.cpt % 2 == 0) {
            stroke(target);
        }
    }

    private void stroke(Master target) {
        target.setHp(target.getHp() - (int) (this.getDamage() * 0.5));
    }

    private void lighting(Master target) {
        target.setHp(target.getHp() - (int) (this.getDamage() * 1.5));
    }

    @Override
    public void attack(Master target) {
        target.setHp(target.getHp() - this.getDamage());
        cpt ++;
        useForce(target);
    }

}
