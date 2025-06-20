/** 
 * A selection of structures with no global symmetry, but local symmetry
 * @throws IOException
 * @throws StructureException
 */
@Test public void testLocal() throws IOException, StructureException {
  AtomCache atomCache=new AtomCache();
  atomCache.setUseMmtf(true);
  List<String> testIds=new ArrayList<>();
  List<String> testStoichiometries=new ArrayList<>();
  List<Map<String,String>> testLocalSymmetries=new ArrayList<>();
  Map<String,String> localSymmetries;
  testIds.add("BIO:5NUQ:1");
  testStoichiometries.add("A3B");
  localSymmetries=new HashMap<>();
  localSymmetries.put("A3","C3");
  testLocalSymmetries.add(localSymmetries);
  testIds.add("BIO:4P2C:1");
  testStoichiometries.add("A5B5C");
  localSymmetries=new HashMap<>();
  localSymmetries.put("A5B5","C5");
  testLocalSymmetries.add(localSymmetries);
  testIds.add("BIO:3J96:1");
  testStoichiometries.add("A6B4CDE");
  localSymmetries=new HashMap<>();
  localSymmetries.put("B4","C4");
  testLocalSymmetries.add(localSymmetries);
  testIds.add("BIO:5WVK:1");
  testStoichiometries.add("A2B2C2D2E2F2G2H2I2J2K2L2M2N2OPQRSTUVWXYZabcdef");
  localSymmetries=new HashMap<>();
  localSymmetries.put("A2B2C2D2E2F2G2H2I2J2K2L2M2N2","C2");
  testLocalSymmetries.add(localSymmetries);
  testIds.add("BIO:5JXT:1");
  testStoichiometries.add("A16");
  localSymmetries=new HashMap<>();
  localSymmetries.put("A8","D2");
  testLocalSymmetries.add(localSymmetries);
  testIds.add("BIO:1O18:1");
  testStoichiometries.add("A14B6C5D5");
  localSymmetries=new HashMap<>();
  localSymmetries.put("A14","H");
  testLocalSymmetries.add(localSymmetries);
  testIds.add("BIO:4A8A:1");
  testStoichiometries.add("A12B");
  localSymmetries=new HashMap<>();
  localSymmetries.put("A12","T");
  testLocalSymmetries.add(localSymmetries);
  testIds.add("BIO:5DN6:1");
  testStoichiometries.add("A12B3C3DEFGHIJKL");
  localSymmetries=new HashMap<>();
  localSymmetries.put("B3C3","C3");
  localSymmetries.put("A12","C12");
  testLocalSymmetries.add(localSymmetries);
  testIds.add("BIO:5FL7:1");
  testStoichiometries.add("A10B3C3DE");
  localSymmetries=new HashMap<>();
  localSymmetries.put("B3C3","C3");
  localSymmetries.put("A10","C10");
  testLocalSymmetries.add(localSymmetries);
  testIds.add("BIO:2OF5:1");
  testStoichiometries.add("A7B5");
  localSymmetries=new HashMap<>();
  localSymmetries.put("A7","H");
  localSymmetries.put("A5B5","H");
  testLocalSymmetries.add(localSymmetries);
  testIds.add("BIO:6EM9:1");
  testStoichiometries.add("A8B2");
  localSymmetries=new HashMap<>();
  localSymmetries.put("B2","C2");
  localSymmetries.put("A7","H");
  testLocalSymmetries.add(localSymmetries);
  testIds.add("BIO:4NTP:1");
  testStoichiometries.add("A16");
  localSymmetries=new HashMap<>();
  localSymmetries.put("A2","C2");
  localSymmetries.put("A6","D3");
  testLocalSymmetries.add(localSymmetries);
  testIds.add("BIO:3JC9:1");
  testStoichiometries.add("A12B12C12D12E12F12G5H2");
  localSymmetries=new HashMap<>();
  localSymmetries.put("A12B12C12D12E12H2","C2");
  localSymmetries.put("A12B12C12D12E12F12","C12");
  localSymmetries.put("G5","H");
  testLocalSymmetries.add(localSymmetries);
  QuatSymmetryParameters symmParams=new QuatSymmetryParameters();
  SubunitClustererParameters clusterParams=new SubunitClustererParameters(true);
  clusterParams.setClustererMethod(SubunitClustererMethod.SEQUENCE);
  clusterParams.setSequenceIdentityThreshold(0.75);
  for (int iTest=0; iTest < testIds.size(); iTest++) {
    logger.info("Processing " + testIds.get(iTest));
    Structure pdb=atomCache.getStructure(testIds.get(iTest));
    Stoichiometry composition=SubunitClusterer.cluster(pdb,clusterParams);
    QuatSymmetryResults globalSymmetry=QuatSymmetryDetector.calcGlobalSymmetry(composition,symmParams);
    assertEquals("Unexpected global symmetry in " + testIds.get(iTest),"C1",globalSymmetry.getSymmetry());
    assertEquals("Unexpected global stoichiometry in " + testIds.get(iTest),testStoichiometries.get(iTest),globalSymmetry.getStoichiometry().toString());
    List<QuatSymmetryResults> foundLocal=QuatSymmetryDetector.calcLocalSymmetries(composition,symmParams);
    Map<String,String> refLocal=testLocalSymmetries.get(iTest);
    for (    QuatSymmetryResults local : foundLocal) {
      logger.info("Found stoichiometry " + local.getStoichiometry().toString() + " with symmetry "+ local.getSymmetry());
      assertTrue("Stoichiometry " + local.getStoichiometry().toString() + " not expected for "+ testIds.get(iTest),refLocal.containsKey(local.getStoichiometry().toString()));
      assertEquals("Symmetry " + local.getSymmetry() + " with stoichiometry "+ local.getStoichiometry().toString()+ " not expected for "+ testIds.get(iTest),refLocal.get(local.getStoichiometry().toString()),local.getSymmetry());
    }
  }
}
