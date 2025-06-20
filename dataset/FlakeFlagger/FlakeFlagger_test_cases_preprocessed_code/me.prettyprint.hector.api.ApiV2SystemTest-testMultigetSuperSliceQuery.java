@Test public void testMultigetSuperSliceQuery(){
assertNotNull(r);
assertNotNull(rows);
assertEquals(2,rows.getCount());
assertNotNull(row);
assertEquals("testSuperMultigetSliceQueryKey0",row.getKey());
assertNotNull(slice);
assertEquals("v001",slice.getColumnByName("testSuperMultigetSliceQuery1").getColumns().get(0).getValue());
assertNull(slice.getColumnByName("testSuperMultigetSliceQuery3"));
}