public void testResultDynamicBuild() throws Exception {
assertTrue(Bytes.equals(row,rowA));
assertTrue("results are not equivalent, first key mismatch",result.sorted()[0].equals(deResult.sorted()[0]));
assertTrue("results are not equivalent, second key mismatch",result.sorted()[1].equals(deResult.sorted()[1]));
assertTrue("results are not equivalent, first key mismatch",result.raw()[0].equals(deResult.raw()[0]));
assertTrue("results are not equivalent, second key mismatch",result.raw()[1].equals(deResult.raw()[1]));
}