/** 
 * Method: getDmeHostGroup(String hostGroupId)
 */
@Test public void testGetDmeHostGroup() throws Exception {
  String hostGroupId="123cfad3-2ddf-4b47-9772-675c6ad770b8";
  String url=baseUrl + "/rest/hostmgmt/v1/hostgroups/{hostgroup_id}/summary";
  url=url.replace("{hostgroup_id}",hostGroupId);
  HttpHeaders headers=getHeaders("111");
  HttpEntity<String> entity=new HttpEntity<>(null,headers);
  String jsonData="{\"id\":\"1231\",\"name\":\"10.143.132.17\"}";
  ResponseEntity<String> responseEntity=new ResponseEntity<>(jsonData,null,HttpStatus.OK);
  when(restTemplate.exchange(url,HttpMethod.GET,entity,String.class)).thenReturn(responseEntity);
  dmeAccessService.getDmeHostGroup(hostGroupId);
}
