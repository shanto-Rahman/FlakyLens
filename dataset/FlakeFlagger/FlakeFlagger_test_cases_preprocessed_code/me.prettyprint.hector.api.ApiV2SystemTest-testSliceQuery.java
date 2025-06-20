@Test public void testSliceQuery(){
assertNotNull(r);
assertNotNull(slice);
assertEquals(3,slice.getColumns().size());
assertEquals("value01",slice.getColumnByName("testSliceQuery1").getValue());
assertEquals("value02",slice.getColumnByName("testSliceQuery2").getValue());
assertEquals("value03",slice.getColumnByName("testSliceQuery3").getValue());
assertNotNull(columns);
assertEquals(3,columns.size());
assertNotNull(r);
assertNotNull(slice);
assertEquals(2,slice.getColumns().size());
if (!column.getName().equals("testSliceQuery1") && !column.getName().equals("testSliceQuery2")) {
fail("A columns with unexpected column name returned: " + column.getName());
}
}