/** 
 * Test for #703 - Chemical component cache poisoning Handle empty CIF files
 * @throws IOException
 * @throws StructureException
 */
@Test public void testEmptyGZChemComp() throws IOException, StructureException {
  Path tmpCache=Paths.get(System.getProperty("java.io.tmpdir"),"BIOJAVA_TEST_CACHE");
  logger.info("Testing AtomCache at {}",tmpCache.toString());
  System.setProperty(UserConfiguration.PDB_DIR,tmpCache.toString());
  System.setProperty(UserConfiguration.PDB_CACHE_DIR,tmpCache.toString());
  FileDownloadUtils.deleteDirectory(tmpCache);
  Files.createDirectory(tmpCache);
  try {
    cache.setPath(tmpCache.toString());
    cache.setCachePath(tmpCache.toString());
    cache.setUseMmCif(true);
    ChemCompGroupFactory.setChemCompProvider(new DownloadChemCompProvider(tmpCache.toString()));
    Path sub=tmpCache.resolve(Paths.get("chemcomp","ATP.cif.gz"));
    Files.createDirectories(sub.getParent());
    try (GZIPOutputStream out=new GZIPOutputStream(new FileOutputStream(sub.toFile()))){
      out.flush();
    }
     assertTrue(Files.exists(sub));
    assertTrue(0 < Files.size(sub) && Files.size(sub) < LocalPDBDirectory.MIN_PDB_FILE_SIZE);
    Path testCif=tmpCache.resolve(Paths.get("data","structures","divided","mmCIF","ab","1abc.cif.gz"));
    Files.createDirectories(testCif.getParent());
    URL resource=AtomCacheTest.class.getResource("/atp.cif.gz");
    File src=new File(resource.getPath());
    FileDownloadUtils.copy(src,testCif.toFile());
    Structure s=cache.getStructure("1ABC");
    assertTrue(Files.size(sub) > LocalPDBDirectory.MIN_PDB_FILE_SIZE);
    assertNotNull(s);
    Group g=s.getChain("A").getAtomGroup(0);
    assertTrue(g.getPDBName().equals("ATP"));
    ChemComp chem=g.getChemComp();
    assertNotNull(chem);
    assertTrue(chem.getAtoms().size() > 0);
    assertEquals("NON-POLYMER",chem.getType());
  }
  finally {
    FileDownloadUtils.deleteDirectory(tmpCache);
  }
}
