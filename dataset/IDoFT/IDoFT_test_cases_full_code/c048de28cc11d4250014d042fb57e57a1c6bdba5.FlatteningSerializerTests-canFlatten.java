@Test public void canFlatten() throws Exception {
  Foo foo=new Foo();
  foo.bar="hello.world";
  foo.baz=new ArrayList<>();
  foo.baz.add("hello");
  foo.baz.add("hello.world");
  foo.qux=new HashMap<>();
  foo.qux.put("hello","world");
  foo.qux.put("a.b","c.d");
  foo.qux.put("bar.a","ttyy");
  foo.qux.put("bar.b","uuzz");
  JacksonAdapter adapter=new JacksonAdapter();
  String serialized=adapter.serialize(foo);
  Assert.assertEquals("{\"$type\":\"foo\",\"properties\":{\"bar\":\"hello.world\",\"props\":{\"baz\":[\"hello\",\"hello.world\"],\"q\":{\"qux\":{\"hello\":\"world\",\"a.b\":\"c.d\",\"bar.b\":\"uuzz\",\"bar.a\":\"ttyy\"}}}}}",serialized);
  Foo deserialized=adapter.deserialize(serialized,Foo.class);
  Assert.assertEquals("hello.world",deserialized.bar);
  Assert.assertArrayEquals(new String[]{"hello","hello.world"},deserialized.baz.toArray());
  Assert.assertNotNull(deserialized.qux);
  Assert.assertEquals("world",deserialized.qux.get("hello"));
  Assert.assertEquals("c.d",deserialized.qux.get("a.b"));
  Assert.assertEquals("ttyy",deserialized.qux.get("bar.a"));
  Assert.assertEquals("uuzz",deserialized.qux.get("bar.b"));
}
