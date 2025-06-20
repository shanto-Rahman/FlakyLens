@Test public void getExecutor2() throws Exception {
assertThat(executor.getQueue(),Matchers.<BlockingQueue<Runnable>>instanceOf(LinkedBlockingQueue.class));
}