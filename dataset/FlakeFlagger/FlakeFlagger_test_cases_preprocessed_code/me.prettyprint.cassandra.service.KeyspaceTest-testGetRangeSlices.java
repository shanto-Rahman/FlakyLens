@Test public void testGetRangeSlices() throws HectorException {
assertNotNull(keySlices);
assertNotNull("testGetRangeSlices1 is null",keySlices.get("testGetRangeSlices1"));
assertEquals("testGetRangeSlices_Value_0",string(keySlices.get("testGetRangeSlices1").get(0).getValue()));
assertEquals(10,keySlices.get("testGetRangeSlices1").size());
}