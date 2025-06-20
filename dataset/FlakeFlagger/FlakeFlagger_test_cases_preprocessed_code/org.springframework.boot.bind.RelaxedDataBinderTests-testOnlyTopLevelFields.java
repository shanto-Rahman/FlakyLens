@Test public void testOnlyTopLevelFields() throws Exception {
assertEquals(123,target.getValue());
assertEquals("bar",target.getFoo());
assertEquals(0,result.getErrorCount());
}