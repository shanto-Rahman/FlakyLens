/** 
 * Ensures the READ user can get counters.
 * @throws Exception ex
 */
@Test public void testUpdateCounters() throws Exception {
  final String counterUri=uri + "/my-counter";
  Response response;
  response=helper.getReadUser().testPut(counterUri,Collections.emptyMap());
  assertEquals(403,response.getStatus());
  response=helper.getReadWriteUser().testPut(counterUri,Collections.emptyMap());
  assertEquals(404,response.getStatus());
  response=helper.getWriteUser().testPut(counterUri,Collections.emptyMap());
  assertEquals(404,response.getStatus());
  response=helper.getNoneUser().testPut(counterUri,Collections.emptyMap());
  assertEquals(403,response.getStatus());
}
