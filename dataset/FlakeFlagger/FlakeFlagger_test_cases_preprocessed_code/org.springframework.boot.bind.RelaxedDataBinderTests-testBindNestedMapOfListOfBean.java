@Test public void testBindNestedMapOfListOfBean() throws Exception {
assertEquals(2,target.getNested().size());
assertEquals(3,target.getNested().get("bar").size());
assertEquals(123,target.getNested().get("bar").get(1).getValue());
assertEquals("bar",target.getNested().get("foo").get(0).getFoo());
}