@Test public void testExpandWildcardWithASingleResource(){
Assert.assertEquals(1,changedModel.getGroupByName("group").getResources().size());
}