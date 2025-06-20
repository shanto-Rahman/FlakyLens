@Test public void testTablesWithDifferentNames(){
Assert.assertNotNull(table2);
Assert.assertSame(table1,sameTable1);
Assert.assertSame(table2,sameTable2);
}