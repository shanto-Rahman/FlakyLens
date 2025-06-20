/** 
 * Response code 407 should only come from proxy servers. Android's client throws if it is sent by an origin server.
 */
@Test public void originServerSends407() throws Exception {
fail();
}