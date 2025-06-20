/** 
 * Method: getWorkLoads(String storageId)
 */
@Test public void testGetWorkLoads() throws Exception {
  String storageId="b94bff9d-0dfb-11eb-bd3d-0050568491c9";
  String workloadsUrl=baseUrl + "/rest/storagemgmt/v1/storages/{storage_id}/workloads".replace("{storage_id}",storageId);
  HttpHeaders headers=getHeaders("111");
  HttpEntity<String> entity=new HttpEntity<>(null,headers);
  String jsonData="{\"datas\":[{\"block_size\":\"1\",\"create_type\":\"2\",\"enable_compress\":false,\"enable_dedup\":true,\"id\":\"121312\",\"name\":\"53s\",\"type\":\"112\"}]}";
  ResponseEntity<String> responseEntity=new ResponseEntity<>(jsonData,null,HttpStatus.OK);
  when(restTemplate.exchange(workloadsUrl,HttpMethod.GET,entity,String.class)).thenReturn(responseEntity);
  dmeAccessService.getWorkLoads(storageId);
}
