@Test public void addChildrenTest(){
Assert.assertEquals(2,(int)inodeFolder.getChildrenIds().get(0));
Assert.assertEquals(3,(int)inodeFolder.getChildrenIds().get(1));
}