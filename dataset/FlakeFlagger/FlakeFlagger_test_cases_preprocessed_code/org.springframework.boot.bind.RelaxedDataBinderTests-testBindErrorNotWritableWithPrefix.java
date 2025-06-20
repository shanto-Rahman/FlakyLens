@Test public void testBindErrorNotWritableWithPrefix() throws Exception {
assertEquals(0,result.getErrorCount());
assertEquals(123,target.getValue());
}