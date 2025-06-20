public void testSplit3() throws Exception {
assertTrue("Should not be able to split if low > high",false);
assertTrue("Returned split should have 3 parts but has " + parts.length,parts.length == 3);
assertTrue("Returned split but should have failed",parts == null);
}