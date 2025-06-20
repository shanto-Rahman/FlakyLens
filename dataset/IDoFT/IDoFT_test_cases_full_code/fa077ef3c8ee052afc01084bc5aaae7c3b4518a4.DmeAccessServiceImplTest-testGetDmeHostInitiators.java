/** 
 * Method: getDmeHostInitiators(String hostId)
 */
@Test public void testGetDmeHostInitiators() throws Exception {
  String hostId="1111";
  Map<String,Object> requestbody=new HashMap<>(16);
  requestbody.put("ip",hostIp);
  String url=baseUrl + "/rest/hostmgmt/v1/hosts/{host_id}/initiators";
  url=url.replace("{host_id}",hostId);
  HttpHeaders headers=getHeaders("111");
  HttpEntity<String> entity=new HttpEntity<>(null,headers);
  String jsonData="{\"initiators\": [{\"id\": \"9cbd24b5-fb5b-4ad9-9393-cf05b9b97339\",\"port_name\": \"13213\",\"status\": \"11\",\"protocol\": \"ipv4\"}]}";
  ResponseEntity<String> responseEntity=new ResponseEntity<>(jsonData,null,HttpStatus.OK);
  when(restTemplate.exchange(url,HttpMethod.GET,entity,String.class)).thenReturn(responseEntity);
  dmeAccessService.getDmeHostInitiators(hostId);
}
