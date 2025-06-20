@Test public void testSuperSliceQuery(){
assertTrue("Time should be > 0",mr.getExecutionTimeMicro() > 0);
assertNotNull(r);
assertNotNull(slice);
assertEquals(3,slice.getSuperColumns().size());
assertEquals("value",slice.getColumnByName("testSuperSliceQuery1").getColumns().get(0).getValue());
assertNotNull(r);
assertNotNull(slice);
if (!scolumn.getName().equals("testSuperSliceQuery1") && !scolumn.getName().equals("testSuperSliceQuery2")) {
fail("A columns with unexpected column name returned: " + scolumn.getName());
}
assertNotNull(r);
assertNotNull(slice);
assertTrue(slice.getSuperColumns().isEmpty());
}