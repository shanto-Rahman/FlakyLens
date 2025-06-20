/** 
 * Tests that  {@link ErrorConverters.FailedPubsubMessageToTableRowFn} properly formats failed{@link PubsubMessage} objects into {@link TableRow} objects to save to BigQuery.
 */
@Test public void testFailedPubsubMessageToTableRowFn(){
  final String payload="Super secret";
  final String errorMessage="Failed to parse input JSON";
  final String stacktrace="Error at com.google.cloud.teleport.PubsubToBigQuery";
  final PubsubMessage message=new PubsubMessage(payload.getBytes(),ImmutableMap.of("id","123","type","custom_event"));
  final FailsafeElement<PubsubMessage,String> input=FailsafeElement.of(message,payload).setErrorMessage(errorMessage).setStacktrace(stacktrace);
  final Instant timestamp=new DateTime(2022,2,22,22,22,22,222,DateTimeZone.UTC).toInstant();
  FailsafeElementCoder<PubsubMessage,String> coder=FailsafeElementCoder.of(PubsubMessageWithAttributesCoder.of(),StringUtf8Coder.of());
  CoderRegistry coderRegistry=pipeline.getCoderRegistry();
  coderRegistry.registerCoderForType(coder.getEncodedTypeDescriptor(),coder);
  PCollection<TableRow> output=pipeline.apply("CreateInput",Create.timestamped(TimestampedValue.of(input,timestamp)).withCoder(coder)).apply("FailedRecordToTableRow",ParDo.of(new FailedPubsubMessageToTableRowFn()));
  PAssert.that(output).satisfies(collection -> {
    final TableRow result=collection.iterator().next();
    assertThat(result.get("timestamp"),is(equalTo("2022-02-22 22:22:22.222000")));
    assertThat(result.get("attributes"),is(notNullValue()));
    assertThat(result.get("payloadString"),is(equalTo(payload)));
    assertThat(result.get("payloadBytes"),is(notNullValue()));
    assertThat(result.get("errorMessage"),is(equalTo(errorMessage)));
    assertThat(result.get("stacktrace"),is(equalTo(stacktrace)));
    return null;
  }
);
  pipeline.run();
}
