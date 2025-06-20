@Test public void testProteinSequenceFactoring() throws Exception {
  logger.info("create protein sequence test for target {}",gi);
  GenbankProxySequenceReader<AminoAcidCompound> genbankReader=new GenbankProxySequenceReader<>(System.getProperty("java.io.tmpdir"),this.gi,AminoAcidCompoundSet.getAminoAcidCompoundSet());
  ProteinSequence seq=new ProteinSequence(genbankReader);
  List<AbstractFeature<AbstractSequence<AminoAcidCompound>,AminoAcidCompound>> CDSs=genbankReader.getFeatures().get("CDS");
  if (CDSs != null) {
    if (CDSs.size() == 1) {
      final Map<String,List<Qualifier>> qualifiers=CDSs.get(0).getQualifiers();
      List<Qualifier> codedByQualifiers=qualifiers.get("coded_by");
      Qualifier codedBy=codedByQualifiers.get(0);
      if (codedBy != null) {
        AbstractSequence<?> parentSeq=seq.getParentSequence();
        Assert.assertNotNull(parentSeq);
        Assert.assertTrue(!parentSeq.getSequenceAsString().isEmpty());
      }
    }
  }
 else {
    logger.info("target {} has no CDS",gi);
  }
  Thread.sleep(500);
}
