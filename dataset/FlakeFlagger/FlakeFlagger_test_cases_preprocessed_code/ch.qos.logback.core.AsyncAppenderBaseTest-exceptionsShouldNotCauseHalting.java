@Test public void exceptionsShouldNotCauseHalting() throws InterruptedException {
assertTrue(asyncAppenderBase.isStarted());
assertFalse(asyncAppenderBase.isStarted());
assertEquals(AppenderBase.ALLOWED_REPEATS,statusChecker.matchCount("Appender \\[bad\\] failed to append."));
}