@Test(timeout=300000) public void testClusterRestart() throws Exception {
assertEquals(3,allEntityGroups.size());
Thread.sleep(2000);
assertEquals(3,allEntityGroups.size());
assertTrue("Able to create table that should already exist",false);
if (t instanceof RemoteException) {
}
if (t.getClass().getName().equals("com.alibaba.wasp.TableExistsException")) {
}
}