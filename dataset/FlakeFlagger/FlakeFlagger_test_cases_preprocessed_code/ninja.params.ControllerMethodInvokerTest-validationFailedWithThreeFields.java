@Test public void validationFailedWithThreeFields(){
assertTrue(context.getValidation().hasViolations());
assertTrue(context.getValidation().hasBeanViolations());
assertTrue("Expected to have regex violation.",context.getValidation().hasBeanViolation("regex"));
assertEquals(context.getValidation().getBeanViolations().size(),3);
assertTrue(fieldName.contentEquals("regex") || fieldName.contentEquals("length") || fieldName.contentEquals("range"));
}