@Test public void testStartUnknownHost() throws Exception {
assertFalse(receiver.isStarted());
assertTrue(status.getMessage().contains("unknown host"));
}