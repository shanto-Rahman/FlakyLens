@Test public void testRangeSuperSlicesQuery(){
assertNotNull(r);
assertNotNull(rows);
assertEquals(2,rows.getCount());
assertNotNull(row);
assertEquals("testRangeSuperSlicesQuery2",row.getKey());
assertNotNull(slice);
assertEquals("v021",slice.getColumnByName("testRangeSuperSlicesQuery1").get(0).getValue());
assertEquals("v022",slice.getColumnByName("testRangeSuperSlicesQuery2").get(0).getValue());
assertNull(slice.getColumnByName("testRangeSuperSlicesQuery3"));
assertNotNull(r);
assertEquals(4,rows.getCount());
assertNotNull(row2);
assertNotNull(slice);
assertEquals(2,slice.getSuperColumns().size());
if (!column.getName().equals("testRangeSuperSlicesQuery1") && !column.getName().equals("testRangeSuperSlicesQuery2")) {
fail("A columns with unexpected column name returned: " + column.getName());
}
}