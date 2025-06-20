@Test public void xmlConfigFileRemainsSameAfterReadWrite() throws IOException {
assertNotNull(SolverFactory.create(solverConfig).buildSolver());
assertEquals(originalXml.trim(),savedXml.trim());
}