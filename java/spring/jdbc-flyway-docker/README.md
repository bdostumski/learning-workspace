# Flyway migrations (Flyway, database migrations made easy)
1. Start migration:<br/>
    1.1. Maven: \> mvn flyway:migrate -Dflyway.url=... -Dflyway.user=... -Dflyway.password=... (main example of migration)<br/>
    1.2. Java: Flyway flyway = Flyway.configure().dataSource(url, user, password).load(); flyway.migrate();
    1.3. Command line: \> flyway migrate -url=... -user=... -password=...

2. \> mvn flyway:migrate (Migrates the schema to the latest version. Flyway will create the schema history table automatically if it doesn’t exist)
3. \> mvn flyway:clean (Drops all objects (tables, views, procedures, triggers, …) in the configured schemas. The schemas are cleaned in the order specified by the schemas and defaultSchema property)
4. \> mvn flyway:info (Prints the details and status information about all the migrations)
5. \> mvn flyway:validate (Validate applied migrations against resolved ones (on the filesystem or classpath) to detect accidental changes that may prevent the schema(s) from being recreated exactly. Validation fails if: differences in migration names, types or checksums are found, versions have been applied that aren’t resolved locally anymore, versions have been resolved that haven’t been applied yet)
6. \> mvn flyway:undo (Undoes the most recently applied versioned migration)
7. \> mvn flyway:baseline (Baselines an existing database, excluding all migrations up to and including baselineVersion)
8. \> mvn flyway:repair (Repairs the Flyway schema history table. This will perform the following actions: Remove any failed migrations on databases without DDL transactions (User objects left behind must still be cleaned up manually), Realign the checksums, descriptions and types of the applied migrations with the ones of the available migrations)
