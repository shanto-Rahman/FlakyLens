@Test public void testStartNoPort() throws Exception {
assertFalse(receiver.isStarted());
assertTrue(status.getMessage().contains("port"));
}