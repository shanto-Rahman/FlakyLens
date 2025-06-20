/** 
 * This tests the behaviour of the diagnosis blocking on a non-completed stream, as the writer end is kept open.
 */
@Test(timeout=3000) public void blockingStreamShouldNotPreventDiagnosis() throws Exception {
  try (FastPipedInputStream in=new FastPipedInputStream();FastPipedOutputStream out=new FastPipedOutputStream(in)){
    out.write(payload);
    ClassicCommandTransport ct=(ClassicCommandTransport)new ChannelBuilder("dummy",null).withMode(Mode.BINARY).withBaseLoader(getClass().getClassLoader()).negotiate(in,new NullOutputStream());
    verify(ct);
  }
 }
