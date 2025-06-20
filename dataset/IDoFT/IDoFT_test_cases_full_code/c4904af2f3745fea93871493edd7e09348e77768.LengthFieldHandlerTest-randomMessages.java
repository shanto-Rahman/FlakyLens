@Test public void randomMessages() throws Exception {
  final LengthFieldHandler handler=new LengthFieldHandler();
  Queue<Pair<String,byte[]>> messages=new LinkedList<>();
  final Random random=new Random();
  ByteArrayOutputStream stream=new ByteArrayOutputStream();
  for (int i=0; i < 50; i++) {
    int length=random.nextInt(1 << ((random.nextInt(3) + 1) * 8));
    byte[] bytes=new byte[length];
    random.nextBytes(bytes);
    messages.add(Pair.of("nop",bytes));
    stream.write((length >> 24) & 0xff);
    stream.write((length >> 16) & 0xff);
    stream.write((length >> 8) & 0xff);
    stream.write((length) & 0xff);
    stream.write(bytes);
  }
  Queue<Pair<String,byte[]>> queue=new LinkedList<>();
  final HandlerContext context=new MockContext(queue);
  ByteArrayInputStream inputStream=new ByteArrayInputStream(stream.toByteArray());
  while (inputStream.available() > 0) {
    int length=random.nextInt(1 << ((random.nextInt(3) + 1) * 8));
    final byte[] bytes=new byte[length];
    int count=inputStream.read(bytes);
    handler.onRead(context,Pair.of("nop",Arrays.copyOf(bytes,count)));
  }
  assertEquals(messages.size(),queue.size());
  while (!queue.isEmpty()) {
    assertArrayEquals(messages.remove().getRight(),queue.remove().getRight());
  }
}
