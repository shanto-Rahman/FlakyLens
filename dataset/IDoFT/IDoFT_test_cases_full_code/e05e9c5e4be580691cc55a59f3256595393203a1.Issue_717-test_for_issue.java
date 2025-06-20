public void test_for_issue() throws Exception {
  Group group=new Group();
  group.setId(0L);
  group.setNAME("admin");
  group.setAUTHORITY("administrors");
  String json=JSON.toJSONString(group);
  Assert.assertEquals("{\"ID\":0,\"nAME\":\"admin\"}",json);
}
