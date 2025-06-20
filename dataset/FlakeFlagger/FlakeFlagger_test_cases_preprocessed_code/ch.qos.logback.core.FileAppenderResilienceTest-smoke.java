@Test public void smoke() throws InterruptedException, IOException {
t.start();
Thread.sleep((int)(RecoveryCoordinator.BACKOFF_COEFFICIENT_MIN * delayCoefficient));
t.join();
}