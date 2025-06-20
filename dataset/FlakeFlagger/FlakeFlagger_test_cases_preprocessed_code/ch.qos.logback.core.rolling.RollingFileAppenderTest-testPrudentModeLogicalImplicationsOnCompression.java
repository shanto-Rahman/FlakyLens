@Test public void testPrudentModeLogicalImplicationsOnCompression(){
assertFalse(rfa.isStarted());
assertEquals(Status.ERROR,checker.getHighestLevel(0));
}