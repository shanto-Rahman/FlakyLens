@Test public void testFeatures() throws IOException, InterruptedException, CompoundNotFoundException {
  logger.info("run test for protein: {}",gi);
  GenbankProxySequenceReader<AminoAcidCompound> genbankReader=new GenbankProxySequenceReader<>(System.getProperty("java.io.tmpdir"),this.gi,AminoAcidCompoundSet.getAminoAcidCompoundSet());
  ProteinSequence seq=new ProteinSequence(genbankReader);
  Assert.assertNotNull("protein sequence is null",seq);
  genbankReader.getHeaderParser().parseHeader(genbankReader.getHeader(),seq);
  Assert.assertNotNull(seq.getDescription());
  logger.info("accession id: {}",seq.getAccession().getID());
  Assert.assertNotNull(seq.getAccession().getID());
  if (seq.getAccession().getIdentifier() != null) {
    Assert.assertEquals(gi,seq.getAccession().getIdentifier());
    logger.info("found identifier '{}'",seq.getAccession().getIdentifier());
  }
  logger.info("taxonomy id: {}",seq.getTaxonomy().getID());
  Assert.assertNotNull(seq.getTaxonomy().getID());
  Assert.assertNotNull(Integer.decode(seq.getTaxonomy().getID().split(":")[1]));
  String taxonName=seq.getFeaturesByType("source").get(0).getQualifiers().get("organism").get(0).getValue();
  logger.info("taxonomy name '{}'",taxonName);
  Assert.assertNotNull(taxonName);
  if (seq.getFeaturesByType("CDS").size() > 0) {
    FeatureInterface<AbstractSequence<AminoAcidCompound>,AminoAcidCompound> CDS=seq.getFeaturesByType("CDS").get(0);
    logger.info("CDS: {}",CDS);
    String codedBy=CDS.getQualifiers().get("coded_by").get(0).getValue();
    Assert.assertNotNull(codedBy);
    Assert.assertTrue(!codedBy.isEmpty());
    logger.info("\t\tcoded_by: {}",codedBy);
  }
  Thread.sleep(500);
}
