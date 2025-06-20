@Test public void testCancel() throws InterruptedException {
when(config.getExecutor()).thenReturn(Executors.newSingleThreadScheduledExecutor());
Thread.sleep(1000);
}