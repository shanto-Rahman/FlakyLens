@Test public void testKarateToJson(){
assertTrue(Script.matchNamed(MatchType.EQUALS,"foo",null,"{ foo: null, bar: 10 }",ctx).pass);
assertTrue(Script.matchNamed(MatchType.EQUALS,"bar",null,"{ bar: 10 }",ctx).pass);
}