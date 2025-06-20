@Test public void testEntityWithIdentityTransferEncoding() throws Exception {
Assert.assertNotNull(outstream);
Assert.assertTrue(outstream instanceof IdentityOutputStream);
}