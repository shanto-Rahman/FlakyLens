@Test public void appenderShouldFailToStartWithoutValidRemoteHost() throws Exception {
assertFalse(instrumentedAppender.isStarted());
assertTrue(mockContext.getLastStatus().getMessage().contains("remote host"));
}