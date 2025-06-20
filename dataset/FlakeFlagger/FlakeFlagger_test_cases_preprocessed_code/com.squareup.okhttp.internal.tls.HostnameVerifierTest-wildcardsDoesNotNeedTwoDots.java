/** 
 * Earlier implementations of Android's hostname verifier required that wildcard names wouldn't match "*.com" or similar. This was a nonstandard check that we've since dropped. It is the CA's responsibility to not hand out certificates that match so broadly.
 */
@Test public void wildcardsDoesNotNeedTwoDots() throws Exception {
assertTrue(verifier.verify("google.com",session));
}