@Test public void testShutdownNow() throws Exception {
when(executor.isTerminated()).thenReturn(false,true);
}