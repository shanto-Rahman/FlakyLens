@Test(expected=ResponseProcessingException.class) public void testExceptionInClientResponseFilterWhenNotFound(){
fail("Should not be invoked");
}