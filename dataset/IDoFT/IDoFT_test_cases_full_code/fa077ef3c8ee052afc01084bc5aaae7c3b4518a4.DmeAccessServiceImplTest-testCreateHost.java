/** 
 * Method: createHost(Map<String, Object> params)
 */
@Test public void testCreateHost() throws Exception {
  String hostId="1456";
  String host="10.143.132.17";
  Map<String,Object> hbamap=new HashMap<>(16);
  hbamap.put("type","131");
  hbamap.put("name","tes");
  when(vcsdkUtils.getHbaByHostObjectId(hostId)).thenReturn(hbamap);
  Map requestbody=new HashMap<>(16);
  requestbody.put("access_mode","NONE");
  requestbody.put("type","VMWAREESX");
  requestbody.put("ip",host);
  requestbody.put("host_name",host);
  List<Map<String,Object>> initiators=new ArrayList<>();
  Map<String,Object> initiator=new HashMap<>(16);
  initiator.put("protocol",hbamap.get("type"));
  initiator.put("port_name",hbamap.get("name"));
  initiators.add(initiator);
  requestbody.put("initiator",initiators);
  Map<String,Object> params=new HashMap<>(16);
  params.put("host",host);
  params.put("hostId",hostId);
  String url=baseUrl + "/rest/hostmgmt/v1/hosts";
  HttpHeaders headers=getHeaders("111");
  HttpEntity<String> entity=new HttpEntity<>(gson.toJson(requestbody),headers);
  String jsonData="{\"id\":\"1231\",\"ip\":\"10.143.132.17\",\"access_mode\":\"1\",\"type\":\"111\",\"port\":26335}";
  ResponseEntity<String> responseEntity=new ResponseEntity<>(jsonData,null,HttpStatus.OK);
  when(restTemplate.exchange(url,HttpMethod.POST,entity,String.class)).thenReturn(responseEntity);
  dmeAccessService.createHost(params);
}
