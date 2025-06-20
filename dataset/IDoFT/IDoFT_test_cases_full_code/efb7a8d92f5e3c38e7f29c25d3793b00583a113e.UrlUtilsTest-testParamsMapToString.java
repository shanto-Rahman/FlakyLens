@Test public void testParamsMapToString(){
  Map<String,String[]> params=new HashMap<>();
  params.put("a",new String[]{"1","2","3"});
  params.put("b",new String[]{"8","7","6"});
  String result=UrlUtils.paramsMapToString(params);
  Assert.assertEquals(result,"&a=1,2,3&b=8,7,6");
}
