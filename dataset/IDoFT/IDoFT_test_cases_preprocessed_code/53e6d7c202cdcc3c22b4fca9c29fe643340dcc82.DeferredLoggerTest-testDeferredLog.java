@Test public void testDeferredLog(){
DeferredLoggerTest.logger.error("errorLogger_testDeferredLog");//RW
DeferredLoggerTest.logger.info("inFoLogger_testDeferredLog");//RW
DeferredLoggerTest.logger.warn("warnLogger_testDeferredLog");//RW
DeferredLoggerTest.logger.debug("debugLogger_testDeferredLog");//RW
Assert.assertFalse(DeferredLoggerTest.outContent.toString().contains("errorLogger_testDeferredLog"));//RW
Assert.assertFalse(DeferredLoggerTest.outContent.toString().contains("inFoLogger_testDeferredLog"));//RW
Assert.assertFalse(DeferredLoggerTest.outContent.toString().contains("warnLogger_testDeferredLog"));//RW
Assert.assertFalse(DeferredLoggerTest.outContent.toString().contains("debugLogger_testDeferredLog"));//RW
Assert.assertTrue(DeferredLoggerTest.outContent.toString().contains("errorLogger_testDeferredLog"));//RW
Assert.assertTrue(DeferredLoggerTest.outContent.toString().contains("inFoLogger_testDeferredLog"));//RW
Assert.assertTrue(DeferredLoggerTest.outContent.toString().contains("warnLogger_testDeferredLog"));//RW
Assert.assertTrue(DeferredLoggerTest.outContent.toString().contains("debugLogger_testDeferredLog"));//RW
}