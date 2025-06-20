@Test public void smoke(){
assertTrue(a.isStarted());
assertFalse(a.isStarted());
assertNull(appenderTracker.find(key));
}