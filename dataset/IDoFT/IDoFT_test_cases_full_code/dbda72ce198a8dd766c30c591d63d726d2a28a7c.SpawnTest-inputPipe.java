@Test public void inputPipe(){
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
      List<SpawnFileAction> actions=Arrays.asList(dup(inputPipe[0],0),dup(outputPipe[1],1));
      pid=posix.posix_spawnp("cat",actions,Arrays.asList("cat","-"),emptyEnv);
      assertTrue(pid != -1);
      posix.libc().close(inputPipe[0]);
      assertEquals(3,posix.libc().write(inputPipe[1],ByteBuffer.wrap("foo".getBytes(Charset.forName("US-ASCII"))),3));
      posix.libc().close(inputPipe[1]);
      posix.libc().close(outputPipe[1]);
      ByteBuffer output=ByteBuffer.allocate(100);
      long nbytes=posix.libc().read(outputPipe[0],output,output.remaining());
      assertEquals(3L,nbytes);
      output.position((int)nbytes).flip();
      byte[] bytes=new byte[output.remaining()];
      output.get(bytes);
      assertEquals("foo",new String(bytes).trim());
    }
  finally {
      closePipe(outputPipe);
      closePipe(inputPipe);
      killChild(pid);
    }
  }
}
