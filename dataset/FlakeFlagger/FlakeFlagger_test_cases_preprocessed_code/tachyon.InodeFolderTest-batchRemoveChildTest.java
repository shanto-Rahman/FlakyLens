@Test public void batchRemoveChildTest(){
Assert.assertEquals(3,inodeFolder.getNumberOfChildren());
Assert.assertEquals(2,inodeFolder.getNumberOfChildren());
Assert.assertFalse(inodeFolder.getChildrenIds().contains(2));
}