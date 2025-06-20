@Test public void testParameters() throws Exception {
assertThat(protocol.getParameters(),hasEntry("k1","v1"));
}