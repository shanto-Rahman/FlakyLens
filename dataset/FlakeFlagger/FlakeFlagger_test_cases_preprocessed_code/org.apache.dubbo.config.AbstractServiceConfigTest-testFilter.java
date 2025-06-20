@Test public void testFilter() throws Exception {
assertThat(serviceConfig.getFilter(),equalTo("mockfilter"));
assertThat(parameters,hasEntry(Constants.SERVICE_FILTER_KEY,"prefilter,mockfilter"));
}