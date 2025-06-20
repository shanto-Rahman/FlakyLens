@Test public void expandVmfs() throws DmeException {
  String param="{\n" + "    \"vo_add_capacity\": \"2\", \n" + "    \"capacityUnit\": \"GB\", \n"+ "    \"volume_id\": \"d6a20f27-fe4c-4a40-ac28-529aad1a7550\", \n"+ "    \"ds_name\": \"Dvmfs999\", \n"+ "    \"obj_id\": \"urn:vmomi:Datastore:datastore-1233:674908e5-ab21-4079-9cb1-596358ee5dd1\"\n"+ "}";
  Map<String,String> map=gson.fromJson(param,Map.class);
  JsonObject jsonObject=new JsonObject();
  jsonObject.addProperty("task_id","123");
  ResponseEntity<String> responseEntity=new ResponseEntity<>(gson.toJson(jsonObject),null,HttpStatus.ACCEPTED);
  String param2="{\"volumes\":[{\"volume_id\":\"d6a20f27-fe4c-4a40-ac28-529aad1a7550\",\"added_capacity\":2}]}";
  when(dmeAccessService.access("/rest/blockservice/v1/volumes/expand",HttpMethod.POST,param2)).thenReturn(responseEntity);
  List<String> list=new ArrayList<>();
  list.add("123");
  when(taskService.checkTaskStatus(list)).thenReturn(true);
  when(vcsdkUtils.expandVmfsDatastore("Dvmfs999",2,"urn:vmomi:Datastore:datastore-1233:674908e5-ab21-4079-9cb1-596358ee5dd1")).thenReturn("success");
  vmfsOperationService.expandVmfs(map);
}
