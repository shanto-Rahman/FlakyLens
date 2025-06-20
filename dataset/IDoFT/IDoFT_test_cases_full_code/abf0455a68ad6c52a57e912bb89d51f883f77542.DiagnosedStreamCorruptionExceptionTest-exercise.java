@Test public void exercise() throws Exception {
  ClassicCommandTransport ct=(ClassicCommandTransport)new ChannelBuilder("dummy",null).withMode(Mode.BINARY).withBaseLoader(getClass().getClassLoader()).negotiate(new ByteArrayInputStream(payload),new NullOutputStream());
  verify(ct);
}
