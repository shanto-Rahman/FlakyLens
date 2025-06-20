@Test public void testParameters() throws Exception {
assertThat(monitor.getParameters(),hasEntry("k1","v1"));
}