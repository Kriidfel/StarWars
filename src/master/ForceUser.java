package master;

/**
 * Interface representing a Force user.
 */
public interface ForceUser {
    /**
     * Uses a Force ability on the target master.
     * @param target The target master.
     */
    void useForce(Master target);
}