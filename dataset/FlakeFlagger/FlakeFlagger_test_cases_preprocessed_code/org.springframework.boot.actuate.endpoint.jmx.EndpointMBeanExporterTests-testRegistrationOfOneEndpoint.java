@Test public void testRegistrationOfOneEndpoint() throws Exception {
assertNotNull(mbeanInfo);
assertEquals(3,mbeanInfo.getOperations().length);
assertEquals(3,mbeanInfo.getAttributes().length);
}