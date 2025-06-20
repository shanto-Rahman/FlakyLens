@Test public void smoke(){
assertEquals(cb,tracker.getOrCreate(key,now++));
assertEquals(0,tracker.liveKeysAsOrderedList().size());
assertEquals(0,tracker.getComponentCount());
}