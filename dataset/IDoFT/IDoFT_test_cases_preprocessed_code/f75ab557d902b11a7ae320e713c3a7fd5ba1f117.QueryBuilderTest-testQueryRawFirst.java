@Test public void testQueryRawFirst() throws Exception {
assertEquals(1,qb.countOf());
assertEquals(4,result.length);
assertEquals(Integer.toString(foo.id),result[0]);
assertEquals(foo.stringField,result[3]);
}