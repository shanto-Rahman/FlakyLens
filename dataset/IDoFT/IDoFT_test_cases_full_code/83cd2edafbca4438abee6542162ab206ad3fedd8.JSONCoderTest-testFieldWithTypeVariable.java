@Test public void testFieldWithTypeVariable(){
  ClsWithTypeVar bean=new ClsWithTypeVar();
  bean.listOfMap.add(new MapBuilder("str1",1).getMap());
  bean.refOfMap.set(new MapBuilder("str1",1).getMap());
  String json=JSONCoder.global.encode(bean);
  assertMatchesSnapshot(json);
  ClsWithTypeVar bean1=JSONCoder.global.decode(json,ClsWithTypeVar.class);
  String json1=JSONCoder.global.encode(bean1);
  assertEquals(json,json1);
}
