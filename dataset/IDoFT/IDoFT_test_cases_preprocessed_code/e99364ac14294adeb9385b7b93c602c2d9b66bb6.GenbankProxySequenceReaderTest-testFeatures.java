@Test public void testFeatures() throws IOException, InterruptedException, CompoundNotFoundException {
Assert.assertNotNull("protein sequence is null",seq);
Assert.assertNotNull(seq.getDescription());
Assert.assertNotNull(seq.getAccession().getID());
if (seq.getAccession().getIdentifier() != null) {
Assert.assertEquals(gi,seq.getAccession().getIdentifier());
}
Assert.assertNotNull(seq.getTaxonomy().getID());
Assert.assertNotNull(Integer.decode(seq.getTaxonomy().getID().split(":")[1]));
Assert.assertNotNull(taxonName);
if (seq.getFeaturesByType("CDS").size() > 0) {
Assert.assertNotNull(codedBy);
Assert.assertTrue(!codedBy.isEmpty());
}
Thread.sleep(500);
}