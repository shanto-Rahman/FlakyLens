@Test public void testParseQueryParam(){
Assert.assertTrue(!entity.getTerms().isEmpty());
Assert.assertEquals(entity.getTerms().get(0).getColumn(),"name");
Assert.assertEquals(entity.getTerms().get(0).getType(),Term.Type.and);
Assert.assertEquals(entity.getTerms().get(1).getColumn(),"name");
Assert.assertEquals(entity.getTerms().get(1).getTermType(),"like");
Assert.assertEquals(entity.getTerms().get(1).getType(),Term.Type.or);
Assert.assertEquals(entity.getTerms().get(2).getType(),Term.Type.and);
Assert.assertTrue(!entity.getTerms().get(2).getTerms().isEmpty());
Assert.assertEquals(entity.getTerms().get(2).getTerms().get(0).getTermType(),"like");
Assert.assertEquals(entity.getTerms().get(2).getTerms().get(1).getTermType(),"gt");
Assert.assertTrue(!entity.getTerms().get(2).getTerms().get(2).getTerms().isEmpty());
Assert.assertEquals(entity.getTerms().get(2).getTerms().get(2).getTerms().get(0).getTermType(),"like");
Assert.assertEquals(entity.getTerms().get(2).getTerms().get(2).getTerms().get(1).getTermType(),"gt");
}