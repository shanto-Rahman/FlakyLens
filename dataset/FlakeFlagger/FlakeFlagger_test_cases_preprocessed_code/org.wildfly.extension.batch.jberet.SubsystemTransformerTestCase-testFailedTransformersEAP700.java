@Test public void testFailedTransformersEAP700() throws Exception {
Assert.assertNotNull(legacyServices);
Assert.assertTrue("main services did not boot",mainServices.isSuccessfulBoot());
Assert.assertTrue(legacyServices.isSuccessfulBoot());
}