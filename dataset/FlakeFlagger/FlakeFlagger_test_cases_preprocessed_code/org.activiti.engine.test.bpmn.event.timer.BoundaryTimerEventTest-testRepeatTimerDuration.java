@Deployment public void testRepeatTimerDuration() throws Exception {
if (previousDueDate != null) {
assertTrue(job.getDuedate().getTime() - previousDueDate.getTime() >= twentyFourHours);
}
}