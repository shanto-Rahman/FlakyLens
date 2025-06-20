@Test public void testGetPublicProjectOnly() throws Throwable {
  ProjectState testProject1=createProject("test-project1","test",true);
  ProjectState testProject2=createProject("test-project2","test",true);
  ProjectState testProject3=createProject("test-project3","test",false);
  ProjectState testProject4=createProject("test-project4","test",false);
  assertDocumentExists(testProject1.documentSelfLink);
  assertDocumentExists(testProject2.documentSelfLink);
  assertDocumentExists(testProject3.documentSelfLink);
  assertDocumentExists(testProject4.documentSelfLink);
  host.assumeIdentity(buildUserServicePath(USER_EMAIL_BASIC_USER));
  URI uri=UriUtils.buildUri(ProjectFactoryService.SELF_LINK);
  uri=UriUtils.extendUriWithQuery(uri,ProjectFactoryService.QUERY_PARAM_PUBLIC,"");
  ServiceDocumentQueryResult getResult=getDocumentNoWait(ServiceDocumentQueryResult.class,uri.toString());
  assertEquals(Long.valueOf(2),getResult.documentCount);
  assertEquals(2,getResult.documentLinks.size());
  assertEquals(2,getResult.documents.size());
  assertTrue(getResult.documentLinks.contains(testProject1.documentSelfLink));
  assertTrue(getResult.documentLinks.contains(testProject2.documentSelfLink));
  assertTrue(!getResult.documentLinks.contains(testProject3.documentSelfLink));
  assertTrue(!getResult.documentLinks.contains(testProject4.documentSelfLink));
}
