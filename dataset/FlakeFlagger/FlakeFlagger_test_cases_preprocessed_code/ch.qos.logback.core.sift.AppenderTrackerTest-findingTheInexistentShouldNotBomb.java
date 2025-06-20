@Test public void findingTheInexistentShouldNotBomb(){
assertNull(appenderTracker.find(key));
assertNull(appenderTracker.find(key));
}