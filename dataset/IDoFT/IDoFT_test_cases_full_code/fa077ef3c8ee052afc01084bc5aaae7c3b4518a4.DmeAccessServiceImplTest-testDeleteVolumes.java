/** 
 * Method: deleteVolumes(List<String> ids)
 */
@Test public void testDeleteVolumes() throws Exception {
  List<String> ids=new ArrayList<>();
  ids.add("59582fc9-d05c-4e28-8c50-da32d2a49e1b");
  String url=baseUrl + "/rest/blockservice/v1/volumes/delete";
  JsonObject body=new JsonObject();
  JsonArray array=new JsonParser().parse(gson.toJson(ids)).getAsJsonArray();
  body.add("volume_ids",array);
  HttpHeaders headers=getHeaders("111");
  HttpEntity<String> entity=new HttpEntity<>(gson.toJson(body),headers);
  String jsonData="{\"task_id\":\"1123\"}";
  ResponseEntity<String> responseEntity=new ResponseEntity<>(jsonData,null,HttpStatus.OK);
  when(restTemplate.exchange(url,HttpMethod.POST,entity,String.class)).thenReturn(responseEntity);
  JsonObject taskDetail=new JsonObject();
  taskDetail.addProperty("status",3);
  when(taskService.queryTaskByIdUntilFinish("1123")).thenReturn(taskDetail);
  dmeAccessService.deleteVolumes(ids);
}
