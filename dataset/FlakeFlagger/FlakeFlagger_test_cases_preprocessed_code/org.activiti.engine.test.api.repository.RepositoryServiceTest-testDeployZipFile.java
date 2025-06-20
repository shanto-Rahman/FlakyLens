/** 
 * This test was added due to issues with unzip of JDK 7, where the default is changed to UTF8 instead of the platform encoding (which is, in fact, good). However, some platforms do not create UTF8-compatible ZIP files. The tested zip file is created on OS X (non-UTF-8). See https://blogs.oracle.com/xuemingshen/entry/non_utf_8_encoding_in
 */
public void testDeployZipFile(){
assertNotNull(inputStream);
assertNotNull(zipInputStream);
assertEquals(6,repositoryService.createProcessDefinitionQuery().count());
}