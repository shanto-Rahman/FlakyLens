@Test public void testQueryRaw() throws Exception {
assertEquals(1,qb.countOf());
assertEquals(1,stringResults.size());
assertEquals(Integer.toString(foo.id),stringResults.get(0)[0]);
assertEquals(foo.stringField,stringResults.get(0)[3]);
}