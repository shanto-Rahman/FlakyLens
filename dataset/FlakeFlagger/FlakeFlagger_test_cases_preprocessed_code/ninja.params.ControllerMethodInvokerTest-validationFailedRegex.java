@Test public void validationFailedRegex(){
assertTrue(context.getValidation().hasViolations());
assertEquals(context.getValidation().getBeanViolations().size(),1);
assertTrue("Expected to have regex violation.",context.getValidation().hasBeanViolation("regex"));
assertTrue(context.getValidation().getBeanViolations().get(0).field.contentEquals("regex"));
}