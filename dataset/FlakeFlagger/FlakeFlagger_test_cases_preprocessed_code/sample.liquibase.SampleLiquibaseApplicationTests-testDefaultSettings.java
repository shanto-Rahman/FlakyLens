@Test public void testDefaultSettings() throws Exception {
if (serverNotRunning(ex)) {
}
assertTrue("Wrong output: " + output,output.contains("Successfully acquired change log lock") && output.contains("Creating database history " + "table with name: PUBLIC.DATABASECHANGELOG") && output.contains("Table person created")&& output.contains("ChangeSet classpath:/db/" + "changelog/db.changelog-master.yaml::1::" + "marceloverdijk ran successfully")&& output.contains("New row inserted into person")&& output.contains("ChangeSet classpath:/db/changelog/" + "db.changelog-master.yaml::2::" + "marceloverdijk ran successfully")&& output.contains("Successfully released change log lock"));
}