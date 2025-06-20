@Test(expected=ResponseProcessingException.class) public void testExceptionInClientResponseFilterWhenNotFound(){
  try (Response response=ClientBuilder.newClient().register(FaultyClientResponseFilter.class).target(ADDRESS).request().put(null)){
    fail("Should not be invoked");
  }
 }
