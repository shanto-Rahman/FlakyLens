public void test_for_issue(){
  VO vo=new VO();
  vo.id=123;
  vo.location=new Location(127,37);
  Object obj=JSON.toJSON(vo);
  String text=JSON.toJSONString(obj,SerializerFeature.MapSortField);
  assertEquals("{\"id\":123,\"latitude\":37,\"longitude\":127}",text);
}
