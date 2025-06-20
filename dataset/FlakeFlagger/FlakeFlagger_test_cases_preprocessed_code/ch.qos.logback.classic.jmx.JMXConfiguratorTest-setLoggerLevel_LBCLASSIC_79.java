@Test public void setLoggerLevel_LBCLASSIC_79(){
assertEquals(Level.DEBUG,testLogger.getLevel());
assertNull(testLogger.getLevel());
}