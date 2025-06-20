/** 
 * Tests the  {@link BigQueryConverters.FailsafeJsonToTableRow} transform with invalid JSON input.
 */
@Test @Category(NeedsRunner.class) public void testFailsafeJsonToTableRowInvalidJSON(){
  final String payload="{\"ticker\": \"GOOGL\", \"price\": 1006.94";
  final Map<String,String> attributes=ImmutableMap.of("id","0xDb12","type","stock");
  final PubsubMessage message=new PubsubMessage(payload.getBytes(),attributes);
  final FailsafeElement<PubsubMessage,String> input=FailsafeElement.of(message,payload);
  FailsafeElementCoder<PubsubMessage,String> coder=FailsafeElementCoder.of(PubsubMessageWithAttributesCoder.of(),StringUtf8Coder.of());
  CoderRegistry coderRegistry=pipeline.getCoderRegistry();
  coderRegistry.registerCoderForType(coder.getEncodedTypeDescriptor(),coder);
  PCollectionTuple output=pipeline.apply("CreateInput",Create.of(input).withCoder(coder)).apply("JsonToTableRow",FailsafeJsonToTableRow.<PubsubMessage>newBuilder().setSuccessTag(TABLE_ROW_TAG).setFailureTag(FAILSAFE_ELM_TAG).build());
  PAssert.that(output.get(TABLE_ROW_TAG)).empty();
  PAssert.that(output.get(FAILSAFE_ELM_TAG)).satisfies(collection -> {
    final FailsafeElement<PubsubMessage,String> result=collection.iterator().next();
    assertThat(new String(result.getOriginalPayload().getPayload()),is(equalTo(payload)));
    assertThat(result.getOriginalPayload().getAttributeMap(),is(equalTo(attributes)));
    assertThat(result.getPayload(),is(equalTo(payload)));
    assertThat(result.getErrorMessage(),is(notNullValue()));
    assertThat(result.getStacktrace(),is(notNullValue()));
    return null;
  }
);
  pipeline.run();
}
