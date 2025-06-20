@Test public void testAssignAndUnassignExistingGroupsToRole() throws Throwable {
  PrincipalRoleAssignment roleAssignment=new PrincipalRoleAssignment();
  roleAssignment.add=new ArrayList<>();
  roleAssignment.add.add(AuthRole.CLOUD_ADMIN.name());
  String uri=UriUtils.buildUriPath(PrincipalService.SELF_LINK,USER_GROUP_SUPERUSERS,"roles");
  doPatch(roleAssignment,uri);
  String superusersRoleLink=UriUtils.buildUriPath(RoleService.FACTORY_LINK,AuthRole.CLOUD_ADMIN.buildRoleWithSuffix(encode(USER_GROUP_SUPERUSERS)));
  RoleState roleState=getDocument(RoleState.class,superusersRoleLink);
  assertNotNull(roleState);
  assertEquals(superusersRoleLink,roleState.documentSelfLink);
  roleAssignment=new PrincipalRoleAssignment();
  roleAssignment.remove=new ArrayList<>();
  roleAssignment.remove.add(AuthRole.CLOUD_ADMIN.name());
  doPatch(roleAssignment,uri);
  TestContext ctx=testCreate(1);
  Operation getSuperusersRole=Operation.createGet(host,superusersRoleLink).setReferer(host.getUri()).setCompletion((op,ex) -> {
    if (ex != null) {
      if (ex instanceof ServiceNotFoundException) {
        ctx.completeIteration();
        return;
      }
      ctx.failIteration(ex);
      return;
    }
    ctx.failIteration(new RuntimeException("After unassign user group, role " + "should be deleted."));
  }
);
  host.send(getSuperusersRole);
  ctx.await();
}
