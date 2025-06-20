/** 
 * Test successful conversion of  {@link FailsafeElement} records into {@link PubsubMessage} withattributes.
 */
@Test @Category(NeedsRunner.class) public void testFailedStringToPubsubMessageFn(){
assertThat(new String(actual.getPayload(),StandardCharsets.UTF_8),is(equalTo(testMessage)));
assertThat(actual.getAttribute(FailedStringToPubsubMessageFn.ERROR_MESSAGE),is(equalTo(errorMessage)));
assertThat(actual.getAttribute(FailedStringToPubsubMessageFn.TIMESTAMP),is(equalTo(expectedTimestampString)));
}