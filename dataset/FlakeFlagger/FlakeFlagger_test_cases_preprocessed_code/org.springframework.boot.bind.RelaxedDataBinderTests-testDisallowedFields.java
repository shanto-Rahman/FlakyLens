@Test public void testDisallowedFields() throws Exception {
assertEquals(123,target.getValue());
assertNull(target.getFoo());
assertEquals(0,result.getErrorCount());
}