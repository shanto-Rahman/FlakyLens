@Test public void testV2Search() throws Throwable {
  URI v2RegistryStateUri=UriUtils.buildUri(host,v2RegistryStateLink);
  sendRegistrySearchRequest(v2RegistryStateUri,"v2image",(  Operation op) -> {
    RegistrySearchResponse response=op.getBody(RegistrySearchResponse.class);
    assertNotNull("result is null",response);
    assertEquals("Unexpected number of results",2,response.results.size());
    Result result=response.results.get(0);
    assertEquals("results[0].name","test/v2image",result.name);
  }
);
}
