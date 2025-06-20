@Test public void testNonExecutableProcessDefinitionWarning(){
Assert.assertEquals(3,errors.size());
Assert.assertTrue(error.isWarning());
Assert.assertNotNull(error.getValidatorSetName());
Assert.assertNotNull(error.getProblem());
Assert.assertNotNull(error.getDefaultDescription());
}