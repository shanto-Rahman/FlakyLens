@Deployment public void testInfiniteRepeatingTimer() throws Exception {
if (previousDueDate != null) {
assertTrue(job.getDuedate().getTime() - previousDueDate.getTime() >= twentyFourHours);
}
}