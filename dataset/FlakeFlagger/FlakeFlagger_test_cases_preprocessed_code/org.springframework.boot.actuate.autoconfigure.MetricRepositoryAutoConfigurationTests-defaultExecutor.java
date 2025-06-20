@Test public void defaultExecutor() throws Exception {
assertTrue(executor.getThreadPoolExecutor().isShutdown());
}