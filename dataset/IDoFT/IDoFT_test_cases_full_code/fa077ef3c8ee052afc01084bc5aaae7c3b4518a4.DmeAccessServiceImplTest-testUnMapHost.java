/** 
 * Method: unMapHost(String hostId, List<String> ids)
 */
@Test public void testUnMapHost() throws Exception {
  String hostId="9cbd24b5-fb5b-4ad9-9393-cf05b9b97339";
  List<String> ids=new ArrayList<>();
  ids.add("59582fc9-d05c-4e28-8c50-da32d2a49e1b");
  String url=baseUrl + "/rest/blockservice/v1/volumes/host-unmapping";
  JsonObject body=new JsonObject();
  JsonArray array=new JsonParser().parse(gson.toJson(ids)).getAsJsonArray();
  body.add("volume_ids",array);
  body.addProperty("host_id",hostId);
  HttpHeaders headers=getHeaders("111");
  HttpEntity<String> entity=new HttpEntity<>(body.toString(),headers);
  String jsonData="{\"task_id\":\"1123\"}";
  ResponseEntity<String> responseEntity=new ResponseEntity<>(jsonData,null,HttpStatus.OK);
  when(restTemplate.exchange(url,HttpMethod.POST,entity,String.class)).thenReturn(responseEntity);
  JsonObject taskDetail=new JsonObject();
  taskDetail.addProperty("status",3);
  when(taskService.queryTaskByIdUntilFinish("1123")).thenReturn(taskDetail);
  dmeAccessService.unMapHost(hostId,ids);
}
