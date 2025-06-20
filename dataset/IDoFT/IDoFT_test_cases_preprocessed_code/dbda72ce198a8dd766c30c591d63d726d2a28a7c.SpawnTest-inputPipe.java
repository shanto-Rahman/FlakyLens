@Test public void inputPipe(){
if (Platform.getNativePlatform().isUnix()) {
assertFalse(libc.pipe(outputPipe) < 0);//IT//RW
assertFalse(libc.pipe(inputPipe) < 0);//IT//RW
assertNotSame(-1,outputPipe[0]);
assertNotSame(-1,outputPipe[1]);
assertNotSame(-1,inputPipe[0]);
assertNotSame(-1,inputPipe[1]);
pid=posix.posix_spawnp("cat",actions,Arrays.asList("cat","-"),emptyEnv);//RW
assertTrue(pid != -1);
posix.libc().close(inputPipe[0]);//RW
assertEquals(3,posix.libc().write(inputPipe[1],ByteBuffer.wrap("foo".getBytes(Charset.forName("US-ASCII"))),3));//RW
posix.libc().close(inputPipe[1]);//RW
posix.libc().close(outputPipe[1]);//RW
long nbytes=posix.libc().read(outputPipe[0],output,output.remaining());//RW
assertEquals(3L,nbytes);
assertEquals("foo",new String(bytes).trim());
}
}