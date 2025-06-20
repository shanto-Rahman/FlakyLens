public void testIdWithJaxbRules() throws Exception {
  ObjectMapper mapper=JsonMapper.builder().annotationIntrospector(new JaxbAnnotationIntrospector()).build();
  List<User> users=getUserList();
  final String json=mapper.writeValueAsString(users);
  String expected="[{\"id\":11,\"username\":\"11\",\"email\":\"11@test.com\",\"department\":9}" + ",{\"id\":22,\"username\":\"22\",\"email\":\"22@test.com\",\"department\":9}" + ",{\"id\":33,\"username\":\"33\",\"email\":\"33@test.com\",\"department\":null}]";
  assertEquals(expected,json);
}
