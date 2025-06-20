@Test public void testParseDomain() throws Exception {
assertNotNull(resultDomain);
assertEquals(testDomain.getReaders(),resultDomain.getReaders());
assertEquals(testDomain.getOwner(),resultDomain.getOwner());
assertEquals(testDomain.getDescription(),resultDomain.getDescription());
}