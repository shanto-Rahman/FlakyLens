/** 
 * We need delete of a znode to work at least.
 */
@Test public void testCommandLineWorks() throws Exception {
  System.setSecurityManager(new NoExitSecurityManager());
  HBaseZKTestingUtility htu=new HBaseZKTestingUtility();
  htu.getConfiguration().setInt(HConstants.ZK_SESSION_TIMEOUT,30000);
  htu.startMiniZKCluster();
  try {
    ZKWatcher zkw=htu.getZooKeeperWatcher();
    String znode="/testCommandLineWorks";
    ZKUtil.createWithParents(zkw,znode,HConstants.EMPTY_BYTE_ARRAY);
    ZKUtil.checkExists(zkw,znode);
    boolean exception=false;
    try {
      ZKMainServer.main(new String[]{"-server",htu.getZkCluster().getAddress().toString(),"delete",znode});
    }
 catch (    ExitException ee) {
      exception=true;
    }
    assertTrue(exception);
    assertEquals(-1,ZKUtil.checkExists(zkw,znode));
  }
  finally {
    htu.shutdownMiniZKCluster();
    System.setSecurityManager(null);
  }
}
