@Test public void testArguments() throws Exception {
assertThat(parameters,hasEntry("callback","true"));
assertThat(parameters.size(),is(1));
}