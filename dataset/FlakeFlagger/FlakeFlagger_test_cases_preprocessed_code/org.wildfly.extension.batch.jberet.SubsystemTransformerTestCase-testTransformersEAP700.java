@Test public void testTransformersEAP700() throws Exception {
assertTrue(mainServices.isSuccessfulBoot());
assertNotNull(legacyServices);
assertTrue(legacyServices.isSuccessfulBoot());
}