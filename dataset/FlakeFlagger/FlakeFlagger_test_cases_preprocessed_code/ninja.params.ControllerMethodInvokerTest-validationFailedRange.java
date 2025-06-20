@Test public void validationFailedRange(){
assertTrue(context.getValidation().hasViolations());
assertEquals(context.getValidation().getBeanViolations().size(),1);
assertTrue("Expected to have range violation.",context.getValidation().hasBeanViolation("range"));
assertTrue(context.getValidation().getBeanViolations().get(0).field.contentEquals("range"));
}