/** 
 * Binds an entry and then do lookups with several permissions
 * @throws Exception
 */
@Test public void testPermissions() throws Exception {
assertEquals(value,testActionWithPermission(JndiPermission.ACTION_LOOKUP,permissions,namingContext,name));
assertEquals(value,testActionWithPermission(JndiPermission.ACTION_LOOKUP,permissions,namingContext,name));
assertEquals(value,testActionWithPermission(JndiPermission.ACTION_LOOKUP,permissions,namingContext,name));
assertEquals(value,testActionWithPermission(JndiPermission.ACTION_LOOKUP,permissions,namingContext,name));
assertEquals(value,testActionWithPermission(JndiPermission.ACTION_LOOKUP,permissions,namingContext,name));
assertEquals(value,testActionWithPermission(JndiPermission.ACTION_LOOKUP,permissions,namingContext,store.getBaseName() + "/" + name));
assertEquals(value,testActionWithPermission(JndiPermission.ACTION_LOOKUP,permissions,aNamingContext,"b"));
fail("Should have failed due to missing permission");
fail("Should have failed due to missing permission");
fail("Should have failed due to missing permission");
if (!"java:".equals(store.getBaseName().toString())) {
fail("Should have failed due to missing permission");
fail("Should have failed due to missing permission");
}
}