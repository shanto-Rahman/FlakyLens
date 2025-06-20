@Test public void testSequenceListener(){
assertNull(sl.received);
assertEquals(sl.received.toString(),MSG_05.toString());
}