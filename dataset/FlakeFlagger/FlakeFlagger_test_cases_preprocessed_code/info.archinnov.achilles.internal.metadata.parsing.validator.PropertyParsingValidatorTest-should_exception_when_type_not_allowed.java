@Test public void should_exception_when_type_not_allowed() throws Exception {
PropertyParsingValidator.validateAllowedTypes(CustomEnum.class,allowedTypes,"msg1");//RW
}