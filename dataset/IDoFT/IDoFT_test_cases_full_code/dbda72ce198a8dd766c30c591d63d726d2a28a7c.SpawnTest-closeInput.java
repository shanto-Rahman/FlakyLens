@Test public void closeInput() throws IOException {
  if (Platform.getNativePlatform().isUnix()) {
    int[] outputPipe={-1,-1};
    int[] inputPipe={-1,-1};
    long pid=-1;
    try {
      assertFalse(libc.pipe(outputPipe) < 0);
      assertFalse(libc.pipe(inputPipe) < 0);
      assertNotSame(-1,outputPipe[0]);
      assertNotSame(-1,outputPipe[1]);
      assertNotSame(-1,inputPipe[0]);
      assertNotSame(-1,inputPipe[1]);
      List<SpawnFileAction> actions=Arrays.asList(dup(outputPipe[1],1),open("/dev/null",2,OpenFlags.O_WRONLY.intValue(),0444),close(inputPipe[0]),close(inputPipe[1]));
      pid=posix.posix_spawnp("cat",actions,Arrays.asList("cat","/dev/fd/" + inputPipe[0]),emptyEnv);
      assertTrue(pid != -1);
      assertEquals(3,posix.libc().write(inputPipe[1],ByteBuffer.wrap("foo".getBytes(Charset.forName("US-ASCII"))),3));
      posix.libc().close(inputPipe[1]);
      posix.libc().close(outputPipe[1]);
      ByteBuffer output=ByteBuffer.allocate(100);
      long nbytes=posix.libc().read(outputPipe[0],output,output.remaining());
      assertEquals(0L,nbytes);
    }
  finally {
      closePipe(inputPipe);
      closePipe(outputPipe);
      killChild(pid);
    }
  }
}
