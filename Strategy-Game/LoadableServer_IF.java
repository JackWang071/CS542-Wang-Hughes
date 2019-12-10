package cs542_project;

/**
 *
 * @author Jack and Duran
 */

//loadable server interface
public interface LoadableServer_IF {
    public void start();
    public void setEnvironment(GameManager_IF env);
}
