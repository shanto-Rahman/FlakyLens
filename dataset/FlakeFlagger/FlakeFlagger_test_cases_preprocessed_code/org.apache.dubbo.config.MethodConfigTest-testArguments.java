@Test public void testArguments() throws Exception {
assertThat(method.getArguments(),contains(argument));
assertThat(method.getArguments(),Matchers.<ArgumentConfig>hasSize(1));
}