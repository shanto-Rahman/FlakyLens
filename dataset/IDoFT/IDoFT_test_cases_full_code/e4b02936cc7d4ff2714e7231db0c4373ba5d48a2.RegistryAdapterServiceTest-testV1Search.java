@Test public void testV1Search() throws Throwable {
  URI defaultRegistryStateUri=UriUtils.buildUri(host,defaultRegistryStateLink);
  sendRegistrySearchRequest(defaultRegistryStateUri,"ubuntu",(  Operation op) -> {
    RegistrySearchResponse response=op.getBody(RegistrySearchResponse.class);
    assertNotNull("result is null",response);
    assertEquals("Unexpected number of results",10,response.numResults);
    assertEquals("Unexpected number of results",10,response.results.size());
    Result result=response.results.get(0);
    assertEquals("results[0].name","library/ubuntu",result.name);
    assertEquals("results[0].is_official",true,result.official);
  }
);
}
