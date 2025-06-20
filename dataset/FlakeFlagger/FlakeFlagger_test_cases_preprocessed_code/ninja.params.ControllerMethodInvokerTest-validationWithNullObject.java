@Test public void validationWithNullObject(){
assertFalse(context.getValidation().hasViolations());
assertTrue(context.getValidation().hasViolations());
}