/** 
 * Tests the  {@link BigQueryConverters.FailsafeJsonToTableRow} transform with invalid JSON input.
 */
@Test @Category(NeedsRunner.class) public void testFailsafeJsonToTableRowInvalidJSON(){
assertThat(new String(result.getOriginalPayload().getPayload()),is(equalTo(payload)));
assertThat(result.getOriginalPayload().getAttributeMap(),is(equalTo(attributes)));
assertThat(result.getPayload(),is(equalTo(payload)));
assertThat(result.getErrorMessage(),is(notNullValue()));
assertThat(result.getStacktrace(),is(notNullValue()));
}