@Test void testBeanConversion(){
  SimplePojo pojo=new SimplePojo();
  String s=JsonUtils.toJson(pojo);
  assertEquals("{\"bar\":0,\"foo\":null}",s);
  Map<String,Object> map=Json.of(pojo).asMap();
  Match.that(map).isEqualTo("{ foo: null, bar: 0 }");
}
