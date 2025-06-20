@Test public void testGracefulShutdown1() throws Exception {
when(executor.isTerminated()).thenReturn(false,true);
when(executor.awaitTermination(20,TimeUnit.MILLISECONDS)).thenReturn(false);
}