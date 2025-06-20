/** 
 * Test table operations
 */
@Test public void testTableOps() throws MetaException, InvalidObjectException, NoSuchObjectException, InvalidInputException {
Assert.assertEquals(1,tables.size());
Assert.assertEquals(TABLE1,tables.get(0));
Assert.assertEquals(1,tables.size());
Assert.assertEquals("new" + TABLE1,tables.get(0));
Assert.assertEquals("Owner of table was not altered",newTbl1.getOwner(),alteredTable.getOwner());
Assert.assertEquals("Owner type of table was not altered",newTbl1.getOwnerType(),alteredTable.getOwnerType());
Assert.assertEquals(2,tables.size());
Assert.assertEquals(0,foreignKeys.size());
Assert.assertEquals(1,foreignKeys.size());
if (fks != null) {
}
Assert.assertEquals(0,foreignKeys.size());
Assert.assertEquals(0,foreignKeys.size());
Assert.assertEquals(1,tables.size());
Assert.assertEquals(0,tables.size());
}