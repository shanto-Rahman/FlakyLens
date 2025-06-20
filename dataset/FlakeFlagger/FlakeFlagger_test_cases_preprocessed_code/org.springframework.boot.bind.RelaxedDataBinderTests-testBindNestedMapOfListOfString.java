@Test public void testBindNestedMapOfListOfString() throws Exception {
assertEquals(2,target.getNested().size());
assertEquals(3,target.getNested().get("bar").size());
assertEquals("123",target.getNested().get("bar").get(1));
assertEquals("[bar]",target.getNested().get("foo").toString());
}