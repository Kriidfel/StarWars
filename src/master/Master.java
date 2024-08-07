package master;

import java.util.*;

/**
 * Abstract class representing a Master character.
 */
public abstract class Master {
    private final String name;
    private int hp;
    private final int maxHp;
    private final int damage;
    private final HashMap<String, Integer> status;

    /**
     * Constructor for the Master class.
     * @param name The name of the master.
     * @param hp The current health points of the master.
     * @param maxHp The maximum health points of the master.
     * @param damage The damage the master can inflict.
     */
    public Master(String name, int hp, int maxHp, int damage){
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.damage = damage;
        this.status = new HashMap<>();
    }

    /**
     * Sets the current health points of the master.
     * @param hp The new health points.
     */
    public void setHp (int hp) {
        this.hp = hp;
    }

    /**
     * Gets the current health points of the master.
     * @return The current health points.
     */
    public int getHp () {
        return this.hp;
    }

    /**
     * Gets the damage the master can inflict.
     * @return The damage value.
     */
    public int getDamage () {
        return this.damage;
    }

    /**
     * Abstract method for attacking another master.
     * @param master The master to be attacked.
     */
    abstract void attack(Master master);

    /**
     * Checks if the master is still alive.
     * @return True if the master is alive, false otherwise.
     */
    public boolean isAlive(){
         return hp > 0;
    }

    /**
     * Returns a string representation of the master.
     * @return A string with the master's name and current health points.
     */
    @Override
    public String toString(){
         return name + " has " + hp + "/" + maxHp;
     }

    /**
     * Sets a status effect on the master.
     * @param status The status effect.
     * @param turns The number of turns the status effect lasts.
     */
    public void setStatus(String status, int turns) {
        this.status.put(status, turns);
    }

    /**
     * Checks if the master has a specific status effect.
     * @param status The status effect to check.
     * @return True if the master has the status effect, false otherwise.
     */
    public boolean hasStatus(String status) {
        return this.status.containsKey(status);
    }

    /**
     * Removes a status effect from the master.
     * @param status The status effect to remove.
     */
    public void removeStatus(String status) {
        this.status.remove(status);
    }

    /**
     * Decrements the turns of all status effects on the master.
     */
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

    /**
     * Gets the remaining turns of a specific status effect.
     * @param status The status effect to check.
     * @return The number of turns remaining for the status effect.
     */
    public int getStatusTurns(String status) {
        return this.status.getOrDefault(status, 0);
    }

    /**
     * Gets the name of the master.
     * @return The name of the master.
     */
    protected String getName() {
        return this.name;
    }
}