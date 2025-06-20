@Test(expected=WroRuntimeException.class) public void shouldDetectInvalidGroupReference(){
assertTrue(model.getGroups().isEmpty());
}