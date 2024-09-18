// A library of functions for generating musical notes.
public class Sound {
    public static void main(String[] args) {
    	//// Uncomment the action you want to execute.
        demo1(args[0]);   // Plays a given tone
        // demo2();          // Plays Do Re Mi
        // demo3();          // Plays Do, and then the chord Do-Major
        // demo4(args[0]);   // Plays music from a file
    }
    
    // Test: Plays a given tone
    public static void demo1(String str) {
        double pitch = Double.parseDouble(str);
        // Creates a tone array representing the given pitch (frequency), for 3 seconds
        double[] tone = tone(pitch, 3);
        StdAudio.play(tone);  
    }

    // Test: Plays Do, Re, Mi, each for 0.5 second.
    public static void demo2() {
    	StdAudio.play(note(3, .5)); 
        StdAudio.play(note(5, .5));
        StdAudio.play(note(7, .5));
    }

    // Test: Plays Do for 3 seconds,
    // and then the Do-major chord (Do, Mi and Sol) for 3 seconds each
    public static void demo3() {
        StdAudio.play(note(3, 3));           
        StdAudio.play(chord(3, 7, 10, 3));
    }
    
    // Test: Reads from a file, and plays, a sequence of (i, seconds) notes
    public static void demo4(String fileName) {
        In in = new In(fileName);
        while (!in.isEmpty()) {
           int i = in.readInt();        
           double seconds = in.readDouble();
           StdAudio.play(note(i, seconds));
        }
    }
    
    // Returns an array representing a sampled sine wave modulated according
    // to the given pitch (frequency, in Hz) and  seconds, using a sampling 
    // rate of 44100 values per second.
    public static double[] tone(double pitch, double seconds) {
        int sps = 44100;
        int N = (int) (seconds * sps);
        double[] y = new double[N];
        for (int x = 0; x < N; x++) {
            y[x] = Math.sin(x * pitch * (2 * Math.PI) / sps);
        }
        return y;
    }

    // Returns an array representing the given musical note, and seconds.
    // (0 is A, 1 is A#, 2 is B, 3 is C, 4 is C#, ...).
    public static double[] note(int i, double seconds) {
        return tone(440.0 * Math.pow(2, i / 12.0), seconds);
    }
    
    // Returns the weighted sum of two given arrays, using two given weights.
    public static double[] sum(double[] a, double[] b, double awt, double bwt) {
        double[] c = new double[a.length];
        for (int i = 0; i < a.length; i++)
            c[i] = a[i] * awt + b[i] * bwt;
        return c;
    }

    // Returns a 3-note chord by combining the three given notes.
    public static double[] chord(int i1, int i2, int i3, double seconds) {
        double[] a1 = note(i1, seconds);
        double[] a2 = note(i2, seconds);
        double[] a3 = note(i3, seconds);
        // builds and returns an equal mix of the three notes
        double[] s = sum(a1, a2, .5, .5);
        s = sum(s, a3, .5, .5);
        return s;
     }
}