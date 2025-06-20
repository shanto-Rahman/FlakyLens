@Test public void sameIdChildrenTest(){
Assert.assertTrue(inodeFolder.getChildrenIds().get(0) == 2);
Assert.assertEquals(1,inodeFolder.getNumberOfChildren());
}