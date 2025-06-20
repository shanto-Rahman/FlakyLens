@Test public void validationFailedLength(){
assertTrue(context.getValidation().hasViolations());
assertEquals(context.getValidation().getBeanViolations().size(),1);
assertTrue("Expected to have length violation.",context.getValidation().hasBeanViolation("length"));
assertTrue(context.getValidation().getBeanViolations().get(0).field.contentEquals("length"));
}