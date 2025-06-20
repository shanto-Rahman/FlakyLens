@Test public void testDoValidatePlanSelection(){
  final String serviceId="test-task";
  PKSClusterProvisioningTaskService service=new PKSClusterProvisioningTaskService(){
    protected String getSelfId(){
      return serviceId;
    }
  }
;
  final String projectLink=QueryUtil.PROJECT_IDENTIFIER + "some-project";
  final String planName="some-plan";
  final Set<String> tenantLinks=Collections.singleton(projectLink);
  Endpoint endpoint=new Endpoint();
  PlanSet planSet=new PlanSet();
  planSet.plans=Collections.singleton(planName);
  endpoint.planAssignments=Collections.singletonMap(projectLink,planSet);
  service.doValidatePlanSelection(planName,tenantLinks,endpoint);
  final String wrongPlan="wrong-plan";
  try {
    service.doValidatePlanSelection(wrongPlan,tenantLinks,endpoint);
    fail("Should have thrown an exception because " + wrongPlan + " is not assigned");
  }
 catch (  IllegalArgumentException ex) {
    String expectedError=String.format(PKSClusterProvisioningTaskService.INVALID_PLAN_SELECTION_MESSAGE_FORMAT,wrongPlan,serviceId);
    assertEquals(expectedError,ex.getMessage());
  }
}
