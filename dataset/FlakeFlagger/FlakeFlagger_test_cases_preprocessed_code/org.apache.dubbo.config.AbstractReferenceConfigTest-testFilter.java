@Test public void testFilter() throws Exception {
assertThat(referenceConfig.getFilter(),equalTo("mockfilter"));
assertThat(parameters,hasValue("prefilter,mockfilter"));
}