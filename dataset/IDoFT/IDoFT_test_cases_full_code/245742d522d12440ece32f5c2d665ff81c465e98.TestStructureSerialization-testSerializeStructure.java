@Test public void testSerializeStructure() throws IOException, StructureException, ClassNotFoundException {
  PDBFileReader reader=new PDBFileReader();
  reader.getFileParsingParameters().setParseSecStruc(true);
  Structure sin=reader.getStructure("src/test/resources/2gox.pdb");
  ByteArrayOutputStream baos=new ByteArrayOutputStream();
  ObjectOutputStream objectOut=new ObjectOutputStream(baos);
  objectOut.writeObject(sin);
  objectOut.close();
  byte[] bytes=baos.toByteArray();
  ByteArrayInputStream bais=new ByteArrayInputStream(bytes);
  ObjectInputStream objectIn=new ObjectInputStream(bais);
  Structure sout=(Structure)objectIn.readObject();
  objectIn.close();
  assertEquals(sin.nrModels(),sout.nrModels());
  assertEquals(sin.getChains().size(),sout.getChains().size());
  assertEquals(sin.getName(),sout.getName());
  assertEquals(sin.toString(),sout.toString());
}
