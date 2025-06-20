@Test public void resetTest_LBCORE_104(){
assertEquals("valA",lc.getProperty("keyA"));
assertEquals("valA",lc.getObject("keyA"));
assertNull(lc.getProperty("keyA"));
assertNull(lc.getObject("keyA"));
}