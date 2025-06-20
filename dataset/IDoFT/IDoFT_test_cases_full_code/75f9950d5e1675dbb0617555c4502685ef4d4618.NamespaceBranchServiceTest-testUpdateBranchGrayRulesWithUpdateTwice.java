@Test @Sql(scripts="/sql/namespace-branch-test.sql",executionPhase=Sql.ExecutionPhase.BEFORE_TEST_METHOD) @Sql(scripts="/sql/clean.sql",executionPhase=Sql.ExecutionPhase.AFTER_TEST_METHOD) public void testUpdateBranchGrayRulesWithUpdateTwice(){
  GrayReleaseRule firstRule=instanceGrayReleaseRule();
  namespaceBranchService.updateBranchGrayRules(testApp,testCluster,testNamespace,testBranchName,firstRule);
  GrayReleaseRule secondRule=instanceGrayReleaseRule();
  secondRule.setRules("[{\"clientAppId\":\"branch-test\",\"clientIpList\":[\"10.38.57.112\"]}]");
  namespaceBranchService.updateBranchGrayRules(testApp,testCluster,testNamespace,testBranchName,secondRule);
  GrayReleaseRule activeRule=namespaceBranchService.findBranchGrayRules(testApp,testCluster,testNamespace,testBranchName);
  Assert.assertNotNull(secondRule);
  Assert.assertEquals(secondRule.getAppId(),activeRule.getAppId());
  Assert.assertEquals(secondRule.getRules(),activeRule.getRules());
  Assert.assertEquals(Long.valueOf(0),activeRule.getReleaseId());
  Page<ReleaseHistory> releaseHistories=releaseHistoryService.findReleaseHistoriesByNamespace(testApp,testCluster,testNamespace,pageable);
  ReleaseHistory firstReleaseHistory=releaseHistories.getContent().get(1);
  ReleaseHistory secondReleaseHistory=releaseHistories.getContent().get(0);
  Assert.assertEquals(2,releaseHistories.getTotalElements());
  Assert.assertEquals(ReleaseOperation.APPLY_GRAY_RULES,firstReleaseHistory.getOperation());
  Assert.assertEquals(ReleaseOperation.APPLY_GRAY_RULES,secondReleaseHistory.getOperation());
  Assert.assertTrue(firstReleaseHistory.getOperationContext().contains(firstRule.getRules()));
  Assert.assertFalse(firstReleaseHistory.getOperationContext().contains(secondRule.getRules()));
  Assert.assertTrue(secondReleaseHistory.getOperationContext().contains(firstRule.getRules()));
  Assert.assertTrue(secondReleaseHistory.getOperationContext().contains(secondRule.getRules()));
}
