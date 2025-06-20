@Test public void logging_of_both_request_and_response_validation_works_when_test_fails() throws JSONException {
fail("Should throw AssertionError");
assertThat(writerString1,startsWith(headerString1));
}