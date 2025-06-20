@Test public void closeInput() throws IOException {
if (Platform.getNativePlatform().isUnix()) {
assertFalse(libc.pipe(outputPipe) < 0);//IT//RW
assertFalse(libc.pipe(inputPipe) < 0);//IT//RW
assertNotSame(-1,outputPipe[0]);
assertNotSame(-1,outputPipe[1]);
assertNotSame(-1,inputPipe[0]);
assertNotSame(-1,inputPipe[1]);
pid=posix.posix_spawnp("cat",actions,Arrays.asList("cat","/dev/fd/" + inputPipe[0]),emptyEnv);//RW
assertTrue(pid != -1);
assertEquals(3,posix.libc().write(inputPipe[1],ByteBuffer.wrap("foo".getBytes(Charset.forName("US-ASCII"))),3));//RW
posix.libc().close(inputPipe[1]);//RW
posix.libc().close(outputPipe[1]);//RW
long nbytes=posix.libc().read(outputPipe[0],output,output.remaining());//RW
assertEquals(0L,nbytes);
}
}