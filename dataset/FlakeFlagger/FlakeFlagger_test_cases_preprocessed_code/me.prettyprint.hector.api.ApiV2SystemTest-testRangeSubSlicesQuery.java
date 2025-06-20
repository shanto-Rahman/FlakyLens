@Test public void testRangeSubSlicesQuery(){
assertNotNull(r);
assertNotNull(rows);
assertEquals(2,rows.getCount());
assertNotNull(row);
assertEquals("testRangeSubSlicesQuery2",row.getKey());
assertNotNull(slice);
assertEquals("v021",slice.getColumnByName("c021").getValue());
assertEquals("v121",slice.getColumnByName("c111").getValue());
assertNull(slice.getColumnByName("c033"));
}