@Test public void testPostUpgradeDefaultProject() throws Throwable {
  ProjectState projectState=new ProjectState();
  projectState.name="test";
  projectState.documentSelfLink=ProjectService.DEFAULT_PROJECT_LINK;
  projectState.administratorsUserGroupLink="test";
  ProjectState updatedState=doPost(projectState,ProjectFactoryService.SELF_LINK);
  assertNull(updatedState.administratorsUserGroupLink);
}
