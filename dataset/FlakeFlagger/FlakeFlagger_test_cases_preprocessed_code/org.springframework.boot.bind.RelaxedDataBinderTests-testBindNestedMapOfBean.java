@Test public void testBindNestedMapOfBean() throws Exception {
assertEquals(2,target.getNested().size());
assertEquals("bucket",target.getNested().get("bar").getFoo());
}