@Test public void testAllowedFields() throws Exception {
assertEquals(0,target.getValue());
assertEquals("bar",target.getFoo());
assertEquals(0,result.getErrorCount());
}