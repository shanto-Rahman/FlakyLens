@Test public void verifyValidation() throws Exception {
Assert.assertNotNull(bpmnModel);
Assert.assertEquals(65,allErrors.size());
Assert.assertNotNull(problems.get(0).getValidatorSetName());
Assert.assertNotNull(problems.get(0).getProblem());
Assert.assertNotNull(problems.get(0).getDefaultDescription());
}