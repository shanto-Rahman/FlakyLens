@Test public void testBadAltusErrors() throws Exception {
  Response mockResponse=mockResponse(500,"requestId");
  when(mockResponse.readEntity(String.class)).thenReturn(null);
  TestClient client=new TestClient(mockResponse);
  try {
    client.invokeAPI("somePath","",new GenericType<TestAltusResponse>(){
    }
);
    fail();
  }
 catch (  AltusHTTPException e) {
    assertEquals(1,client.apiCalls);
    assertEquals(500,e.getHttpCode());
    assertEquals("500: null",e.getMessage());
  }
  when(mockResponse.readEntity(String.class)).thenReturn("NOT JSON!");
  client=new TestClient(mockResponse);
  try {
    client.invokeAPI("somePath","",new GenericType<TestAltusResponse>(){
    }
);
    fail();
  }
 catch (  AltusHTTPException e) {
    assertEquals(1,client.apiCalls);
    assertEquals(500,e.getHttpCode());
    assertEquals("500: NOT JSON!",e.getMessage());
  }
  Map<String,String> error=Maps.newHashMap();
  when(mockResponse.readEntity(String.class)).thenReturn(MAPPER.writeValueAsString(error));
  client=new TestClient(mockResponse);
  try {
    client.invokeAPI("somePath","",new GenericType<TestAltusResponse>(){
    }
);
    fail();
  }
 catch (  AltusHTTPException e) {
    assertEquals(1,client.apiCalls);
    assertEquals(500,e.getHttpCode());
    assertEquals("500: {}",e.getMessage());
  }
  error.put("code","CODE");
  when(mockResponse.readEntity(String.class)).thenReturn(MAPPER.writeValueAsString(error));
  client=new TestClient(mockResponse);
  try {
    client.invokeAPI("somePath","",new GenericType<TestAltusResponse>(){
    }
);
    fail();
  }
 catch (  AltusHTTPException e) {
    assertEquals(1,client.apiCalls);
    assertEquals(500,e.getHttpCode());
    assertEquals("500: " + MAPPER.writeValueAsString(error),e.getMessage());
  }
  error.clear();
  error.put("message","MESSAGE!");
  when(mockResponse.readEntity(String.class)).thenReturn(MAPPER.writeValueAsString(error));
  client=new TestClient(mockResponse);
  try {
    client.invokeAPI("somePath","",new GenericType<TestAltusResponse>(){
    }
);
    fail();
  }
 catch (  AltusHTTPException e) {
    assertEquals(1,client.apiCalls);
    assertEquals(500,e.getHttpCode());
    assertEquals("500: " + MAPPER.writeValueAsString(error),e.getMessage());
  }
  mockResponse=mockResponse(500,null);
  error.put("code","CODE");
  error.put("message","message!");
  when(mockResponse.readEntity(String.class)).thenReturn(MAPPER.writeValueAsString(error));
  client=new TestClient(mockResponse);
  try {
    client.invokeAPI("somePath","",new GenericType<TestAltusResponse>(){
    }
);
    fail();
  }
 catch (  AltusHTTPException e) {
    assertEquals(1,client.apiCalls);
    assertEquals(500,e.getHttpCode());
    assertEquals("500: " + MAPPER.writeValueAsString(error),e.getMessage());
  }
}
