@Test public void generateJsonRequest(){
  MBeanSelector selector=MBeanSelector.create(ImmutableMap.of("applicationRuntimes",getApplicationMap()));
  JsonParser parser=new JsonParser();
  assertThat(parser.parse(selector.getRequest()),equalTo(parser.parse(compressedJsonForm(EXPECTED_JSON_REQUEST))));
}
