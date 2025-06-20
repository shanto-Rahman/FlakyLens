/** 
 * Ensures the READ WRITE user can get a process group.
 * @throws Exception ex
 */
@Test public void testReadWriteUserGetProcessGroup() throws Exception {
  final ProcessGroupEntity entity=getRandomProcessGroup(helper.getReadWriteUser());
  assertTrue(entity.getPermissions().getCanRead());
  assertTrue(entity.getPermissions().getCanWrite());
  assertNotNull(entity.getComponent());
  assertNull(entity.getComponent().getContents());
}
