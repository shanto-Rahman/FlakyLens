@Test public void testDefault() throws Exception {
assertThat(provider.isDefault(),is(true));
assertThat(parameters,not(hasKey("default")));
}