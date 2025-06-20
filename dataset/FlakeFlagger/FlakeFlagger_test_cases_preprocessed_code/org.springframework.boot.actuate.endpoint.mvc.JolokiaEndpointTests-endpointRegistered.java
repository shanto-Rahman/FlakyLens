@Test public void endpointRegistered() throws Exception {
assertEquals(1,values.size());
assertTrue(values.iterator().next() instanceof JolokiaMvcEndpoint);
}