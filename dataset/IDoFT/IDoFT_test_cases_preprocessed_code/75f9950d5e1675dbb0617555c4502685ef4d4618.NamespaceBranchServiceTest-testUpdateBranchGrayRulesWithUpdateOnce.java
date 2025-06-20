@Test @Sql(scripts="/sql/namespace-branch-test.sql",executionPhase=Sql.ExecutionPhase.BEFORE_TEST_METHOD) @Sql(scripts="/sql/clean.sql",executionPhase=Sql.ExecutionPhase.AFTER_TEST_METHOD) public void testUpdateBranchGrayRulesWithUpdateOnce(){
Assert.assertNotNull(activeRule);
Assert.assertEquals(rule.getAppId(),activeRule.getAppId());
Assert.assertEquals(rule.getRules(),activeRule.getRules());
Assert.assertEquals(Long.valueOf(0),activeRule.getReleaseId());
Assert.assertEquals(1,releaseHistories.getTotalElements());
Assert.assertEquals(ReleaseOperation.APPLY_GRAY_RULES,releaseHistory.getOperation());
Assert.assertEquals(0,releaseHistory.getReleaseId());
Assert.assertEquals(0,releaseHistory.getPreviousReleaseId());
Assert.assertTrue(releaseHistory.getOperationContext().contains(rule.getRules()));
}