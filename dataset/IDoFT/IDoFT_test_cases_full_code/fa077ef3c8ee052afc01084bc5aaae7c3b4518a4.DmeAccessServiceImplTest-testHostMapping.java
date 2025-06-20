/** 
 * Method: hostMapping(String hostId, List<String> volumeIds)
 */
@Test public void testHostMapping() throws Exception {
  String hostId="9cbd24b5-fb5b-4ad9-9393-cf05b9b97339";
  List<String> volumeIds=new ArrayList<>();
  volumeIds.add("589e368c-6f08-45c8-a75c-b4dc28a6dcca");
  String url=baseUrl + "/rest/blockservice/v1/volumes/host-mapping";
  JsonObject body=new JsonObject();
  body.addProperty("host_id",hostId);
  JsonArray volumeIdArray=gson.fromJson(gson.toJson(volumeIds),JsonArray.class);
  body.add("volume_ids",volumeIdArray);
  HttpHeaders headers=getHeaders("111");
  HttpEntity<String> entity=new HttpEntity<>(body.toString(),headers);
  String jsonData="{\"task_id\":\"1123\"}";
  ResponseEntity<String> responseEntity=new ResponseEntity<>(jsonData,null,HttpStatus.OK);
  when(restTemplate.exchange(url,HttpMethod.POST,entity,String.class)).thenReturn(responseEntity);
  JsonObject taskDetail=new JsonObject();
  taskDetail.addProperty("status",3);
  when(taskService.queryTaskByIdUntilFinish("1123")).thenReturn(taskDetail);
  dmeAccessService.hostMapping(hostId,volumeIds);
}
