/** 
 * This test proves that Sass Engine behave strangely after the first failure.
 */
@Test public void shouldSucceedAfterAFailure() throws Exception {
fail("Should have failed");
}