@Test public void endOfLivedAppenderShouldBeAvailableDuringLingeringPeriod(){
assertTrue(lingering.isStarted());
assertTrue(a == lingering);
assertFalse(a.isStarted());
assertNull(a);
}