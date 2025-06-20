@Test public void nearSimultaneousPutsShouldNotCauseConcurrentModificationException() throws InterruptedException {
Thread.yield();
childThread.start();
Thread.sleep(1);
childThread.join();
assertTrue(childThread.successful);
}