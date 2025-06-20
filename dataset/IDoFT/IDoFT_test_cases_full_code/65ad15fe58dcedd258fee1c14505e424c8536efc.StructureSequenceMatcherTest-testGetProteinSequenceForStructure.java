@Test public void testGetProteinSequenceForStructure(){
  Map<Integer,Group> groupIndexPos=new HashMap<Integer,Group>();
  ProteinSequence prot=StructureSequenceMatcher.getProteinSequenceForStructure(struct1,groupIndexPos);
  Assert.assertEquals("Unreported residues",seq1.length(),prot.getLength());
  Assert.assertEquals("Modified residues",seq1,prot.toString());
  Assert.assertEquals("Missing residues in mapping",seq1.length(),groupIndexPos.size());
  for (int res=0; res < seq1.length(); res++) {
    Assert.assertTrue("no mapping for group " + res,groupIndexPos.containsKey(res));
    Group g=groupIndexPos.get(res);
    ResidueNumber resnum=g.getResidueNumber();
    Character aa=StructureTools.get1LetterCodeAmino(g.getPDBName());
    Assert.assertEquals("Wrong PDB number at pos " + res,pdbNum1[res],resnum.toString());
    Assert.assertEquals("Wrong Amino acid at pos " + res,Character.valueOf(seq1.charAt(res)),aa);
  }
}
