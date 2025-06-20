@Test public void createValidModelContainingHiphen(){
Assert.assertNotNull(model.getGroupByName("group-with-hiphen"));
}