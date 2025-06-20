@Test public void whenNoValuesListedForSerlvets_generateJsonRequest(){
  MBeanSelector selector=MBeanSelector.create(ImmutableMap.of("applicationRuntimes",getNoServletValuesApplicationMap()));
  JsonParser parser=new JsonParser();
  assertThat(parser.parse(selector.getRequest()),equalTo(parser.parse(compressedJsonForm(EXPECTED_ALL_SERVLET_VALUES_JSON_REQUEST))));
}
