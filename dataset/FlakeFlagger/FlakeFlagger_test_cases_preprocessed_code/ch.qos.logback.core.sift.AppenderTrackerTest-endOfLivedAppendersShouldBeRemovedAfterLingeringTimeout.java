@Test public void endOfLivedAppendersShouldBeRemovedAfterLingeringTimeout(){
assertFalse(a.isStarted());
assertNull(a);
}