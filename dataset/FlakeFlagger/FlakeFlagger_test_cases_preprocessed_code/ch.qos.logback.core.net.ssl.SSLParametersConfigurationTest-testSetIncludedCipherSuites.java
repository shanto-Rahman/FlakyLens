@Test public void testSetIncludedCipherSuites() throws Exception {
assertTrue(Arrays.equals(new String[]{"A","B","C","D"},configurable.getEnabledCipherSuites()));
}