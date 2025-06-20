@Test public void testAppendFailure(){
assertEquals(i,context.getStatusManager().getCount());
assertTrue(appender.isStarted());
assertEquals(4,context.getStatusManager().getCount());
assertFalse(appender.isStarted());
}