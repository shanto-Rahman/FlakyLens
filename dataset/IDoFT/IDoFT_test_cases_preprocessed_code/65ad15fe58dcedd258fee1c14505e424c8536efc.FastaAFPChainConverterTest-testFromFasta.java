@Test public void testFromFasta() throws IOException, StructureException, CompoundNotFoundException {
assertEquals("Wrong number of EQRs",33,afpChain.getNrEQR());
assertEquals("Wrong number of alnLength",53,afpChain.getAlnLength());
File expected=new File("src/test/resources/1w0p_1qdm.xml");//RO
BufferedWriter bw=new BufferedWriter(new FileWriter(x));
if (!match) {
fail("AFPChain is wrong");
}
}