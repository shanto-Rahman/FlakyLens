@Test public void testSetExcludedCipherSuites() throws Exception {
assertTrue(Arrays.equals(new String[]{"B"},configurable.getEnabledCipherSuites()));
}