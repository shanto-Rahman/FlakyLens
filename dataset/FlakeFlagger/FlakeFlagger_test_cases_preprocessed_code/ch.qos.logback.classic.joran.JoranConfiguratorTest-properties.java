@Test public void properties() throws JoranException {
assertNull(loggerContext.getProperty(CoreConstants.HOSTNAME_KEY));
assertNull(System.getProperty("sys"));
assertNotNull(loggerContext.getProperty(CoreConstants.HOSTNAME_KEY));
assertNull(loggerContext.getProperty("transientKey1"));
assertNull(loggerContext.getProperty("transientKey2"));
assertEquals("node0",loggerContext.getProperty("nodeId"));
assertEquals("tem",System.getProperty("sys"));
assertNotNull(loggerContext.getProperty("path"));
}