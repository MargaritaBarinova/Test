import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        method1();

        System.out.println("Прогонка массива через потоки - от 2 до 10:");
        System.out.println("Потоки | Время");
        for (int i = 2; i <= 10; i++) {
            String tab = "         ";
            System.out.print(i + tab.substring(0, tab.length() - i / 10));
            method2(i);
        }


    }

    public static void method1() {
        final int size = 10000000;
        float[] arr = new float[size];

        fillArrayBy1(arr);
        long a = System.currentTimeMillis();
        fillArrayByFormula(arr);
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void method2(int splitter) {
        final int size = 10000000;
        final int h = size / splitter;
        float[] arr = new float[size];

        fillArrayBy1(arr);
        long a = System.currentTimeMillis();

        List<float[]> listOfArrays = splitArray(size, splitter, h, arr);
        List<Thread> listOfThreads = new ArrayList<>();

        for (float[] arrayInThread : listOfArrays) {
            listOfThreads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    fillArrayByFormula(arrayInThread);
                }
            }));
        }

        for (Thread thread : listOfThreads) {
            thread.start();
        }

        for (Thread thread : listOfThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        arr = glueArray(size, splitter, h, listOfArrays);

        long c = System.currentTimeMillis();
        System.out.println(c - a);

    }

    private static List<float[]> splitArray(int size, int splitter, int h, float[] arr) {
        List<float[]> listOfArrays = new ArrayList<>();
        int i = 0;
        while (i < splitter - 1) {
            float[] m = new float[h];
            System.arraycopy(arr, i * h, m, 0, h);
            listOfArrays.add(m);
            i++;
        }

        int lastSize = size - i * h;
        float[] m = new float[lastSize];
        System.arraycopy(arr, i * h, m, 0, lastSize);
        listOfArrays.add(m);
        return listOfArrays;
    }

    private static float[] glueArray(int size, int splitter, int h, List<float[]> listOfArrays) {
        float[] arr = new float[size];
        for (int i = 0; i <= splitter - 1; i++) {
            System.arraycopy(listOfArrays.get(i), 0, arr, i * h, listOfArrays.get(i).length);
        }
        return arr;
    }

    private static void fillArrayBy1(float[] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {
            arr[i] = 1;
        }
    }

    private static void fillArrayByFormula(float[] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

}
