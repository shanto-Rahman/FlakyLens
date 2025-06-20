@Test public void testRootGetLogger(){
assertEquals(Level.DEBUG,root.getLevel());
assertEquals(Level.DEBUG,root.getEffectiveLevel());
}