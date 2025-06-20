@Test(timeout=2000) public void workerShouldStopEvenIfInterruptExceptionConsumedWithinSubappender(){
assertTrue(delayingListAppender.interrupted);
}