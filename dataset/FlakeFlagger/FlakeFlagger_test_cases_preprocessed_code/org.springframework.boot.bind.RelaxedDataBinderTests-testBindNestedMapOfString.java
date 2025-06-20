@Test public void testBindNestedMapOfString() throws Exception {
assertEquals("bar",target.getNested().get("foo"));
assertEquals("123",target.getNested().get("value.foo"));
}