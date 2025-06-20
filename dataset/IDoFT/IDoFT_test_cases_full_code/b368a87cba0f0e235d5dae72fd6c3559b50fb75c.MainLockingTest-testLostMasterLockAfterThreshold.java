@Test public void testLostMasterLockAfterThreshold() throws Exception {
  System.setProperty("karaf.lock.lostThreshold","3");
  String[] args=new String[0];
  Main main=new Main(args);
  main.launch();
  Framework framework=main.getFramework();
  String activatorName=TimeoutShutdownActivator.class.getName().replace('.','/') + ".class";
  Bundle bundle=framework.getBundleContext().installBundle("foo",TinyBundles.bundle().set(Constants.BUNDLE_ACTIVATOR,TimeoutShutdownActivator.class.getName()).add(activatorName,getClass().getClassLoader().getResourceAsStream(activatorName)).build(withBnd()));
  bundle.start();
  FrameworkStartLevel sl=framework.adapt(FrameworkStartLevel.class);
  MockLock lock=(MockLock)main.getLock();
  Assert.assertEquals(100,sl.getStartLevel());
  lock.setIsAlive(false);
  lock.setLock(false);
  Thread.sleep(5000);
  Assert.assertEquals(1,sl.getStartLevel());
  Thread.sleep(1000);
  lock.setIsAlive(true);
  lock.setLock(true);
  Thread.sleep(1000);
  main.destroy();
}
