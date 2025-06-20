/** 
 * WFLY-2640 and WFLY-8141 
 */
@Test public void testCCMHandling() throws Exception {
assertTrue("Subsystem boot failed!",services.isSuccessfulBoot());
assertTrue(ccm.isDefined());
assertTrue(ccm.hasDefined("install"));
assertTrue(result.asBoolean());
assertFalse(result.asBoolean());
assertFalse(result.asBoolean());
assertTrue(result.asBoolean());
assertFalse(result.asBoolean());
assertTrue(result.asBoolean());
}