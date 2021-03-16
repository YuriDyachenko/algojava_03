package kurs;

public class Duration {
    private long fixNanoTime;

    public void fix(String message) {
        if (message != null) {
            System.out.println(message);
            System.out.println("старт...");
        }
        fixNanoTime = System.nanoTime();
    }

    public void fix() {
        fix(null);
    }

    public void outAndFix(String message) {
        long currentNanoTime = System.nanoTime();
        System.out.println(message + ": " + (currentNanoTime - fixNanoTime));
        fix();
    }
}
