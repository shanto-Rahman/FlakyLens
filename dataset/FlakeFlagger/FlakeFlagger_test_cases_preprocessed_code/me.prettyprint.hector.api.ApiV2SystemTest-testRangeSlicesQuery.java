@Test public void testRangeSlicesQuery(){
assertNotNull(r);
assertNotNull(rows);
assertEquals(3,rows.getCount());
assertNotNull(row);
assertEquals("testRangeSlicesQuery1",row.getKey());
assertNotNull(slice);
assertEquals("value11",slice.getColumnByName("testRangeSlicesQueryColumn1").getValue());
assertEquals("value12",slice.getColumnByName("testRangeSlicesQueryColumn2").getValue());
assertNull(slice.getColumnByName("testRangeSlicesQueryColumn3"));
assertNotNull(columns);
assertEquals(2,columns.size());
assertNotNull(r);
assertEquals(3,rows.getCount());
assertNotNull(row2);
assertNotNull(slice);
assertEquals(2,slice.getColumns().size());
if (!column.getName().equals("testRangeSlicesQueryColumn1") && !column.getName().equals("testRangeSlicesQueryColumn2")) {
fail("A columns with unexpected column name returned: " + column.getName());
}
}