@Test @Deprecated public void extendedAbstractSolution(){
  SolutionDescriptor<TestdataExtendedAbstractSolution> solutionDescriptor=TestdataExtendedAbstractSolution.buildSolutionDescriptor();
  assertMapContainsKeysExactly(solutionDescriptor.getProblemFactMemberAccessorMap());
  assertMapContainsKeysExactly(solutionDescriptor.getProblemFactCollectionMemberAccessorMap(),"problemFactList");
  assertMapContainsKeysExactly(solutionDescriptor.getEntityMemberAccessorMap());
  assertMapContainsKeysExactly(solutionDescriptor.getEntityCollectionMemberAccessorMap(),"entityList");
  TestdataExtendedAbstractSolution solution=new TestdataExtendedAbstractSolution();
  solution.setValueList(Arrays.asList(new TestdataValue("v1"),new TestdataValue("v2")));
  solution.setExtraObject(new TestdataValue("extra"));
  solution.setEntityList(Arrays.asList(new TestdataEntity("e1"),new TestdataEntity("e2")));
  assertAllCodesOfCollection(solutionDescriptor.getAllFacts(solution),"e1","e2","extra","v1","v2");
}
