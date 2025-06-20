@Test public void whenNoValuesListedForSerlvets_generateJsonRequest(){
  MBeanSelector selector=MBeanSelector.create(ImmutableMap.of("applicationRuntimes",getNoServletValuesApplicationMap()));
  assertThat(selector.getRequest(),equalTo(compressedJsonForm(EXPECTED_ALL_SERVLET_VALUES_JSON_REQUEST)));
}
