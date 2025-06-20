@Test public void logging_if_response_validation_fails_works() throws JSONException {
fail("Should throw AssertionError");
assertThat(writerString,startsWith(headerString));
}