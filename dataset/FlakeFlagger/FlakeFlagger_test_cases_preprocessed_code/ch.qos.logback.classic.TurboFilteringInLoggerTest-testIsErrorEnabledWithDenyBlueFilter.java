@Test public void testIsErrorEnabledWithDenyBlueFilter(){
assertFalse(logger.isDebugEnabled(blueMarker));
}