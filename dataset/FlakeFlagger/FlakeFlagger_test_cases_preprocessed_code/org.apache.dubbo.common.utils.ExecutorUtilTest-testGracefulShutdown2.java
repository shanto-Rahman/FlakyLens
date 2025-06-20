@Test public void testGracefulShutdown2() throws Exception {
when(executor.isTerminated()).thenReturn(false,false,false);
when(executor.awaitTermination(20,TimeUnit.MILLISECONDS)).thenReturn(false);
when(executor.awaitTermination(10,TimeUnit.MILLISECONDS)).thenReturn(false,true);
Thread.sleep(2000);
}