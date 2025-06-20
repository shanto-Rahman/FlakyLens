@Test public void testNullValues(){
  ModelAPFoo model;
  Foo foo;
  String json;
  model=new ModelAPFoo();
  json=serialize(model);
  assertEquals(trimWhitespace(json),"{}");
  model=new ModelAPFoo();
  model.setProp1(null);
  json=serialize(model);
  assertEquals(trimWhitespace(json),"{}");
  model=new ModelAPFoo();
  model.put("foo",null);
  json=serialize(model);
  assertEquals(trimWhitespace(json),"{\"foo\":null}");
  model=new ModelAPFoo();
  model.put("prop1",null);
  json=serialize(model);
  assertEquals(trimWhitespace(json),"{}");
  model=new ModelAPFoo();
  model.setProp1("value1");
  foo=new Foo();
  foo.setBar(38);
  model.put("foo1",foo);
  model.put("foo2",null);
  model.put("foo3",new Foo());
  json=serialize(model);
  assertEquals(trimWhitespace(json),"{\"prop1\":\"value1\",\"foo1\":{\"bar\":38},\"foo2\":null,\"foo3\":{}}");
}
