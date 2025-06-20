@Test public void setPinTest(){
Assert.assertFalse(inodeFile.isPin());
Assert.assertTrue(inodeFile.isPin());
Assert.assertFalse(inodeFile.isPin());
}