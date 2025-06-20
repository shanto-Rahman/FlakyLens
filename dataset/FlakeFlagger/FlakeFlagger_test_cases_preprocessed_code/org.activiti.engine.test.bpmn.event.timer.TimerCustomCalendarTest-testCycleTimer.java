@Deployment public void testCycleTimer(){
assertThat("One job is scheduled",jobs.size(),is(1));
assertThat("Job must be scheduled by custom business calendar to Date(0)",jobs.get(0).getDuedate(),is(new Date(0)));
assertThat("One job is scheduled (repetition is 2x)",jobs.size(),is(1));
assertThat("Job must be scheduled by custom business calendar to Date(0)",jobs.get(0).getDuedate(),is(new Date(0)));
assertThat("There must be no job.",jobs.isEmpty());
}