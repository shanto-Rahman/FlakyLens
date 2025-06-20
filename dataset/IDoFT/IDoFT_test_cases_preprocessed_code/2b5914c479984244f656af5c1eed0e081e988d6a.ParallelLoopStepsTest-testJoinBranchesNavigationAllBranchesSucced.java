@Test public void testJoinBranchesNavigationAllBranchesSucced() throws Exception {
Assert.assertEquals(0,(long)runEnvironment.removeNextStepPosition());
Assert.assertNotNull("return values not found in runtime environment",returnValues);
Assert.assertEquals("CUSTOM_SUCCESS",returnValues.getResult());
}