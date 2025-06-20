public void test_for_issue() throws Exception {
  DataSimpleVO a=new DataSimpleVO("a",1);
  DataSimpleVO b=new DataSimpleVO("b",2);
  b.value=a;
  Map<String,Object> map=new HashMap<String,Object>();
  map.put(a.name,a);
  b.value1=map;
  String jsonStr=JSON.toJSONString(b);
  System.out.println(jsonStr);
  DataSimpleVO obj=JSON.parseObject(jsonStr,DataSimpleVO.class);
  assertEquals(jsonStr,JSON.toJSONString(obj));
}
