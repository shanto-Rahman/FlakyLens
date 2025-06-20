public void testScanner_DeleteOneFamilyNotAnother() throws IOException {
assertTrue(Bytes.equals(rowA,results.get(0).getRow()));
assertTrue(Bytes.equals(rowB,results.get(0).getRow()));
}