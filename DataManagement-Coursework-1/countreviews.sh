#!/bin/bash

for file in $1/*;
do
filename=$(basename $file);
printf $filename" "|sed 's/.dat//g';
cat $file|grep 'Content'|sed 's/>/ /g'|awk 'BEGIN{count=0}($1=="<Content"){count+=1}END{print count}';done|sort -k2,2gr

