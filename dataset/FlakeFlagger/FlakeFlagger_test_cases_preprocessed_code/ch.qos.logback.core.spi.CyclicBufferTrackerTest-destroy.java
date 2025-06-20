@Test public void destroy(){
assertEquals(1,cb.length());
assertEquals(0,tracker.liveKeysAsOrderedList().size());
assertEquals(0,tracker.getComponentCount());
assertEquals(0,cb.length());
}