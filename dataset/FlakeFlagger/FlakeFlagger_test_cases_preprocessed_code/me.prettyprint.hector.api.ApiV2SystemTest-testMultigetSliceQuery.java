@Test public void testMultigetSliceQuery(){
assertNotNull(r);
assertNotNull(rows);
assertEquals(2,rows.getCount());
assertNotNull(row);
assertEquals("testMultigetSliceQuery1",row.getKey());
assertNotNull(slice);
assertEquals("value11",slice.getColumnByName("testMultigetSliceQueryColumn1").getValue());
assertEquals("value12",slice.getColumnByName("testMultigetSliceQueryColumn2").getValue());
assertNull(slice.getColumnByName("testMultigetSliceQueryColumn3"));
assertNotNull(columns);
assertEquals(2,columns.size());
assertNotNull(r);
assertEquals(1,rows.getCount());
assertNotNull(row2);
assertNotNull(slice);
if (!column.getName().equals("testMultigetSliceQueryColumn1") && !column.getName().equals("testMultigetSliceQueryColumn2") && !column.getName().equals("testMultigetSliceQueryColumn3")) {
fail("A columns with unexpected column name returned: " + column.getName());
}
}