@Test public void testLocalScop() throws IOException, StructureException {
  if (debug) {
    System.out.println("local");
  }
  long timeS=System.currentTimeMillis();
  ScopDatabase scop=new ScopInstallation();
  ScopDatabase defaultScop=ScopFactory.getSCOP();
  ScopFactory.setScopDatabase(scop);
  runSCOPTests();
  ScopFactory.setScopDatabase(defaultScop);
  long timeE=System.currentTimeMillis();
  if (debug) {
    System.out.println(timeE - timeS);
  }
}
