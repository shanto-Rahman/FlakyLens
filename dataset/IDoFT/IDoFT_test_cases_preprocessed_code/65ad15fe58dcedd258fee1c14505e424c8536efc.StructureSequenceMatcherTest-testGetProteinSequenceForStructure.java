@Test public void testGetProteinSequenceForStructure(){
Assert.assertEquals("Unreported residues",seq1.length(),prot.getLength());
Assert.assertEquals("Modified residues",seq1,prot.toString());
Assert.assertEquals("Missing residues in mapping",seq1.length(),groupIndexPos.size());
Assert.assertTrue("no mapping for group " + res,groupIndexPos.containsKey(res));
Assert.assertEquals("Wrong PDB number at pos " + res,pdbNum1[res],resnum.toString());
Assert.assertEquals("Wrong Amino acid at pos " + res,Character.valueOf(seq1.charAt(res)),aa);
}