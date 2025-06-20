@Test public void validationFailedWithTwoAnnotations(){
assertTrue(context.getValidation().hasViolations());
assertTrue(context.getValidation().hasBeanViolations());
assertEquals(context.getValidation().getBeanViolations().size(),2);
assertTrue(fieldName.contentEquals("regex"));
assertFalse(message0.contentEquals(message1));
}