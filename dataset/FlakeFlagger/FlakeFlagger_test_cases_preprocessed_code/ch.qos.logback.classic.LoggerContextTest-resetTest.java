@Test public void resetTest(){
assertEquals(Level.DEBUG,root.getEffectiveLevel());
assertTrue(root.isDebugEnabled());
assertEquals(Level.DEBUG,a.getEffectiveLevel());
assertEquals(Level.DEBUG,ab.getEffectiveLevel());
assertEquals(Level.DEBUG,root.getLevel());
assertNull(a.getLevel());
assertNull(ab.getLevel());
}