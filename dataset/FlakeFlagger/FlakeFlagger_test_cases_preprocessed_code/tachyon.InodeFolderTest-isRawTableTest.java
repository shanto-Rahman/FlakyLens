@Test public void isRawTableTest(){
Assert.assertFalse(inodeFolder.isRawTable());
Assert.assertTrue(inodeRawTable.isRawTable());
}