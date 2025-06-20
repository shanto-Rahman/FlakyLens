@Test public void failed_rename() throws IOException {
if (!EnvUtilForTests.isWindows()) return;
File file=new File(fileName);//RO
fos=new FileOutputStream(fileName);
if (fos != null) fos.close();
}