/** 
 * Test successful conversion of  {@link FailsafeElement} records into {@link PubsubMessage} withattributes.
 */
@Test @Category(NeedsRunner.class) public void testFailedStringToPubsubMessageFn(){
  String testMessage="original-test-message";
  FailsafeElement<String,String> element=FailsafeElement.of(testMessage,testMessage);
  Instant expectedTimestamp=Instant.now();
  String errorMessage="my-error-message";
  element.setErrorMessage(errorMessage);
  TimestampedValue<FailsafeElement<String,String>> input=TimestampedValue.of(element,expectedTimestamp);
  PCollection<PubsubMessage> pCollection=pipeline.apply(Create.timestamped(input).withCoder(FailsafeElementCoder.of(StringUtf8Coder.of(),StringUtf8Coder.of()))).apply(ParDo.of(new FailedStringToPubsubMessageFn()));
  String expectedTimestampString=FailedStringToPubsubMessageFn.TIMESTAMP_FORMATTER.print(expectedTimestamp.toDateTime(DateTimeZone.UTC));
  PAssert.that(pCollection).satisfies(collection -> {
    PubsubMessage actual=collection.iterator().next();
    assertThat(new String(actual.getPayload(),StandardCharsets.UTF_8),is(equalTo(testMessage)));
    assertThat(actual.getAttribute(FailedStringToPubsubMessageFn.ERROR_MESSAGE),is(equalTo(errorMessage)));
    assertThat(actual.getAttribute(FailedStringToPubsubMessageFn.TIMESTAMP),is(equalTo(expectedTimestampString)));
    return null;
  }
);
  pipeline.run();
}
