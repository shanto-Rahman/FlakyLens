@Test public void trackerShouldHonorTimeoutParameter(){
assertEquals(numComponentsCreated,appenderTracker.allKeys().size());
assertEquals(numComponentsCreated - 1,appenderTracker.allKeys().size());
assertNull(appenderTracker.find(key + "-" + 0));
assertFalse(appenderList.get(0).isStarted());
assertNotNull(appenderTracker.find(key + "-" + i));
assertTrue(appenderList.get(i).isStarted());
}