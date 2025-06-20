@Test public void testGetSuperRangeSlices() throws HectorException {
assertNotNull(keySlices);
assertNotNull("testGetSuperRangSlices0 is null",keySlices.get("testGetSuperRangeSlices0"));
assertEquals("testGetSuperRangeSlices_Value_0",string(keySlices.get("testGetSuperRangeSlices0").get(0).getColumns().get(0).getValue()));
assertEquals(1,keySlices.get("testGetSuperRangeSlices1").size());
assertEquals(10,keySlices.get("testGetSuperRangeSlices1").get(0).getColumns().size());
}