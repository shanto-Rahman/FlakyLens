@Test public void testQueryRaw() throws Exception {
assertEquals(1,dao.create(foo));
assertEquals(1,results.size());
if (columnNames[i].equalsIgnoreCase(Foo.ID_COLUMN_NAME)) {
assertEquals(Integer.toString(foo.id),results.get(0)[0]);
}
assertTrue(found);
}