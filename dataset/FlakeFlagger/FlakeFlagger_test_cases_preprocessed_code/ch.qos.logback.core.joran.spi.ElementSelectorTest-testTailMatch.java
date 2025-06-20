@Test public void testTailMatch(){
assertEquals(0,ruleElementSelector.getTailMatchLength(p));
assertEquals(1,ruleElementSelector.getTailMatchLength(p));
assertEquals(1,ruleElementSelector.getTailMatchLength(p));
assertEquals(1,ruleElementSelector.getTailMatchLength(p));
assertEquals(1,ruleElementSelector.getTailMatchLength(p));
assertEquals(1,ruleElementSelector.getTailMatchLength(p));
assertEquals(2,ruleElementSelector.getTailMatchLength(p));
}