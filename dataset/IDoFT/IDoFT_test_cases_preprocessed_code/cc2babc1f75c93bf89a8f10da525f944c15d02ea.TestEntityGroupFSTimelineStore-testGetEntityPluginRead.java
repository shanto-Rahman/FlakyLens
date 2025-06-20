@Test public void testGetEntityPluginRead() throws Exception {
Path userBase=new Path(testActiveDirPath,user);//RW
assertNotNull(entity);
assertEquals(entityNew.getEntityId(),entity.getEntityId());
assertEquals(entityNew.getEntityType(),entity.getEntityType());
if (store != null) {
}
fs.delete(userBase,true);//RW
}