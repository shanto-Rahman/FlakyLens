@Test public void setCacheTest(){
Assert.assertFalse(inodeFile.isCache());
Assert.assertTrue(inodeFile.isCache());
Assert.assertFalse(inodeFile.isCache());
}