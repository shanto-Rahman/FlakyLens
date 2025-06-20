@Test public void canFlatten() throws Exception {
Assert.assertEquals("{\"$type\":\"foo\",\"properties\":{\"bar\":\"hello.world\",\"props\":{\"baz\":[\"hello\",\"hello.world\"],\"q\":{\"qux\":{\"hello\":\"world\",\"a.b\":\"c.d\",\"bar.b\":\"uuzz\",\"bar.a\":\"ttyy\"}}}}}",serialized);
Assert.assertEquals("hello.world",deserialized.bar);
Assert.assertArrayEquals(new String[]{"hello","hello.world"},deserialized.baz.toArray());
Assert.assertNotNull(deserialized.qux);
Assert.assertEquals("world",deserialized.qux.get("hello"));
Assert.assertEquals("c.d",deserialized.qux.get("a.b"));
Assert.assertEquals("ttyy",deserialized.qux.get("bar.a"));
Assert.assertEquals("uuzz",deserialized.qux.get("bar.b"));
}