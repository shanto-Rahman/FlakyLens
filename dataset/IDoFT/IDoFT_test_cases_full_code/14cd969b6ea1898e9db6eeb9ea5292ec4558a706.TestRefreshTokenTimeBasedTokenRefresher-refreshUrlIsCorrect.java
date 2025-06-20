@Test public void refreshUrlIsCorrect() throws IOException {
  final int PORT=7552;
  final String REFRESH_ADDRESS="http://localhost:" + PORT + "/refresh";
  long tokenExpires=0;
  Configuration conf=buildConf("refresh token key",Long.toString(tokenExpires),"joebob",REFRESH_ADDRESS);
  Timer mockTimer=mock(Timer.class);
  when(mockTimer.now()).thenReturn(tokenExpires + 1000l);
  AccessTokenProvider tokenProvider=new ConfRefreshTokenBasedAccessTokenProvider(mockTimer);
  tokenProvider.setConf(conf);
  ClientAndServer mockServer=startClientAndServer(PORT);
  HttpRequest expectedRequest=request().withMethod("POST").withPath("/refresh").withBody(ParameterBody.params(Parameter.param(CLIENT_ID,"joebob"),Parameter.param(GRANT_TYPE,REFRESH_TOKEN),Parameter.param(REFRESH_TOKEN,"refresh token key")));
  MockServerClient mockServerClient=new MockServerClient("localhost",PORT);
  Map<String,Object> map=new TreeMap<>();
  map.put(EXPIRES_IN,"0987654321");
  map.put(TOKEN_TYPE,BEARER);
  map.put(ACCESS_TOKEN,"new access token");
  ObjectMapper mapper=new ObjectMapper();
  HttpResponse resp=response().withStatusCode(HttpStatus.SC_OK).withHeaders(CONTENT_TYPE_APPLICATION_JSON).withBody(mapper.writeValueAsString(map));
  mockServerClient.when(expectedRequest,exactly(1)).respond(resp);
  assertEquals("new access token",tokenProvider.getAccessToken());
  mockServerClient.verify(expectedRequest);
  mockServerClient.clear(expectedRequest);
  mockServer.stop();
}
