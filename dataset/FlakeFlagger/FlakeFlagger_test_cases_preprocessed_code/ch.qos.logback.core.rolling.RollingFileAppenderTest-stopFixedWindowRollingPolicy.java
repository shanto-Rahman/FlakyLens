@Test public void stopFixedWindowRollingPolicy(){
assertTrue(fwRollingPolicy.isStarted());
assertTrue(sbTriggeringPolicy.isStarted());
assertTrue(rfa.isStarted());
assertFalse(rfa.isStarted());
assertFalse(fwRollingPolicy.isStarted());
assertFalse(sbTriggeringPolicy.isStarted());
}