private void execute(List<String> expected,String genericExporterFolder,String aptFolder) throws IOException {
for (File file : new File("target/" + genericExporterFolder + "/com/querydsl/apt/domain").listFiles()) //RO
File other=new File("target/" + aptFolder + "/com/querydsl/apt/domain",file.getName());
if (!other.exists() || !other.isFile()) {
}
if (!result1.equals(result2)) {
if (!expected.contains(file.getName())) {
}
}
if (!expected.isEmpty()) {
fail("Following expected failures succeeded: " + expected);
}
if (!failures.isEmpty()) {
fail("Failed with " + failures.size() + " failures, "+ successes+ " succeeded, "+ failures);
}
}