@Test public void appenderShouldFailToStartWithoutValidPort() throws Exception {
assertFalse(instrumentedAppender.isStarted());
assertTrue(mockContext.getLastStatus().getMessage().contains("port"));
}