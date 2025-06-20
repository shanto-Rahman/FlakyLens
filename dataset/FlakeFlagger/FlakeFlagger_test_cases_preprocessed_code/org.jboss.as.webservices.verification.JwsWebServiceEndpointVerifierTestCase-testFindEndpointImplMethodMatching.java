@Test public void testFindEndpointImplMethodMatching() throws NoSuchMethodException, SecurityException {
assertNotNull(seiMethod);
assertEquals("performWork",seiMethod.getName());
}