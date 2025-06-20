@Test public void try_to_find_first_port() throws Exception {
  int start=7050;
  int result=PortFinder.findFirstAvailableBetween(start,start + 10);
  assertThat(result).isEqualTo(start);
  try (ServerSocket ss=new ServerSocket(start)){
    ss.setReuseAddress(true);
    int secondResult=PortFinder.findFirstAvailableBetween(start,start + 10);
    assertThat(secondResult).isEqualTo(start + 1);
  }
   int thirdResult=PortFinder.findFirstAvailableBetween(start,start + 10);
  assertThat(thirdResult).isEqualTo(start);
}
