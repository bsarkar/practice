package home.generictests;

public class syncTest {

        private static Integer sync = 0;
        public void someMethod() {
                synchronized (sync) {
                	// synchronized on ClassLoader/JVM level
                }
        }

	public static void main(String[] args) {
		
	}
}
