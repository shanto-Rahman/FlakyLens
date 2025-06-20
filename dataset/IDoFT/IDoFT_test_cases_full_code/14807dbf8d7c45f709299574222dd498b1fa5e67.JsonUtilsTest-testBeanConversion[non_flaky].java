@Test void testBeanConversion(){
  SimplePojo pojo=new SimplePojo();
  String s=JsonUtils.toJson(pojo);
  Match.that(s).isEqualTo("{\"bar\":0,\"foo\":null}");
  Map<String,Object> map=Json.of(pojo).asMap();
  Match.that(map).isEqualTo("{ foo: null, bar: 0 }");
}
