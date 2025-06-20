@Test public void testParameters() throws Exception {
assertThat(parameters,hasEntry("k1","v1"));
assertThat(parameters,hasEntry(Constants.ACCEPT_FOREIGN_IP,"true"));
}