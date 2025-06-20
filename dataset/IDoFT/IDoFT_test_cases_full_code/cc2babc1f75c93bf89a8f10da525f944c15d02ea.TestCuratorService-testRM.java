@Test public void testRM() throws Throwable {
  mkPath("/rm",CreateMode.PERSISTENT);
  curatorService.zkDelete("/rm",false,null);
  verifyNotExists("/rm");
  curatorService.zkDelete("/rm",false,null);
}
