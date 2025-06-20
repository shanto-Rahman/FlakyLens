/** 
 * Method: getDmeHostInHostGroup(String hostGroupId)
 */
@Test public void testGetDmeHostInHostGroup() throws Exception {
  String hostGroupId="123cfad3-2ddf-4b47-9772-675c6ad770b8";
  String url=baseUrl + "/rest/hostmgmt/v1/hostgroups/{hostgroup_id}/hosts/list";
  url=url.replace("{hostgroup_id}",hostGroupId);
  Map<String,Object> requestbody=new HashMap<>(16);
  HttpHeaders headers=getHeaders("111");
  HttpEntity<String> entity=new HttpEntity<>(gson.toJson(requestbody),headers);
  String jsonData="{\"hosts\": [{\"id\": \"1231\",\"name\": \"10.143.132.17\",\"ip\": \"1\"}]}";
  ResponseEntity<String> responseEntity=new ResponseEntity<>(jsonData,null,HttpStatus.OK);
  when(restTemplate.exchange(url,HttpMethod.POST,entity,String.class)).thenReturn(responseEntity);
  dmeAccessService.getDmeHostInHostGroup(hostGroupId);
}
