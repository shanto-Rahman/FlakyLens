@Test public void doTest(){
switch (this.type) {
case BASIC:    testBasicRelation();
  break;
case COPULA_HEAD:testBasicRelationWithCopulaAsHead();
break;
case NON_COLLAPSED:testNonCollapsedRelation();
break;
case NON_COLLAPSED_SEPARATOR:testNonCollapsedSeparator();
break;
case COLLAPSED:testCollapsedRelation();
break;
case CC_PROCESSED:testCCProcessedRelation();
break;
default:throw new RuntimeException("No test defined for test type " + this.type);
}
}
