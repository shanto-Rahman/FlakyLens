@Test public void trackerShouldHonorMaxComponentsParameter(){
assertEquals(max,appenderTracker.allKeys().size());
assertNull(appenderTracker.find(key + "-" + 0));
assertFalse(appenderList.get(0).isStarted());
}