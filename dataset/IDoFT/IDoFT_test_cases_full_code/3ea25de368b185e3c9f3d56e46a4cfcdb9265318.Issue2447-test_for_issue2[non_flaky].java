public void test_for_issue2(){
  VO2 vo=new VO2();
  vo.id=123;
  vo.properties.put("latitude",37);
  vo.properties.put("longitude",127);
  Object obj=JSON.toJSON(vo);
  String text=JSON.toJSONString(obj,SerializerFeature.MapSortField);
  assertEquals("{\"id\":123,\"latitude\":37,\"longitude\":127}",text);
}
