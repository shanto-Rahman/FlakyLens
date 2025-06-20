@Test public void testStartNoRemoteAddress() throws Exception {
assertFalse(receiver.isStarted());
assertTrue(status.getMessage().contains("host"));
}