@Test public void testAddBranchesEventsAreFired() throws Exception {
Assert.assertEquals(expectedEventTypesInOrder,actualEventTypesInOrder);
Assert.assertEquals(5,(long)runEnvironment.removeNextStepPosition());
}