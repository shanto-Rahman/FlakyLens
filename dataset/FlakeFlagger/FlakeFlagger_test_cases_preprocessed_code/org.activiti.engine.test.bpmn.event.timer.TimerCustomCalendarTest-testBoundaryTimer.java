@Deployment public void testBoundaryTimer(){
assertThat("One job is scheduled",jobs.size(),is(1));
assertThat("Job must be scheduled by custom business calendar to Date(0)",jobs.get(0).getDuedate(),is(new Date(0)));
}