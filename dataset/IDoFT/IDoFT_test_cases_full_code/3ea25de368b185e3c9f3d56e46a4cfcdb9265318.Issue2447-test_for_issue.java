public void test_for_issue(){
  VO vo=new VO();
  vo.id=123;
  vo.location=new Location(127,37);
  Object obj=JSON.toJSON(vo);
  String json=JSON.toJSONString(vo);
  assertEquals("{\"latitude\":37,\"id\":123,\"longitude\":127}",obj.toString());
}
