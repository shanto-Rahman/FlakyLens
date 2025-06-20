@Test public void testTransformersRejectionEAP700() throws Exception {
assertTrue(mainServices.isSuccessfulBoot());
assertTrue(mainServices.getLegacyServices(modelVersion).isSuccessfulBoot());
}