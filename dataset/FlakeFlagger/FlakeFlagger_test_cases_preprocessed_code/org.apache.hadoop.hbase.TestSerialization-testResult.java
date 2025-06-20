public void testResult() throws Exception {
assertTrue("results are not equivalent, first key mismatch",result.sorted()[0].equals(deResult.sorted()[0]));
assertTrue("results are not equivalent, second key mismatch",result.sorted()[1].equals(deResult.sorted()[1]));
assertEquals(r.size(),deserialized.size());
}