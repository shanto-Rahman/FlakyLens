@Test public void xmlConfigFileRemainsSameAfterReadWrite() throws IOException {
  String solverConfigResource="org/optaplanner/core/config/solver/testdataSolverConfig.xml";
  String originalXml=IOUtils.toString(getClass().getClassLoader().getResourceAsStream(solverConfigResource),StandardCharsets.UTF_8);
  SolverConfig solverConfig=SolverConfig.createFromXmlResource(solverConfigResource);
  assertNotNull(SolverFactory.create(solverConfig).buildSolver());
  XStream xStream=XStreamConfigReader.buildXStream(getClass().getClassLoader());
  xStream.setMode(XStream.NO_REFERENCES);
  String savedXml=xStream.toXML(solverConfig);
  assertEquals(originalXml.trim(),savedXml.trim());
}
