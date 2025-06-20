@Test public void empty1(){
assertNotNull(tracker.getOrCreate(key,now++));
assertEquals(0,tracker.liveKeysAsOrderedList().size());
assertEquals(0,tracker.getComponentCount());
assertNotNull(tracker.getOrCreate(key,now++));
}