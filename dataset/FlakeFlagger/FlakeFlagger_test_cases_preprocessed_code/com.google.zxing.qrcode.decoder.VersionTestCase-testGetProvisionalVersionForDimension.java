@Test public void testGetProvisionalVersionForDimension() throws Exception {
assertEquals(i,Version.getProvisionalVersionForDimension(4 * i + 17).getVersionNumber());
}