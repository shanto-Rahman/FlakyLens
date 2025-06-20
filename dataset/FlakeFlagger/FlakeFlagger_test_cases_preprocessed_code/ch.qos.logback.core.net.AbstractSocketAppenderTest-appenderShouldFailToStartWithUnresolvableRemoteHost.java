@Test public void appenderShouldFailToStartWithUnresolvableRemoteHost() throws Exception {
assertFalse(instrumentedAppender.isStarted());
assertTrue(mockContext.getLastStatus().getMessage().contains("unknown host"));
}