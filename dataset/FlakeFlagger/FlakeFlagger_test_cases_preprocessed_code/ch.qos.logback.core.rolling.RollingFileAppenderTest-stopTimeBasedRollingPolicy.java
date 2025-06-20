@Test public void stopTimeBasedRollingPolicy(){
assertTrue(tbrp.isStarted());
assertTrue(rfa.isStarted());
assertFalse(rfa.isStarted());
assertFalse(tbrp.isStarted());
}