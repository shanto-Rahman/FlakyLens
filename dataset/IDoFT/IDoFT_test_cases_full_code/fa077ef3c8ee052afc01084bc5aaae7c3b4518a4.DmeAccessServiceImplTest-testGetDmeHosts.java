/** 
 * Method: getDmeHosts(String hostIp)
 */
@Test public void testGetDmeHosts() throws Exception {
  String hostIp="10.143.133.17";
  Map<String,Object> requestbody=new HashMap<>(16);
  requestbody.put("ip",hostIp);
  String getHostsUrl=baseUrl + "/rest/hostmgmt/v1/hosts/summary";
  HttpHeaders headers=getHeaders("111");
  HttpEntity<String> entity=new HttpEntity<>(gson.toJson(requestbody),headers);
  String jsonData="{\"total\":1,\"hosts\":[{\"id\":\"9cbd24b5-fb5b-4ad9-9393-cf05b9b97339\",\"project_id\":null,\"name\":\"10.143.133.17\",\"ip\":\"10.143.133.17\",\"display_status\":\"NORMAL\",\"managed_status\":\"NORMAL\",\"takeover_failed_reason\":{\"error_code\":null,\"error_msg\":null,\"error_args\":[]},\"os_status\":\"ONLINE\",\"overall_status\":\"\",\"os_type\":\"LINUX\",\"initiator_count\":1,\"access_mode\":\"NONE\",\"hostGroups\":[{\"id\":\"1231\",\"name\":\"22\"}],\"azs\":[]}]}";
  ResponseEntity<String> responseEntity=new ResponseEntity<>(jsonData,null,HttpStatus.OK);
  when(restTemplate.exchange(getHostsUrl,HttpMethod.POST,entity,String.class)).thenReturn(responseEntity);
  dmeAccessService.getDmeHosts(hostIp);
}
