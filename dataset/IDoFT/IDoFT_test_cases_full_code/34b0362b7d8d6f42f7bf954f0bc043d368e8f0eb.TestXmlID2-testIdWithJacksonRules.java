public void testIdWithJacksonRules() throws Exception {
  String expected="[{\"id\":11,\"username\":\"11\",\"email\":\"11@test.com\"," + "\"department\":{\"id\":9,\"name\":\"department9\",\"employees\":[" + "11,{\"id\":22,\"username\":\"22\",\"email\":\"22@test.com\","+ "\"department\":9}]}},22,{\"id\":33,\"username\":\"33\",\"email\":\"33@test.com\",\"department\":null}]";
  ObjectMapper mapper=JsonMapper.builder().annotationIntrospector(new JaxbAnnotationIntrospector(true)).build();
  List<User> users=getUserList();
  String json=mapper.writeValueAsString(users);
  assertEquals(expected,json);
  List<User> result=mapper.readValue(json,new TypeReference<List<User>>(){
  }
);
  assertEquals(3,result.size());
  assertEquals(Long.valueOf(11),result.get(0).id);
  assertEquals(Long.valueOf(22),result.get(1).id);
  assertEquals(Long.valueOf(33),result.get(2).id);
}
