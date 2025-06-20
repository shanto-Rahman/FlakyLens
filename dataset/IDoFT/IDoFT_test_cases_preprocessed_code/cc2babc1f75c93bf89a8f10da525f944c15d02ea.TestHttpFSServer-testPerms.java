/** 
 * Validate that files are created with 755 permissions when no 'permissions' attribute is specified, and when 'permissions' is specified, that value is honored.
 */
@Test @TestDir @TestJetty @TestHdfs public void testPerms() throws Exception {
Assert.assertTrue("755".equals(getPerms(statusJson)));
Assert.assertTrue("777".equals(getPerms(statusJson)));
Assert.assertTrue("654".equals(getPerms(statusJson)));
Assert.assertTrue("321".equals(getPerms(statusJson)));
}