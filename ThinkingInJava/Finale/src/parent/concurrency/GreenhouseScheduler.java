package parent.concurrency;

import java.util.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GreenhouseScheduler {
    private volatile boolean light = false;
    private volatile boolean water = false;
    private String thermostat = "Day";

    public synchronized String getThermostat() {
        return thermostat;
    }

    public synchronized void setThermostat(String thermostat) {
        this.thermostat = thermostat;
    }

    ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(10);

    public void schedule(Runnable event, long delay) {
        scheduler.schedule(event, delay, TimeUnit.MILLISECONDS);
    }

    public void repeat(Runnable event, long initialDelay, long period) {
        scheduler.scheduleAtFixedRate(event, initialDelay, period, TimeUnit.MILLISECONDS);
    }

    class LightOn implements Runnable {

        @Override
        public void run() {
            System.out.println("Turing on lights");
            light = true;
        }
    }

    class LightOff implements Runnable {

        @Override
        public void run() {
            System.out.println("Turing off lights");
            light = false;
        }
    }

    class WaterOn implements Runnable {

        @Override
        public void run() {
            System.out.println("Turning greenhouse water on ");
            water = true;
        }
    }

    class WaterOff implements Runnable {

        @Override
        public void run() {
            System.out.println("Turning greenhouse water off");
            water = false;
        }
    }

    class ThermostatNight implements Runnable {

        @Override
        public void run() {
            System.out.println("Thermostat to night setting");
            setThermostat("Night");
        }
    }

    class ThermostatDay implements Runnable {

        @Override
        public void run() {
            System.out.println("Thermostat to day setting");
            setThermostat("Day");
        }
    }

    class Bell implements Runnable {

        @Override
        public void run() {
            System.out.println("Bing!");
        }
    }

    class Terminate implements Runnable {

        @Override
        public void run() {
            System.out.println("Terminating");
            scheduler.shutdownNow();
            new Thread() {
                @Override
                public void run() {
                    for (DataPoint d : data)
                        System.out.println(d);
                }
            }.start();
        }
    }


    static class DataPoint {
        final Calendar time;
        final float temperature;
        final float humidity;

        public DataPoint(Calendar time, float temperature, float humidity) {
            this.time = time;
            this.temperature = temperature;
            this.humidity = humidity;
        }

        @Override
        public String toString() {
            return time.getTime() + String.format(" temperature: %1s$.1f humidity: %2$.2f", temperature, humidity);
        }
    }

    private Calendar lastTime = Calendar.getInstance();

    {
        lastTime.set(Calendar.MINUTE, 30);
        lastTime.set(Calendar.SECOND, 00);
    }

    private float lastTemp = 65.0f;
    private int tempDirection = +1;
    private float lastHumidity = 50.0f;
    private int humidityDirection = +1;
    private Random rand = new Random(47);
    List<DataPoint> data = Collections.synchronizedList(new ArrayList<DataPoint>());

    class CollectData implements Runnable {

        @Override
        public void run() {
            System.out.println("Collecting data");
            synchronized (GreenhouseScheduler.this) {
                // Pretend the interval is longer than it is:
                lastTime.set(Calendar.MINUTE, lastTime.get(Calendar.MINUTE) + 30);
                // One in 5 chances of reversing the direction:
                if (rand.nextInt(5) == 4)
                    tempDirection = -tempDirection;
                // Store previous value:
                lastTemp = lastTemp + tempDirection * (1.0f + rand.nextFloat());
                if (rand.nextInt(5) == 4)
                    humidityDirection = -humidityDirection;
                lastHumidity = lastHumidity + humidityDirection * rand.nextFloat();
                data.add(new DataPoint((Calendar) lastTime.clone(), lastTemp, lastHumidity));
            }
        }
    }
}
