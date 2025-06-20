@Test public void testSetExcludedAndIncludedCipherSuites() throws Exception {
assertTrue(Arrays.equals(new String[]{"A"},configurable.getEnabledCipherSuites()));
}