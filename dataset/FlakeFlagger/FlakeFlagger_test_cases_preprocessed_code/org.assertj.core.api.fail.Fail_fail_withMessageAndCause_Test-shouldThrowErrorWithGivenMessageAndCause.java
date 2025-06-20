@Test public void shouldThrowErrorWithGivenMessageAndCause(){
Fail.fail(message,cause);
fail("AssertionError should have been thrown");
assertEquals(e.getMessage(),message);
assertSame(e.getCause(),cause);
}