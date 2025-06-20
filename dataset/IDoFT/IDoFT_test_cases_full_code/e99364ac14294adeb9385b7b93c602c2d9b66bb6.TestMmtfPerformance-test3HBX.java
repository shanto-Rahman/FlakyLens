@Test public void test3HBX() throws Exception {
  String pdbId="3hbx";
  pdbId=pdbId.toUpperCase();
  URL url=new URL("https://files.rcsb.org/download/" + pdbId + ".pdb.gz");
  String pdbFile=convertStreamToString(new GZIPInputStream(url.openStream()));
  long totalTimePDB=0;
  long totalTimeMMTF=0;
  byte[] pdbBytes=pdbFile.getBytes();
  PDBFileParser parser=new PDBFileParser();
  URL mmtfURL=new URL("https://mmtf.rcsb.org/v1.0/full/" + pdbId + ".mmtf.gz");
  byte[] mmtfdata=getByteArrayFromInputStream(new GZIPInputStream((mmtfURL.openStream())));
  MmtfActions.readFromInputStream(new ByteArrayInputStream(mmtfdata));
  parser.parsePDBFile(new ByteArrayInputStream(pdbBytes));
  for (int i=0; i < NUMBER_OF_REPEATS; i++) {
    long mmtfStart=System.nanoTime();
    MmtfActions.readFromInputStream(new ByteArrayInputStream(mmtfdata));
    long mmtfEnd=System.nanoTime();
    long pdbStart=System.nanoTime();
    parser.parsePDBFile(new ByteArrayInputStream(pdbBytes));
    long pdbEnd=System.nanoTime();
    totalTimePDB+=(pdbEnd - pdbStart);
    totalTimeMMTF+=(mmtfEnd - mmtfStart);
  }
  long timePDB=(totalTimePDB / NUMBER_OF_REPEATS);
  long timeMMTF=(totalTimeMMTF / NUMBER_OF_REPEATS);
  logger.info("average time to parse mmtf: " + timeMMTF / (1000 * 1000) + " ms.");
  logger.info("average time to parse PDB : " + timePDB / (1000 * 1000) + " ms. ");
  assertTrue("It should not be the case, but it is faster to parse a PDB file (" + timePDB + " ns.) than MMTF ("+ (timeMMTF)+ " ns.)!",(timePDB) > (timeMMTF));
}
