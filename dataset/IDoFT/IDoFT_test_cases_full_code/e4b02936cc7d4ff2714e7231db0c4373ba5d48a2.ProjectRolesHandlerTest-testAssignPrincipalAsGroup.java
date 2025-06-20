@Test public void testAssignPrincipalAsGroup(){
  String groupId="superusers@admiral.com";
  ProjectRoles projectRoles=new ProjectRoles();
  projectRoles.members=new PrincipalRoleAssignment();
  projectRoles.members.add=Collections.singletonList(groupId);
  String projectId=Service.getId(project.documentSelfLink);
  doPatch(projectRoles,project.documentSelfLink);
  String resourceGroupLink=UriUtils.buildUriPath(ResourceGroupService.FACTORY_LINK,AuthRole.PROJECT_MEMBER_EXTENDED.buildRoleWithSuffix(projectId,encode(groupId)));
  String roleLink=UriUtils.buildUriPath(RoleService.FACTORY_LINK,AuthRole.PROJECT_MEMBER_EXTENDED.buildRoleWithSuffix(projectId,encode(groupId)));
  assertDocumentExists(resourceGroupLink);
  assertDocumentExists(roleLink);
  projectRoles=new ProjectRoles();
  projectRoles.members=new PrincipalRoleAssignment();
  projectRoles.members.remove=Collections.singletonList(groupId);
  doPatch(projectRoles,project.documentSelfLink);
  assertDocumentNotExists(resourceGroupLink);
  assertDocumentNotExists(roleLink);
}
