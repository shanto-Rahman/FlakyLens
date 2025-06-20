/** 
 * Tests the SubSliceQuery, a query on columns within a supercolumn
 */
@Test public void testSubSliceQuery(){
assertNotNull(r);
assertNotNull(slice);
assertEquals(2,slice.getColumns().size());
assertEquals("v000",slice.getColumnByName("c000").getValue());
assertNotNull(r);
assertNotNull(slice);
if (!column.getName().equals("c000") && !column.getName().equals("c110")) {
fail("A columns with unexpected column name returned: " + column.getName());
}
assertNotNull(r);
assertNotNull(slice);
assertTrue(slice.getColumns().isEmpty());
}