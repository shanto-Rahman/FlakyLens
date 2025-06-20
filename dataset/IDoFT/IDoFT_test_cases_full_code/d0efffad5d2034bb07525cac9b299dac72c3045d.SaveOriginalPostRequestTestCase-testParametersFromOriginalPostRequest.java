@Test public void testParametersFromOriginalPostRequest() throws IOException {
  TestHttpClient client=createHttpClient();
  HttpResponse result=executePostRequest(client,"/servletContext/dumpRequest",new BasicNameValuePair("param1","param1Value"),new BasicNameValuePair("param2","param2Value"));
  assertEquals(StatusCodes.OK,result.getStatusLine().getStatusCode());
  String response=HttpClientUtils.readResponse(result);
  assertTrue(response.contains("param1=param1Value/param2=param2Value"));
  result=executePostRequest(client,"/servletContext/secured/dumpRequest",new BasicNameValuePair("securedParam1","securedParam1Value"),new BasicNameValuePair("securedParam2","securedParam2Value"));
  assertEquals(StatusCodes.OK,result.getStatusLine().getStatusCode());
  Assert.assertTrue(HttpClientUtils.readResponse(result).startsWith("j_security_check"));
  result=executePostRequest(client,"/servletContext/j_security_check",new BasicNameValuePair("j_username","user1"),new BasicNameValuePair("j_password","password1"));
  assertEquals(StatusCodes.OK,result.getStatusLine().getStatusCode());
  response=HttpClientUtils.readResponse(result);
  assertTrue(response.contains("securedParam1=securedParam1Value"));
  assertTrue(response.contains("securedParam2=securedParam2Value"));
}
