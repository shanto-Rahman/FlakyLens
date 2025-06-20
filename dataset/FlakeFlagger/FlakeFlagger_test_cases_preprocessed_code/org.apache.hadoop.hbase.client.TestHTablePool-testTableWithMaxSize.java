@Test public void testTableWithMaxSize(){
Assert.assertSame(table1,sameTable1);
Assert.assertSame(table2,sameTable2);
Assert.assertNotSame(table3,sameTable3);
}