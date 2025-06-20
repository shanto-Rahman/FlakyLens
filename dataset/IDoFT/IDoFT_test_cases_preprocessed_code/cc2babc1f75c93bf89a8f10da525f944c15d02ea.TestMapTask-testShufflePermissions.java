@Test public void testShufflePermissions() throws Exception {
conf.set(MRConfig.LOCAL_DIR,TEST_ROOT_DIR.getAbsolutePath());//RW
Assert.assertEquals("Incorrect output file perms",(short)0640,perms.toShort());
Assert.assertEquals("Incorrect index file perms",(short)0640,perms.toShort());
}