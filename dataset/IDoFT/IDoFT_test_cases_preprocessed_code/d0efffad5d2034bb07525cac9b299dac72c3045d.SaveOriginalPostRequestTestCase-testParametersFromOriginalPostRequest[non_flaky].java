@Test public void testParametersFromOriginalPostRequest() throws IOException {
assertEquals(StatusCodes.OK,result.getStatusLine().getStatusCode());
assertTrue(response.contains("param1=param1Value"));
assertTrue(response.contains("param2=param2Value"));
assertEquals(StatusCodes.OK,result.getStatusLine().getStatusCode());
Assert.assertTrue(HttpClientUtils.readResponse(result).startsWith("j_security_check"));
assertEquals(StatusCodes.OK,result.getStatusLine().getStatusCode());
assertTrue(response.contains("securedParam1=securedParam1Value"));
assertTrue(response.contains("securedParam2=securedParam2Value"));
}