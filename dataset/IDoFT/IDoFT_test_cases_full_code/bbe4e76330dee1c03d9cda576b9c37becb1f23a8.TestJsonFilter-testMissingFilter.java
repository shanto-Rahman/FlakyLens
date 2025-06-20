public void testMissingFilter() throws Exception {
  try {
    MAPPER.writeValueAsString(new Bean());
    fail("Should have failed without configured filter");
  }
 catch (  JsonMappingException e) {
    verifyException(e,"Can not resolve PropertyFilter with id 'RootFilter'");
  }
  SimpleFilterProvider fp=new SimpleFilterProvider().setFailOnUnknownId(false);
  ObjectMapper mapper=new ObjectMapper();
  mapper.setFilterProvider(fp);
  String json=mapper.writeValueAsString(new Bean());
  assertEquals("{\"a\":\"a\",\"b\":\"b\"}",json);
}
