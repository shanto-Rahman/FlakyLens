public void testForIssue2(){
  String jsonString="{\"map\":{\"a\":[\"1\",\"2\",\"3\"],\"b\":[\"1\"]},\"name\":\"zhangsan\"}";
  VO vo=JSON.parseObject(jsonString,VO.class);
  assertEquals("VO:{name->zhangsan,map->{a=[1, 2, 3], b=[1]}}",vo.toString());
}
