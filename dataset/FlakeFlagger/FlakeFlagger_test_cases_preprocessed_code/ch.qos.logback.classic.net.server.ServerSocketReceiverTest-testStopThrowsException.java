@Test public void testStopThrowsException() throws Exception {
assertTrue(receiver.isStarted());
assertNotNull(status);
assertTrue(status instanceof ErrorStatus);
assertTrue(status.getMessage().contains(ex.getMessage()));
assertSame(ex,status.getThrowable());
}