#!/bin/sh

"${mysql[@]}" < /docker-entrypoint-initdb.d/001_dump.sql_