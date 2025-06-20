@Test public void testDeferredLog(){
  DeferredLogger.enable();
  DeferredLoggerTest.logger.error("errorLogger_testDeferredLog");
  DeferredLoggerTest.logger.info("inFoLogger_testDeferredLog");
  DeferredLoggerTest.logger.warn("warnLogger_testDeferredLog");
  DeferredLoggerTest.logger.debug("debugLogger_testDeferredLog");
  Assert.assertFalse(DeferredLoggerTest.outContent.toString().contains("errorLogger_testDeferredLog"));
  Assert.assertFalse(DeferredLoggerTest.outContent.toString().contains("inFoLogger_testDeferredLog"));
  Assert.assertFalse(DeferredLoggerTest.outContent.toString().contains("warnLogger_testDeferredLog"));
  Assert.assertFalse(DeferredLoggerTest.outContent.toString().contains("debugLogger_testDeferredLog"));
  DeferredLogCache.replayTo();
  Assert.assertTrue(DeferredLoggerTest.outContent.toString().contains("errorLogger_testDeferredLog"));
  Assert.assertTrue(DeferredLoggerTest.outContent.toString().contains("inFoLogger_testDeferredLog"));
  Assert.assertTrue(DeferredLoggerTest.outContent.toString().contains("warnLogger_testDeferredLog"));
  Assert.assertTrue(DeferredLoggerTest.outContent.toString().contains("debugLogger_testDeferredLog"));
}
