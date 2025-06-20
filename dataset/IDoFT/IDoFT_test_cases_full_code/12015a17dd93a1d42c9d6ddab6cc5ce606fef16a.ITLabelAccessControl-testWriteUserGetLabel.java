/** 
 * Ensures the WRITE user can get a label.
 * @throws Exception ex
 */
@Test public void testWriteUserGetLabel() throws Exception {
  final LabelEntity entity=getRandomLabel(helper.getWriteUser());
  assertFalse(entity.getPermissions().getCanRead());
  assertTrue(entity.getPermissions().getCanWrite());
  assertNull(entity.getComponent());
}
