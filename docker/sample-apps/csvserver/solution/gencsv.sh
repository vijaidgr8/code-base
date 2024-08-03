#!/bin/bash

if [ "$#" -ne 2 ]; then
  echo "Usage: ./gencsv.sh <start_index> <end_index>"
  exit 1
fi

start_index=$1
end_index=$2

# Generate the random number within the given range
generate_random_number() {
  echo $((RANDOM % 1000))
}

# Generate the CSV entries and write them to the inputFile
generate_csv_entries() {
  for ((index=start_index; index<=end_index; index++)); do
    random_number=$(generate_random_number)
    echo "$index, $random_number" >> inputFile
  done
}

generate_csv_entries

