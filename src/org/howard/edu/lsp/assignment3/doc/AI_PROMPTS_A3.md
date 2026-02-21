# AI Prompts – Assignment 3

## Prompt 1
I redesigned my Assignment 2 ETL pipeline to be more object-oriented. Suggest a class design that separates Extract, Transform, and Load responsibilities.

## Prompt 2
My transformed output file is too small. Help me find why rows are being skipped and how to implement the exact row-skipping rules from Assignment 2.

## Prompt 3
Generate Javadocs for each class and all public methods for my Assignment 3 ETL redesign, and make sure behavior stays identical to Assignment 2.

## Prompt 4
Confirm my output matches the expected robust sample and that my run summary counts (rows read/transformed/skipped) are correct.

## Notes (How I used the AI suggestions)
I used the AI suggestions to split the ETL pipeline into separate classes (DataLoader, DataTransformer, DataWriter) and a Product object to encapsulate row data. I reviewed and adapted the suggestions to ensure the program kept the exact same paths, transformation order, rounding, skipping rules, and output format as Assignment 2.