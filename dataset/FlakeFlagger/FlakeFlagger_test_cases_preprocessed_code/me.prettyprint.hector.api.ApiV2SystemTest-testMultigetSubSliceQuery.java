@Test public void testMultigetSubSliceQuery(){
assertNotNull(r);
assertNotNull(rows);
assertEquals(2,rows.getCount());
assertNotNull(row);
assertEquals("testMultigetSubSliceQuery0",row.getKey());
assertNotNull(slice);
assertEquals("v000",slice.getColumnByName("c000").getValue());
assertEquals("v100",slice.getColumnByName("c110").getValue());
assertNotNull(columns);
assertEquals(2,columns.size());
assertNotNull(r);
assertEquals(1,rows.getCount());
assertNotNull(row2);
assertNotNull(slice);
assertEquals(2,slice.getColumns().size());
if (!column.getName().equals("c000") && !column.getName().equals("c110")) {
fail("A columns with unexpected column name returned: " + column.getName());
}
}