@Test public void testDelete() throws Throwable {
  String admins=project.administratorsUserGroupLinks.iterator().next();
  String members=project.membersUserGroupLinks.iterator().next();
  String viewers=project.viewersUserGroupLinks.iterator().next();
  deleteProject(project);
  UserGroupState adminsGroup=getDocumentNoWait(UserGroupState.class,admins);
  assertNull(adminsGroup);
  UserGroupState membersGroups=getDocumentNoWait(UserGroupState.class,members);
  assertNull(membersGroups);
  UserGroupState viewersGroups=getDocumentNoWait(UserGroupState.class,viewers);
  assertNull(viewersGroups);
}
