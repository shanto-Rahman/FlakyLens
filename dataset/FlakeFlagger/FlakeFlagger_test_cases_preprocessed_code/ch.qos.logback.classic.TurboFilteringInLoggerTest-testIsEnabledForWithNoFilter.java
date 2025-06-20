@Test public void testIsEnabledForWithNoFilter(){
assertFalse(logger.isEnabledFor(Level.INFO));
}