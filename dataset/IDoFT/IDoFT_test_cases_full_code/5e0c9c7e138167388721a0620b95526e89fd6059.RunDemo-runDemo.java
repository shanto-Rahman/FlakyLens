@Test public void runDemo() throws IOException {
  System.setProperty("rrd4j.demopath",testFolder.getRoot().getAbsolutePath());
  Demo.main(new String[]{});
  DataProcessorDemo.main(new String[]{});
  MinMax.main(new String[]{});
  RrdTutorial.main(new String[]{});
  HeartbeatFix.main(new String[]{testFolder.getRoot().getAbsolutePath(),"700"});
}
