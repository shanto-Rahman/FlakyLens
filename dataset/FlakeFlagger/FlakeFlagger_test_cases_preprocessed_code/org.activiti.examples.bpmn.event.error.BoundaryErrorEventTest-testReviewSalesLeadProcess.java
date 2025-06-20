@Deployment(resources={"org/activiti/examples/bpmn/event/error/reviewSalesLead.bpmn20.xml"}) public void testReviewSalesLeadProcess(){
assertEquals("Provide new sales lead",task.getName());
assertEquals("Review customer rating",ratingTask.getName());
assertEquals("Review profitability",profitabilityTask.getName());
assertEquals("Provide additional details",provideDetailsTask.getName());
assertEquals("Review customer rating",reviewTasks.get(0).getName());
assertEquals("Review profitability",reviewTasks.get(1).getName());
}