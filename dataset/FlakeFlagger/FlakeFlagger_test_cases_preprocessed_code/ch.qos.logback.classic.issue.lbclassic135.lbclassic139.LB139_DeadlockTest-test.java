@Test public void test() throws Exception {
workerThread.start();
accessorThread.start();
Thread.sleep(sleep);
workerThread.join();
accessorThread.join();
}