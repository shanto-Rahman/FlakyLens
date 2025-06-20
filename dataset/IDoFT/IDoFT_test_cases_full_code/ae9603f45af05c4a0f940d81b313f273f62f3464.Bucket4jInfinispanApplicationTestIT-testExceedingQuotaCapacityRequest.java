@Test public void testExceedingQuotaCapacityRequest(){
  ResponseEntity<String> response=this.restTemplate.getForEntity("/serviceE",String.class);
  HttpHeaders headers=response.getHeaders();
  String key="rate-limit-application_serviceE_127.0.0.1";
  assertHeaders(headers,key,false,true);
  assertEquals(OK,response.getStatusCode());
  response=this.restTemplate.getForEntity("/serviceE",String.class);
  headers=response.getHeaders();
  assertHeaders(headers,key,false,true);
  assertEquals(TOO_MANY_REQUESTS,response.getStatusCode());
}
