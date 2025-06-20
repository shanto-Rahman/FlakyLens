@Test public void testAccessByJson401() throws Exception {
  String url=baseUrl + "/rest/blockservice/v1/volumes?limit=1";
  HttpHeaders headers=getHeaders("111");
  HttpEntity<String> entity=new HttpEntity<>(null,headers);
  String jsonData="{\"accessSession\":\"111\",\"roaRand\":\"66a102ebfe8fa8bce046a5f4778f79b5e00faf58b7422e70\",\"expires\":1800,\"additionalInfo\":null}";
  ResponseEntity<String> responseEntity=new ResponseEntity<>(jsonData,null,HttpStatus.UNAUTHORIZED);
  String jsonBody=null;
  when(restTemplate.exchange(url,HttpMethod.GET,entity,String.class,jsonBody)).thenReturn(responseEntity);
  dmeAccessService.accessByJson(url,HttpMethod.GET,null);
}
