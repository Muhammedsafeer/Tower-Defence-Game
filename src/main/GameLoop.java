package main;

public class GameLoop implements Runnable {

    GamePanel gp;

    private static final int MAX_FPS = 60;
    private static final int MAX_UPS = 60;
    private static final long OPTIMAL_TIME = 1000000000 / MAX_UPS;

    private boolean isRunning = false;
    private long lastUpdateTime = System.nanoTime();
    private long lastRenderTime = System.nanoTime();
    private double deltaTime = 0;
    private int updateCount = 0;
    private int frameCount = 0;

    public GameLoop(GamePanel gp) {
        this.gp = gp;
    }

    // Game loop
    public void run() {
        Thread fpsThread = new Thread(new FPSThread());
        fpsThread.start();
        Thread upsThread = new Thread(new UPSThread());
        upsThread.start();

        long lastLoopTime = System.nanoTime();

        while (isRunning) {
            long currentTime = System.nanoTime();
            deltaTime = (currentTime - lastUpdateTime) / 1000000000.0;
            lastUpdateTime = currentTime;

            update(deltaTime);
            updateCount++;

            render();
            lastRenderTime = currentTime;
            frameCount++;

            // Wait to ensure consistent frame rate
            long sleepTime = (lastLoopTime - System.nanoTime() + 1000000000 / MAX_FPS) / 1000000;
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            while (lastLoopTime - System.nanoTime() < 0) {
                lastLoopTime += 1000000000 / MAX_UPS;
            }
        }

        fpsThread.interrupt();
        upsThread.interrupt();
    }

    // Update game state
    private void update(double deltaTime) {
        // Update game state here using delta time
        gp.update(deltaTime);
    }

    // Render game state
    private void render() {
        // Render game state here
        gp.repaint();
    }

    // Start game thread
    public synchronized void start() {
        isRunning = true;
        new Thread(this).start();
    }

    // Stop game thread
    public synchronized void stop() {
        isRunning = false;
    }

    // Thread for displaying the FPS
    private class FPSThread implements Runnable {
        public void run() {
            long lastFpsTime = 0;
            int fps = 0;

            while (!Thread.currentThread().isInterrupted()) {
                long currentTime = System.nanoTime();

                if (currentTime - lastFpsTime >= 1000000000) {
                    fps = 0;
                    lastFpsTime = currentTime;
                }

                fps++;
            }
        }
    }

    // Thread for displaying the UPS
    private class UPSThread implements Runnable {
        public void run() {
            long lastUpsTime = 0;
            int ups = 0;

            while (!Thread.currentThread().isInterrupted()) {
                long currentTime = System.nanoTime();

                if (currentTime - lastUpsTime >= 1000000000) {
                    ups = 0;
                    lastUpsTime = currentTime;
                }

                ups++;
            }
        }
    }
}