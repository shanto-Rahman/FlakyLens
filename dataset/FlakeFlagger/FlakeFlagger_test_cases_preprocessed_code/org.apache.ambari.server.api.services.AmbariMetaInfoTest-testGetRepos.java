@Test public void testGetRepos() throws Exception {
Map<String,List<RepositoryInfo>> repos=metaInfo.getRepository(STACK_NAME_HDP,STACK_VERSION_HDP);//RW
if (repo.getOsType().equals("centos5")) {
if (repo.getOsType().equals("centos6")) {
if (repo.getOsType().equals("redhat6")) {
fail("Found invalid os" + repo.getOsType());
}
}
}
if (repo.getRepoId().equals("epel")) {
assertFalse(repo.getMirrorsList().isEmpty());
assertNull(repo.getBaseUrl());
assertNull(repo.getMirrorsList());
assertFalse(repo.getBaseUrl().isEmpty());
}
assertEquals(3,centos5Cnt.size());
assertEquals(3,redhat6cnt.size());
assertEquals(3,centos6Cnt.size());
}