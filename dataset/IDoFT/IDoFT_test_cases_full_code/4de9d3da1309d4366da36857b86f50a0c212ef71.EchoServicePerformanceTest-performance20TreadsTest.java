@Test public void performance20TreadsTest() throws Exception {
  int thread=20;
  long timetook=multiExecute(totalRequestSize,thread,"world","hello world");
  printResult(in,out,totalRequestSize,timetook,thread);
}
