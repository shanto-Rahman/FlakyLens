@Test public void clearOnChildThreadShouldNotAffectParent() throws InterruptedException {
assertEquals(firstKey + A_SUFFIX,mdcAdapter.get(firstKey));
assertNull(mdcAdapter.get(firstKey));
clearer.start();
clearer.join();
assertEquals(firstKey + A_SUFFIX,mdcAdapter.get(firstKey));
}