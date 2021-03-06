#!/usr/bin/env bash

set -euo pipefail
which psql > /dev/null

docker run --rm --name pg-docker -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=dev -d -p 5432:5432 -v myPostgresVolume:/var/lib/postgresql postgres
sleep 3
export PGPASSWORD=postgres
docker cp schema.sql pg-docker:/var/lib/postgresql
docker cp data.sql pg-docker:/var/lib/postgresql
psql -U postgres -d dev -h localhost -f schema.sql
psql -U postgres -d dev -h localhost -f data.sql
