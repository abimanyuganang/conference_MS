#!/bin/sh
set -e
host="$1"
shift
cmd="$@"

echo "Waiting for MySQL at $host..."
echo "Username: $SPRING_DATASOURCE_USERNAME"
echo "Password: $SPRING_DATASOURCE_PASSWORD"

until mysql -h "$host" -u "$SPRING_DATASOURCE_USERNAME" -p"$SPRING_DATASOURCE_PASSWORD" -e "SELECT 1" > /dev/null 2>&1; do
  echo "MySQL is unavailable - sleeping"
  sleep 2
done

echo "MySQL is up - executing command"
exec $cmd
