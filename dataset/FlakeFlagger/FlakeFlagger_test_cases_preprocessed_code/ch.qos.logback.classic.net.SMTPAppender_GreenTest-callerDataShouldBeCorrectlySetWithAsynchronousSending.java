@Test public void callerDataShouldBeCorrectlySetWithAsynchronousSending() throws Exception {
assertTrue("actual [" + body + "]",body.contains("DEBUG " + this.getClass().getName() + " - LOGBACK-734"));
}