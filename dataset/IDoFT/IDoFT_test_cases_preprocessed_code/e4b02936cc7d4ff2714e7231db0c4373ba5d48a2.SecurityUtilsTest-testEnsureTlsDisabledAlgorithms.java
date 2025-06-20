@Test public void testEnsureTlsDisabledAlgorithms(){
assertNotNull(disabledAlgorithms);
assertTrue(disabledAlgorithms.contains("TLSv1,"));
assertNotNull(disabledAlgorithms);
assertFalse(disabledAlgorithms.contains("TLSv1,"));
}