@Test public void generateJsonRequest(){
  MBeanSelector selector=MBeanSelector.create(ImmutableMap.of("applicationRuntimes",getApplicationMap()));
  assertThat(selector.getRequest(),equalTo(compressedJsonForm(EXPECTED_JSON_REQUEST)));
}
