/** 
 * Test of process method, of class GenbankReader.
 */
@Test public void testProcess() throws Throwable {
  GenbankProxySequenceReader<AminoAcidCompound> genbankProteinReader=new GenbankProxySequenceReader<AminoAcidCompound>(System.getProperty("java.io.tmpdir"),"NP_000257",AminoAcidCompoundSet.getAminoAcidCompoundSet());
  ProteinSequence proteinSequence=new ProteinSequence(genbankProteinReader);
  genbankProteinReader.getHeaderParser().parseHeader(genbankProteinReader.getHeader(),proteinSequence);
  GenbankProxySequenceReader<NucleotideCompound> genbankDNAReader=new GenbankProxySequenceReader<NucleotideCompound>(System.getProperty("java.io.tmpdir"),"NM_001126",DNACompoundSet.getDNACompoundSet());
  DNASequence dnaSequence=new DNASequence(genbankDNAReader);
  genbankDNAReader.getHeaderParser().parseHeader(genbankDNAReader.getHeader(),dnaSequence);
  ClasspathResource dnaResource=new ClasspathResource("NM_000266.gb",true);
  ClasspathResource protResource=new ClasspathResource("BondFeature.gb");
  LinkedHashMap<String,DNASequence> dnaSequences=GenbankReaderHelper.readGenbankDNASequence(dnaResource.getInputStream());
  for (  DNASequence sequence : dnaSequences.values()) {
    logger.debug("DNA Sequence: {}",sequence.getSequenceAsString());
  }
  LinkedHashMap<String,ProteinSequence> protSequences=GenbankReaderHelper.readGenbankProteinSequence(protResource.getInputStream());
  for (  ProteinSequence sequence : protSequences.values()) {
    logger.debug("Protein Sequence: {}",sequence.getSequenceAsString());
  }
  GenbankReader<DNASequence,NucleotideCompound> dnaReader=new GenbankReader<DNASequence,NucleotideCompound>(dnaResource.getInputStream(),new GenericGenbankHeaderParser<DNASequence,NucleotideCompound>(),new DNASequenceCreator(DNACompoundSet.getDNACompoundSet()));
  dnaSequences=dnaReader.process();
  logger.debug("DNA Sequence: {}",dnaSequences);
  GenbankReader<ProteinSequence,AminoAcidCompound> protReader=new GenbankReader<ProteinSequence,AminoAcidCompound>(protResource.getInputStream(),new GenericGenbankHeaderParser<ProteinSequence,AminoAcidCompound>(),new ProteinSequenceCreator(AminoAcidCompoundSet.getAminoAcidCompoundSet()));
  protSequences=protReader.process();
  logger.debug("Protein Sequence: {}",protSequences);
}
