/** 
 * Tests that  {@link ErrorConverters.FailedPubsubMessageToTableRowFn} properly formats failed{@link PubsubMessage} objects into {@link TableRow} objects to save to BigQuery.
 */
@Test public void testFailedPubsubMessageToTableRowFn(){
assertThat(result.get("timestamp"),is(equalTo("2022-02-22 22:22:22.222000")));
assertThat(result.get("attributes"),is(notNullValue()));
assertThat(result.get("payloadString"),is(equalTo(payload)));
assertThat(result.get("payloadBytes"),is(notNullValue()));
assertThat(result.get("errorMessage"),is(equalTo(errorMessage)));
assertThat(result.get("stacktrace"),is(equalTo(stacktrace)));
}