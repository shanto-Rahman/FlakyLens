@Test public void outputPipe(){
  if (Platform.getNativePlatform().isUnix()) {
    int[] outputPipe={-1,-1};
    long pid=-1;
    try {
      assertFalse(libc.pipe(outputPipe) < 0);
      assertNotSame(-1,outputPipe[0]);
      assertNotSame(-1,outputPipe[1]);
      List<SpawnFileAction> actions=Arrays.asList(dup(outputPipe[1],1));
      pid=posix.posix_spawnp("echo",actions,Arrays.asList("echo","bar"),emptyEnv);
      assertTrue(pid != -1);
      posix.libc().close(outputPipe[1]);
      ByteBuffer output=ByteBuffer.allocate(100);
      long nbytes=posix.libc().read(outputPipe[0],output,output.remaining());
      assertEquals(4L,nbytes);
      output.position((int)nbytes).flip();
      byte[] bytes=new byte[output.remaining()];
      output.get(bytes);
      assertEquals("bar",new String(bytes).trim());
    }
  finally {
      closePipe(outputPipe);
      killChild(pid);
    }
  }
}
