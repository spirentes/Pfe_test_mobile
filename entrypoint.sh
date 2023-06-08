#!/bin/bash
# Define ANSI escape sequences for colors
GREEN='\033[0;32m'
NC='\033[0m' # No Color
# Split the APPIUM_PORTS environment variable into an array
IFS=',' read -ra PORTS <<< "$APPIUM_PORTS"

# Start an Appium server for each port in the array
for PORT in "${PORTS[@]}"; do
  appium -p $PORT &
done

# Start the Selenium hub and node
  echo -e "${GREEN}--------Starting Selenium hub-----------${NC}"
java -jar /opt/selenium/selenium-server.jar hub & 
#java -jar /opt/selenium/selenium-server.jar node --config $NODE_CONFIG_FILE
# Get the path to the directory containing the TOML files
TOML_DIR="/opt/selenium/tomlfiles"

# Loop through each file in the directory and run it as a Selenium node
for TOML_FILE in "$TOML_DIR"/*.toml; do
    echo "Starting Selenium node with config file: $TOML_FILE"
    java -jar /opt/selenium/selenium-server.jar node --config "$TOML_FILE" &
done
wait