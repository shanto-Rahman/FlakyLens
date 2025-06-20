@Test public void testLegacyOperations() throws Exception {
Assert.assertTrue("Subsystem boot failed!",servicesA.isSuccessfulBoot());
Assert.assertTrue("the subsystem describe operation has to generate a list of operations to recreate the subsystem",!result.hasDefined(ModelDescriptionConstants.FAILURE_DESCRIPTION));
}