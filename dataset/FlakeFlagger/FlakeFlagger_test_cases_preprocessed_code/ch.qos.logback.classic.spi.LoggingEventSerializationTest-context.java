@Test public void context() throws Exception {
assertNotNull(remoteEvent.getLoggerName());
assertEquals(Logger.ROOT_LOGGER_NAME,remoteEvent.getLoggerName());
assertNotNull(loggerContextRemoteView);
assertEquals("testContext",loggerContextRemoteView.getName());
assertNotNull(props);
assertEquals("testValue",props.get("testKey"));
}