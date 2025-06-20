@Test public void testParameters() throws Exception {
assertThat(registry.getParameters(),hasEntry("k1","v1"));
assertThat(parameters,hasEntry("k1","v1"));
}