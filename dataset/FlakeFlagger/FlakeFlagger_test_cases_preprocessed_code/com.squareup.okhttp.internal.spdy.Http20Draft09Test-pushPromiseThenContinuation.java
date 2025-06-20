/** 
 * Headers are compressed, then framed. 
 */
@Test public void pushPromiseThenContinuation() throws IOException {
assertEquals(expectedStreamId,streamId);
assertEquals(expectedPromisedStreamId,promisedStreamId);
assertEquals(pushPromise,headerBlock);
}