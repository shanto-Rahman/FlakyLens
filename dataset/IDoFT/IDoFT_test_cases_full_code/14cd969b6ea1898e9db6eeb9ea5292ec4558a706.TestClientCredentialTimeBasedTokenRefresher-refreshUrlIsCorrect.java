@Test public void refreshUrlIsCorrect() throws IOException {
  final int PORT=ServerSocketUtil.getPort(0,20);
  final String REFRESH_ADDRESS="http://localhost:" + PORT + "/refresh";
  long tokenExpires=0;
  Configuration conf=buildConf("myreallycoolcredential",Long.toString(tokenExpires),CLIENT_ID_FOR_TESTING,REFRESH_ADDRESS);
  Timer mockTimer=mock(Timer.class);
  when(mockTimer.now()).thenReturn(tokenExpires + 1000l);
  AccessTokenProvider credProvider=new ConfCredentialBasedAccessTokenProvider(mockTimer);
  credProvider.setConf(conf);
  ClientAndServer mockServer=startClientAndServer(PORT);
  HttpRequest expectedRequest=request().withMethod("POST").withPath("/refresh").withBody(ParameterBody.params(Parameter.param(CLIENT_SECRET,"myreallycoolcredential"),Parameter.param(GRANT_TYPE,CLIENT_CREDENTIALS),Parameter.param(CLIENT_ID,CLIENT_ID_FOR_TESTING)));
  MockServerClient mockServerClient=new MockServerClient("localhost",PORT);
  Map<String,Object> map=new TreeMap<>();
  map.put(EXPIRES_IN,"0987654321");
  map.put(TOKEN_TYPE,"bearer");
  map.put(ACCESS_TOKEN,"new access token");
  ObjectMapper mapper=new ObjectMapper();
  HttpResponse resp=response().withStatusCode(HttpStatus.SC_OK).withHeaders(CONTENT_TYPE_APPLICATION_JSON).withBody(mapper.writeValueAsString(map));
  mockServerClient.when(expectedRequest,exactly(1)).respond(resp);
  assertEquals("new access token",credProvider.getAccessToken());
  mockServerClient.verify(expectedRequest);
  mockServerClient.clear(expectedRequest);
  mockServer.stop();
}
