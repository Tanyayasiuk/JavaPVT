package javapvt.lesson5;

/**
 * Created by ОК on 01.06.2017.
 */
public class RobotVacuumCleaner extends VacuumCleaner {

    private int wifiRadius;
    private float AutonomTime;

    public int getWifiRadius() {
        return wifiRadius;
    }

    public void setWifiRadius(int wifiRadius) {
        this.wifiRadius = wifiRadius;
    }

    public float getAutonomTime() {
        return AutonomTime;
    }

    public void setAutonomTime(float autonomTime) {
        AutonomTime = autonomTime;
    }
}