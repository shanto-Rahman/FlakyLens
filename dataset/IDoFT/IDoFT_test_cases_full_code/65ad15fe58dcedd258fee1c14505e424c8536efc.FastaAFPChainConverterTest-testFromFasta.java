@Test public void testFromFasta() throws IOException, StructureException, CompoundNotFoundException {
  Structure s1=cache.getStructure("1w0p");
  Structure s2=cache.getStructure("1qdm");
  ProteinSequence seq1=new ProteinSequence("GWGG----SEL--YRRNTSLNS--QQDW-------QSNAKIRIVDGAA-----NQIQ");
  ProteinSequence seq2=new ProteinSequence("WMQNQLAQNKT--QDLILDYVNQLCNRL---PSPMESAV----DCGSLGSMPDIEFT");
  AFPChain afpChain=FastaAFPChainConverter.fastaToAfpChain(seq1,seq2,s1,s2);
  assertEquals("Wrong number of EQRs",33,afpChain.getNrEQR());
  assertEquals("Wrong number of alnLength",53,afpChain.getAlnLength());
  String xml=AFPChainXMLConverter.toXML(afpChain);
  File expected=new File("src/test/resources/1w0p_1qdm.xml");
  File x=File.createTempFile("1w0p_1qdm_output","xml.tmp");
  x.deleteOnExit();
  BufferedWriter bw=new BufferedWriter(new FileWriter(x));
  bw.write(xml);
  bw.close();
  boolean match=compareXml(expected,x);
  if (!match) {
    System.err.println(xml);
    fail("AFPChain is wrong");
  }
}
