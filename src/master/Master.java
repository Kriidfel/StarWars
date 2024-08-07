package master;

import java.util.*;

public abstract class Master {
    private final String name;
    private int hp;
    private final int maxHp;
    private final int damage;
    private HashMap<String, Integer> status;

    public Master(String name, int hp, int maxHp, int def, int damage){
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.damage = damage;
    }

    public void setHp (int hp) {
        this.hp = hp;
    }

    public int getHp () {
        return this.hp;
    }

    public int getDamage () {
        return this.damage;
    }

    abstract void attack(Master master);

    public boolean isAlive(){
         return hp > 0;
    }

    @Override
    public String toString(){
         return name + " has " + hp + "/" + maxHp;
     }

    public void setStatus(String status, int turns) {
        this.status.put(status, turns);
    }

    public boolean hasStatus(String status) {
        return this.status.containsKey(status);
    }

    public void removeStatus(String status) {
        this.status.remove(status);
    }

    public void decrementStatusTurns() {
        Iterator<Map.Entry<String, Integer>> iterator = this.status.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            int turns = entry.getValue() - 1;
            if (turns <= 0) {
                iterator.remove();
            } else {
                entry.setValue(turns);
            }
        }
    }

    public int getStatusTurns(String status) {
        return this.status.getOrDefault(status, 0);
    }
}
