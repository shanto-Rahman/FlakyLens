@Test public void testNullValues(){
assertEquals(trimWhitespace(json),"{}");
assertEquals(trimWhitespace(json),"{}");
assertEquals(trimWhitespace(json),"{\"foo\":null}");
assertEquals(trimWhitespace(json),"{}");
assertEquals(trimWhitespace(json),"{\"prop1\":\"value1\",\"foo1\":{\"bar\":38},\"foo2\":null,\"foo3\":{}}");
}