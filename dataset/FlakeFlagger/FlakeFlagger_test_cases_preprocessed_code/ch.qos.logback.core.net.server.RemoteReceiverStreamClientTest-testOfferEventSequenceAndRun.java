@Test public void testOfferEventSequenceAndRun() throws Exception {
thread.start();
thread.join(1000);
assertFalse(thread.isAlive());
assertEquals(TEST_EVENT + i,ois.readObject());
}