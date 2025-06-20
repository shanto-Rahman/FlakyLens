@Test public void testPrefixMatch(){
assertEquals(0,ruleElementSelector.getPrefixMatchLength(p));
assertEquals(0,ruleElementSelector.getPrefixMatchLength(p));
assertEquals(1,ruleElementSelector.getPrefixMatchLength(p));
assertEquals(1,ruleElementSelector.getPrefixMatchLength(p));
assertEquals(1,ruleElementSelector.getPrefixMatchLength(p));
assertEquals(2,ruleElementSelector.getPrefixMatchLength(p));
assertEquals(0,ruleElementSelector.getPrefixMatchLength(p));
}