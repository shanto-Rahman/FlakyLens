@Test public void validationShouldFailWhenBadRequest(){
assertTrue(validation.hasFieldViolation("param1"));
}