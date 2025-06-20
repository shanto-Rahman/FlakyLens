@Test @TestDir @TestJetty @TestHdfs public void testMkdirWithUnmaskedPermissions() throws Exception {
Assert.assertNotNull(theAcl);
Assert.assertEquals(FsAction.NONE,aclStatus.getEffectivePermission(theAcl));
Assert.assertNotNull(theAcl);
Assert.assertEquals(FsAction.READ_WRITE,aclStatus.getEffectivePermission(theAcl));
}