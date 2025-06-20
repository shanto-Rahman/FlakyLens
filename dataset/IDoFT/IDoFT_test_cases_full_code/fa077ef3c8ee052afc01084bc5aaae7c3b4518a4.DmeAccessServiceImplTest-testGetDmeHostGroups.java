/** 
 * Method: getDmeHostGroups(String hostGroupName)
 */
@Test public void testGetDmeHostGroups() throws Exception {
  String hostGroupName="domain-c1087";
  Map<String,Object> requestbody=new HashMap<>(16);
  requestbody.put("name",hostGroupName);
  String url=baseUrl + "/rest/hostmgmt/v1/hostgroups/summary";
  HttpHeaders headers=getHeaders("111");
  HttpEntity<String> entity=new HttpEntity<>(gson.toJson(requestbody),headers);
  String jsonData="{\"hostgroups\": [{\"id\": \"9cbd24b5-fb5b-4ad9-9393-cf05b9b97339\",\"name\": \"13213\",\"ip\": 2,\"source_type\": \"ipv4\",\"managed_status\": \"1\",\"project_id\": \"131\"}]}";
  ResponseEntity<String> responseEntity=new ResponseEntity<>(jsonData,null,HttpStatus.OK);
  when(restTemplate.exchange(url,HttpMethod.POST,entity,String.class)).thenReturn(responseEntity);
  dmeAccessService.getDmeHostGroups(hostGroupName);
}
