# Database Notes

### Database Configuration
```sh

# Database configuration file postgresql.yaml runs: postgres database and pgadmin dbms

# Start database
docker compose -f postgresql.yml up

# Start database in detached mode
docker compose -f postgresql.yml up -d

# Stop database
docker compose -f postgresql.yml down



# Default database credentials
# Host name/address: localhost:5432
# Username: user
# Password: password

# PGAdmin connection
# Host name/address: postgres:5432
# Username: user
# Password: password

```
