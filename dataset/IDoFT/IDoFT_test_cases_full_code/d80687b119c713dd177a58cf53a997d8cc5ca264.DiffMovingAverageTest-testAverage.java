@Test public void testAverage(){
  int counter=0;
  while (counter < 5) {
    timeDiffMovingAverage.recordTimestamp();
    try {
      Thread.sleep(100);
      counter++;
    }
 catch (    InterruptedException e) {
      e.printStackTrace();
    }
  }
  long currentAverage=timeDiffMovingAverage.getCurrentAverage();
  assertTrue(currentAverage >= 90 && currentAverage <= 110);
}
