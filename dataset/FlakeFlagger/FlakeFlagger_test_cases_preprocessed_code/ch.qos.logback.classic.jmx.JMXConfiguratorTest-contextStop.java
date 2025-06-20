@Test public void contextStop() throws Exception {
assertEquals(1,listenerList.size());
assertEquals(0,listenerList.size());
assertFalse(mbs.isRegistered(objectName));
}