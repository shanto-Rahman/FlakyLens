/** 
 * Tests the  {@link BigQueryConverters.FailsafeJsonToTableRow} transform with good input. 
 */
@Test @Category(NeedsRunner.class) public void testFailsafeJsonToTableRowValidInput(){
  final String payload="{\"ticker\": \"GOOGL\", \"price\": 1006.94}";
  final Map<String,String> attributes=ImmutableMap.of("id","0xDb12","type","stock");
  final PubsubMessage message=new PubsubMessage(payload.getBytes(),attributes);
  final FailsafeElement<PubsubMessage,String> input=FailsafeElement.of(message,payload);
  TableRow expectedRow=new TableRow().set("ticker","GOOGL").set("price",1006.94);
  FailsafeElementCoder<PubsubMessage,String> coder=FailsafeElementCoder.of(PubsubMessageWithAttributesCoder.of(),StringUtf8Coder.of());
  CoderRegistry coderRegistry=pipeline.getCoderRegistry();
  coderRegistry.registerCoderForType(coder.getEncodedTypeDescriptor(),coder);
  PCollectionTuple output=pipeline.apply("CreateInput",Create.of(input).withCoder(coder)).apply("JsonToTableRow",FailsafeJsonToTableRow.<PubsubMessage>newBuilder().setSuccessTag(TABLE_ROW_TAG).setFailureTag(FAILSAFE_ELM_TAG).build());
  PAssert.that(output.get(TABLE_ROW_TAG)).containsInAnyOrder(expectedRow);
  PAssert.that(output.get(FAILSAFE_ELM_TAG)).empty();
  pipeline.run();
}
