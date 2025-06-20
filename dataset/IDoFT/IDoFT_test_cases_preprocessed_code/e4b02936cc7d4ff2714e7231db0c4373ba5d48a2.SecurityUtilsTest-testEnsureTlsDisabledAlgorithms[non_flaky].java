@Test public void testEnsureTlsDisabledAlgorithms(){
assertNotNull(disabledAlgorithms);
assertTrue(disabledAlgorithms.contains("TLSv1,"));
assertTrue(disabledAlgorithms.contains("TLSv1.1,"));
assertNotNull(disabledAlgorithms);
assertFalse(disabledAlgorithms.contains("TLSv1,"));
assertFalse(disabledAlgorithms.contains("TLSv1.1,"));
}