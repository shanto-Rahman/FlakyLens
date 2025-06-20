@Test public void validationPassed(){
assertFalse(context.getValidation().hasViolations());
assertFalse("Expected not to have regex violation.",context.getValidation().hasBeanViolation("regex"));
}