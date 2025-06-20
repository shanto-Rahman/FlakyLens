/** 
 * Method: createHostGroup(Map<String, Object> params)
 */
@Test public void testCreateHostGroup() throws Exception {
  String hostId="1456";
  String host="10.143.132.17";
  Map requestbody=new HashMap<>(16);
  requestbody.put("name",host);
  requestbody.put("host_ids",hostId);
  Map<String,Object> params=new HashMap<>(16);
  params.put("cluster",host);
  params.put("hostids",hostId);
  String url=baseUrl + "/rest/hostmgmt/v1/hostgroups";
  HttpHeaders headers=getHeaders("111");
  HttpEntity<String> entity=new HttpEntity<>(gson.toJson(requestbody),headers);
  String jsonData="{\"id\":\"1231\",\"name\":\"10.143.132.17\"}";
  ResponseEntity<String> responseEntity=new ResponseEntity<>(jsonData,null,HttpStatus.OK);
  when(restTemplate.exchange(url,HttpMethod.POST,entity,String.class)).thenReturn(responseEntity);
  dmeAccessService.createHostGroup(params);
}
