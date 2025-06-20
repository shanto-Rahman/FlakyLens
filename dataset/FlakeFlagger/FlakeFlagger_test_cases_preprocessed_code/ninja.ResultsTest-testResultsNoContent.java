@Test public void testResultsNoContent(){
assertEquals(Result.SC_204_NO_CONTENT,result.getStatusCode());
assertTrue(result.getRenderable() instanceof NoHttpBody);
}