@Test public void testExpandWildcardWithMultipleResources(){
Assert.assertEquals(3,changedModel.getGroupByName("group").getResources().size());
}