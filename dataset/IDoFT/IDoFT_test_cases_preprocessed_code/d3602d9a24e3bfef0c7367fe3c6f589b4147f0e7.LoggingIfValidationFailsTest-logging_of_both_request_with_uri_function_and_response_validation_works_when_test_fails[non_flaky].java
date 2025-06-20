@Test public void logging_of_both_request_with_uri_function_and_response_validation_works_when_test_fails() throws JSONException {
fail("Should throw AssertionError");
assertThat(writer.toString(),containsString(UriUtils.encode("Request from uri function",defaultCharset())));
assertThat(writer.toString(),containsString(String.format("Request method:\tPOST%n")));
assertThat(writerString2,containsString(headerString2));
}